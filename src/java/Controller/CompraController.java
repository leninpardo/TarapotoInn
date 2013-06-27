/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compra;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
	@Controller
public class CompraController extends MultiActionController{
       String list[][]=null,nom[]=null;
      public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                   Compra c=new Compra();
                   list=c.query("vista_compra");
                  nom=c.getLabelColumn("vista_compra");
                  
                    mv.addObject("title","Compras registrados");
                     mv.addObject("url","Compra");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("Compra/index");
		return  mv;

	}
      
           public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
        Compra c=new Compra();
          mv.addObject("title","registrando nuevos Almacenes");
          //proveedor
          String listp[][];
          String []nomp;
          listp=c.query("vista_proveedor");
          nomp=c.getLabelColumn("vista_proveedor");
           mv.addObject("cantp",nomp.length);
                     mv.addObject("nomp",nomp);
          mv.addObject("proveedores",listp);
          
          //productos
               String listpr[][];
          String []nompr;
          listpr=c.query("vista_producto");
          nompr=c.getLabelColumn("vista_producto");
           mv.addObject("cantpr",nompr.length);
                     mv.addObject("nompr",nompr);
          mv.addObject("productos",listpr);
          
          
           
          mv.addObject("url","Compra");
             mv.setViewName("Compra/new");
         return  mv;
   }
           

         
 
}
