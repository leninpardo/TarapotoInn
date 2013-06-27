/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;

/**
 *
 * @author lenin
 */
public class Cliente extends Principal{
      public String[][]  index() throws IOException
{
  Principal p=new Principal();
 // System.out.println("hola");
 return p.query("vista_cliente");
}
public String[]  getColumnIndex() throws IOException
{
  Principal p=new Principal();
 return p.getLabelColumn("vista_cliente");
}
}
