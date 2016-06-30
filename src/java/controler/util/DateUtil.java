/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Younes
 */
public class DateUtil {

    public static java.sql.Date getSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.sql.Timestamp convertFromDateToTimestamp(java.util.Date date) {
        return new java.sql.Timestamp(date.getTime());
    }

    public static java.sql.Timestamp getSqlDateTime(java.util.Date date) {
        return new java.sql.Timestamp(date.getTime());
    }

    public static String getYearOfCurrentDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        return simpleDateFormat.format(new Date());
    }

    public static String formateDate(String pattern, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static String formateDate(Date date) {
        return formateDate("dd/MM/yyyy", date);
    }

    public static int calculDifference(Date date1, Date date2) {

        return (date1.getYear() - date2.getYear()) * 12 + date1.getMonth() - date2.getMonth();

    }

    public static boolean compareYearMonthDay(Date date1, Date date2) {

        if (date1 != null) {
            System.out.println("ha date 1 :: year " + date1.getYear() + " monthhh =" + date1.getMonth() + " day ==> " + date1.getDate());
        }
        System.out.println("ha date 2 :: year " + date2.getYear() + " monthhh =" + date2.getMonth() + " day ==> " + date2.getDate());

        if (date1 == null) {
            return false;
        }
        if (date1.getYear() == date2.getYear()) {
            if (date1.getMonth() == date2.getMonth()) {
                if (date1.getDate() == date2.getDate()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
