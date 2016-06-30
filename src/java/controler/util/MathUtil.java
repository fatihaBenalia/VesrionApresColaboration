/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.util;



/**
 *
 * @author Younes
 */
public class MathUtil {
     public static Long calculerMax(Long[] resultas) {
        Long max = new Long(0);
        max = resultas[0];
        for (int i = 0; i < 2; i++) {
            
                if (max.compareTo(resultas[i]) == -1) {
                    max = resultas[i];
                    System.out.println("ha max :::" + max);
                }
            
        }
        return max;
    }
}
