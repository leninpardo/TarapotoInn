/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Almacen;
import model.Ubicacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class UbicacionController extends MultiActionController{
    String list[][]=null,nom[]=null;
     
      public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                   Ubicacion u=new Ubicacion();
                   list=u.query("vista_ubicacion");
                  nom=u.getLabelColumn("vista_ubicacion");
                  
                    mv.addObject("title","Ubicaciones registrados");
                     mv.addObject("url","Ubicacion");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("Ubicacion/index");
		return  mv;

	}
      
            public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
       
          mv.addObject("title","registrando nuevas ubicaciones");
          
              Ubicacion u=new Ubicacion();
            
              mv.addObject("data",u.query("almacen"));
          mv.addObject("url","Ubicacion");
             mv.setViewName("Ubicacion/new");
         return  mv;
   }
            
            
      public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         Ubicacion u=new Ubicacion();
          String b=u.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
               mv=index(request,response);
              response.sendRedirect("Ubicacion?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("Ubicacion/new");
             
          }
          
            mv.addObject("url","Ubicacion");
       
          
        
         return  mv;
   }  
           public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           Almacen a=new Almacen();
          String cod=request.getParameter("cod");
          String d[]=a.FindQuery("ubicacion", cod);
          mv.addObject("cod",cod);
          mv.addObject("data",a.query("almacen"));
             mv.addObject("descrip",d[2]);
              mv.addObject("url","Ubicacion");
           mv.setViewName("Ubicacion/new");
        
         return  mv;
   }  
}
