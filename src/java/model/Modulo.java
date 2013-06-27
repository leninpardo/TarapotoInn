/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenin
 */
public class Modulo extends Principal{
    private final Principal p;
    String b;
    public Modulo()
    {
        p=new Principal();
    }
    
     public String save(HttpServletRequest request, HttpServletResponse response)throws Exception {
        int ncod;
    int op;
       if((request.getParameter("cod")==""))
            {
                ncod=0;op=1;
            }
            else{
                String cod=request.getParameter("cod");  
                ncod=Integer.valueOf(cod);
             op=2; 
            }
       
        try {
         
        
            
            CallableStatement pa = p.getCadenaProcedure("inn_modulo",6);
              pa.setInt(1, op);
              pa.setInt(2, ncod);
              pa.setString(3, request.getParameter("modulo"));
              pa.setString(4, request.getParameter("urlm"));
              pa.setInt(5, Integer.parseInt(request.getParameter("estado")));
              pa.setInt(6,Integer.parseInt(request.getParameter("padre")));
              pa.execute();
              b="true";
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoHabitacion.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            b=ex.getMessage();
            //ex.printStackTrace();
        }
        return b;
    }

}
