/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
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
public class TipoHabitacion extends Principal{
     Principal  p;
     String b;
    public TipoHabitacion() throws IOException
    {
       p=new Principal();
    }
    
 /*public String[][]  index()
{
  
 return p.query("tipo_habitacion");
}
public String[]  getColumnIndex()
{
  //Principal p=new Principal();
 return p.getLabelColumn("tipo_habitacion");
}
/*public String[][] findquery(String id)
{
    Principal p=new Principal();
 return p.query("select *from tipo_habitacion where id_tipo_habitacion=");
}*/
public String save(HttpServletRequest request,
			HttpServletResponse response)throws Exception
{
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
         
        
            
            CallableStatement pa = p.getCadenaProcedure("inn_tipo_habitacion",3);
            pa.setInt(1, op);
              pa.setInt(2, ncod);
              pa.setString(3, request.getParameter("descripcion"));
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
