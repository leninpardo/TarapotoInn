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
public class Estadia extends Principal{
 Principal  p;
    public Estadia() throws IOException
    {
       p=new Principal();
    }
    public String[][] index() {
       return p.query("vista_habitacion");
    }

    public String[] getColumnIndex() {
       return p.getLabelColumn("vista_habitacion");
    }

   
}
