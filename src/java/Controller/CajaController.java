/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Almacen;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class CajaController extends MultiActionController{
        String list[][]=null,nom[]=null;
      public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                   Almacen a=new Almacen();
                   list=a.query("vista_caja");
                  nom=a.getLabelColumn("vista_caja");
                  // mv.addObject("table", "almacen");
                  mv.addObject("table", "caja");
                  
                    mv.addObject("title","Registro de cajas");
                     mv.addObject("url","Caja");   
                  mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list);
                   mv.setViewName("Caja/index");
                   
		return  mv;

	}
    
}
