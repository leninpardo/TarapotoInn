/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fredesvinda
 */
public class Proveedor extends Principal{
    private final Principal p;
    private String b;
    public Proveedor()
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
       //BigDecimal costo;
           //costo = (BigDecimal)(request.getParameter("costo"));
      // Double costo;
       //costo=Double.valueOf(request.getParameter("costo"));
        try {
         
        
            
            CallableStatement pa = p.getCadenaProcedure("inn_proveedor",10);
              pa.setInt(1, op);
              pa.setInt(2, ncod);
              pa.setString(3, request.getParameter("distrito"));
              pa.setString(4, request.getParameter("rz"));
              pa.setString(5, request.getParameter("representante"));
             pa.setString(6, request.getParameter("ruc"));
             pa.setInt(7, 0);
             pa.setString(8, request.getParameter("telefono"));
            pa.setString(9, request.getParameter("direccion"));
             pa.setString(10, request.getParameter("email"));
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
