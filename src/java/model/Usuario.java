/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import Controller.bean.BeanLogin;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lenin
 */
//import lib.Archivo;
//import lib.Conexion;
public class Usuario extends Principal{
  static String A[][];
    private static BeanLogin busuario;

public static BeanLogin login(String user,String clave)
{
    String querys="vista_sesion where usuario='"+user+"' and clave='"+clave+"'";
        try {
            Principal p=new Principal();
            A=p.query(querys);
           // System.out.print(A[0][2]);
             busuario=new BeanLogin(A[0][0],A[0][1],A[0][2],A[0][3],A[0][4],A[0][5]);
        } catch (Exception ex) {
          //  Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
           // String A[][]=new String[0][0];
           // A[0][0]=ex.getMessage();
            //JOptionPane.showMessageDialog(null,ex.toString());
           //ex.printStackTrace();
           //System.out.print(ex.getMessage());
           //ex.printStackTrace();
            ex.printStackTrace();
        }
     return busuario;
}
public static void main(String args[]) 
{

   String l[];
   l=new String[3];
   l[0]="1";
   l[1]="0";
   l[2]="xx";
        CallableStatement pa;
        Principal p=new Principal();
         //System.out.print(p.Cone);
        try {
           pa = p.getCadenaProcedure("inn_tipo_habitacion",3);
               
              
           // pa=p.Cone.prepareCall("{call inn_tipo_habitacion(?,?,?)}");
            pa.setInt(1, 1);
              pa.setInt(2, 0);
              pa.setString(3,"pruebazzz");
             
              pa.execute();
             ResultSet rs = (ResultSet)pa.getObject(1);
                while (rs.next()){
                    System.out.println(rs.getBoolean(1));
                    //System.out.println(rs.getString("NOMBRE"));
                }
                rs.close();
                pa.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
       // System.out.print(login("admin","123").getUsuario());
        
        // p.save_procedure("inn_tipo_habitacion",new Object[]{1,0,"xx"});
        // System.out.println(l[1]);inn_tipo_habitacion(op int4, cod int4, descrip varchar)
}

}
