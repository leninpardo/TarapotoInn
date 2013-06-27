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
 * @author Fredesvinda
 */
public class Perfil extends Principal{
    Principal p;
    String b;
public Perfil()throws IOException
{
    p=new Principal();
}

   public String[][]  index()
{
  
 return p.query("perfil");
}
public String[]  getColumnIndex()
{
  //Principal p=new Principal();
 return p.getLabelColumn("perfil");
}

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
         
        
            
            CallableStatement pa = p.getCadenaProcedure("inn_perfil",3);
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
