/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compra;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class CuotaPago extends MultiActionController{
       String list[][]=null,nom[]=null;
          public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                   Compra c=new Compra();
                   list=c.query("vista_cuotapago");
                  nom=c.getLabelColumn("vista_cuotapago");
                  mv.addObject("table", "cuota_pagos");
                  
                    mv.addObject("title","Cuotas de pago registrados");
                     mv.addObject("url","CuotaPago");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("CuotaPago/index");
		return  mv;

	}
               public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
        Compra c=new Compra();
          mv.addObject("title","registrando Cuotas de pago");
                   list=c.query("vista_compra");
                  nom=c.getLabelColumn("vista_compra");
            mv.addObject("url","CuotaPago");
    mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
             mv.setViewName("CuotaPago/new");
         return  mv;
   }
    
      
}
