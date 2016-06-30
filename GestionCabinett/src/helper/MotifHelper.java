/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import javax.swing.JTable;
import view.Motiff;

/**
 *
 * @author User
 */
public class MotifHelper extends AbstractHelper<Motiff>{

   
    private static AbstractHelperItem[] titres;

   static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("Id_Motif","id")
            };
    }

    public MotifHelper(JTable jTable, List<Motiff> list) {
        super(titres, jTable, list);
    }

    public MotifHelper(JTable jTable) {
        super(titres, jTable);

    }
    
    
}
