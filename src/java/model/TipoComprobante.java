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
public class TipoComprobante extends Principal{
    private final Principal p;
    private String b;
    public TipoComprobante()
    {
        p=new Principal();
    }
    
    
        public String save(HttpServletRequest request,
			HttpServletResponse response)throws Exception
{
    int ncod;
    int op;
    
       if((request.getParameter("code")==""))
            {
                ncod=0;op=1;
            ncod=Integer.valueOf(request.getParameter("cod"));
            }
            else{
                String cod=request.getParameter("code");  
                ncod=Integer.valueOf(cod);
             op=2; 
            }
        try {
         
        
            
            CallableStatement pa = p.getCadenaProcedure("inn_tipo_comprobante",5);
            pa.setInt(1, op);
              pa.setInt(2, ncod);
              pa.setString(3, request.getParameter("descripcion"));
              pa.setInt(4, Integer.parseInt(request.getParameter("serie")));
                pa.setInt(5, Integer.parseInt(request.getParameter("numero")));
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
