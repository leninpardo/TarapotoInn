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
public class AlmacenController extends MultiActionController{
      String list[][]=null,nom[]=null;
      public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                   Almacen a=new Almacen();
                   list=a.query("almacen");
                  nom=a.getLabelColumn("almacen");
                  
                   mv.addObject("table", "almacen");
                   
                    mv.addObject("title","Almacenes registrados");
                     mv.addObject("url","Almacen");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("index");
		return  mv;

	} 
      
      public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String Alm[][];
          mv.addObject("title","registrando nuevos Almacenes");
          
              /*Almacen a=new Almacen();
              Alm=a.query("Almacen");
              mv.addObject("th",Alm);*/
          mv.addObject("url","Almacen");
             mv.setViewName("Almacen/new");
         return  mv;
   }

      public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         Almacen th=new Almacen();
          String b=th.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
               mv=index(request,response);
              response.sendRedirect("Almacen?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("Almacen/new");
             
          }
          
            mv.addObject("url","Almacen");
       
          
        
         return  mv;
   }  
    
     public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           Almacen a=new Almacen();
          String cod=request.getParameter("cod");
          String d[]=a.FindQuery("Almacen", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
              mv.addObject("url","Almacen");
           mv.setViewName("Almacen/new");
        
         return  mv;
   }  
}
