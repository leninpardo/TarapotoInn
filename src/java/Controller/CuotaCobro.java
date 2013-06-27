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
public class CuotaCobro extends MultiActionController{
       String list[][]=null,nom[]=null;
         public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                   Compra c=new Compra();
                   list=c.query("vista_cuotacobro");
                  nom=c.getLabelColumn("vista_cuotacobro");
                  mv.addObject("table", "cuota_cobros");
                  
                    mv.addObject("title","Cuotas de cobro registrados");
                     mv.addObject("url","CuotaCobro");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("CuotaCobro/index");
		return  mv;

	}
         
         
         public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
        Compra c=new Compra();
          mv.addObject("title","registrando Cuotas de pago");
                   list=c.query("vista_venta");
                  nom=c.getLabelColumn("vista_venta");
            mv.addObject("url","CuotaCobro");
    mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
             mv.setViewName("CuotaCobro/new");
         return  mv;
   }
       
}
