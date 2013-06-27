/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.sql.*;

import lib.Conexion;
import lib.DatabaseFactory;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenin
 */

 public class Principal {
    private static Statement s;
 
static Connection Cone;
    private static ResultSet r;
    private static ResultSetMetaData resulsetmd;
    private static int numColumn;
    private static int numfilas;
    private static String[][] A;
    public static String[] LabelColum;
    static Conexion C,c1;
    static String db;
  static String e;
  static  String Data[];
 static Object param[];
    private CallableStatement pa;
 
    
public Principal()  
{
       super();
      
  
            
            File miDir = new File("");
           
            // String ruta = miDir.getAbsolutePath() + "/config.ini";//local cunDO ESTA EN PRODUCCION
          
         String ruta="/Users/Fredesvinda/config.ini";
            //String ruta="c://Config.ini";
           try
           {

               DatabaseFactory dbf=new DatabaseFactory();
               String cadena=dbf.create(ruta);
              // JOptionPane.showInputDialog(null, cadena);
                    C = new Conexion(cadena, ruta);
                    Cone = C.getConexion();
                    this.e=C.getError();
           }
           catch(Exception ex)
           {
               this.e=ex.getMessage();
               //JOptionPane.showMessageDialog(null,ex.toString());
               //this.e=ex.getMessage();
              ex.printStackTrace();
           }
              
      
}
public static String getError()
{
   // return e;
    return e;
}
public int getfilas()
{
    return numfilas;
}
    //@SuppressWarnings("static-access")
public   String[][] query(String Q) 
    {
       /* cone=(Connection) new conexion();*/
       //conexion c=new conexion();
         // System.out.print(db);
String sql="select *from "+Q;
        try {
             
           //Conexion c=new Conexion();
          //   c1=new Conexion("","");
         // Cone=c1.getConexion();
          //System.out.print(Cone);
            s = Cone.createStatement();
            r=s.executeQuery(sql);
            resulsetmd=r.getMetaData();
            //Obtiene los metadatos del ResultSet
           numColumn= resulsetmd.getColumnCount();
          /* LabelColum=new String[numColumn];
           for(int k=0;k<numColumn;k++)
           {
               LabelColum[k]=resulsetmd.getColumnName(k+1);
           }*/
           
            //System.out.println(numColumn);

          // numfilas=r.getRow();
            numfilas=0;
            while(r.next())
            {
                numfilas++;
                
            }
            //System.out.println( numfilas);
           // LabelColum=new String[numfilas];
            //LabelColum=new String[numColumn];
           A=new String[numfilas][numColumn];

           //Ubica el cursor antes del a primera fila
           //r.beforeFirst();
           //obtenemos el array de datos de la base de datos
          /* int k=0;
           while(r.next())
           {
               for(int j=0;j<numColumn;j++)
               {
                   A[k][j]=r.getString(j+1);
               }
               k++;
           }*/
           r.close();
             r=s.executeQuery(sql);
           for(int i=0;i<numfilas;i++){

				//Va a la siguiente fila

			    	r.next();

		    		for(int j=0;j<numColumn;j++){

				//Obtiene el valor de cada una de las columnas en la fila actual
                                   //System.out.println(r.getString(j+1));
		    			A[i][j]=r.getString(j+1);			    		}

		    	}

           ///finalizamos para retornar

        } catch (SQLException ex) {
           // Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null,ex.toString());
            //A[0][0]="error de conexion"+ex.getMessage();
            ex.printStackTrace();
             
        }
        return A;

    }
    
    public String[] FindQuery(String Q,String camp)
    {
      
        try
        {
             s = Cone.createStatement();
            r=s.executeQuery("select *from "+Q);
            //System.out.println(Q+" where "+id+"= "+camp);
            resulsetmd=r.getMetaData();
            //Obtiene los metadatos del ResultSet
           numColumn= resulsetmd.getColumnCount();
             Data=new String[numColumn];
           String id=resulsetmd.getColumnName(1);
           r.close();
           String sql="select *from "+Q+" where "+id+"= "+camp;
          // System.out.println(sql);
             r=s.executeQuery(sql);
         
           while(r.next())
           {
               for(int k=0;k<numColumn;k++)
               {
                   Data[k]=r.getString(k+1);
               }
           }
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
        return Data;
    }
    public String[] getLabelColumn(String Q)
    {

        try {

           //Conexion c=new Conexion();
          //   c1=new Conexion("","");
         // Cone=c1.getConexion();
          //System.out.print(Cone);
            String sql="select *from "+Q;
            s = Cone.createStatement();
            r=s.executeQuery(sql);
            resulsetmd=r.getMetaData();
            //Obtiene los metadatos del ResultSet
           numColumn= resulsetmd.getColumnCount();
           LabelColum=new String[numColumn];
           for(int k=0;k<numColumn;k++)
           {
               LabelColum[k]=resulsetmd.getColumnName(k+1);
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  LabelColum;
    }
    
  public  CallableStatement getCadenaProcedure(String procedure,int cant)
    {
       
       
        String llaves;
        String call="{call "+procedure+"(";
        for(int j=1;j<=cant;j++)
        {
            if(j==1)
            {
               llaves="?"; 
            }
            else{
               llaves=",?";  
            }
          call=call+llaves; 
        }
        call=call + ")}";
        System.out.print(call);
        
       

        try {
            pa = Cone.prepareCall(call);
            /*
            for(int k=0;k<param.length;k++)
            {
            pa.setObject(k+1, param[k]);
            }
            pa.execute();
            msg="Datos llenados correctamente";*/
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        
        return pa;
    }
    
    public String delete(String table,String cod)
    {
        String msg = null;
        try
        {
            msg="true";
             s = Cone.createStatement();
            r=s.executeQuery("select *from "+table);
            //System.out.println(Q+" where "+id+"= "+camp);
            resulsetmd=r.getMetaData();
            //Obtiene los metadatos del ResultSet
           numColumn= resulsetmd.getColumnCount();
             Data=new String[numColumn];
           String id=resulsetmd.getColumnName(1);
           r.close();
           
           String sql="delete from "+table+" where "+id+"= "+cod;
             s.executeUpdate(sql);
             r.close();
         
          
        }
        catch(SQLException ex)
        {
            //ex.getMessage();
            msg=ex.getMessage();
            
        }
        
        return msg;
    }
    
}
