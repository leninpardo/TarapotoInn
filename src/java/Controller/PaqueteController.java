/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paquete;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class PaqueteController extends MultiActionController{
    private String[][] list;
    private String[] nom;
 public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
           
                   Paquete p=new Paquete();
                     mv.addObject("url","Paquete");
                   list=p.query("paquetes");
                  nom=p.getLabelColumn("paquetes");
                  mv.addObject("table", "Paquetes");
                  
                    mv.addObject("title","Paquetes registrados");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("index");
		return  mv;

	} 
       public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String tiph[][];
          mv.addObject("title","registrando nuevos Paquetes");
          mv.addObject("url","Paquete");
             mv.setViewName("Paquete/new");
         return  mv;
   }
       
        public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           Paquete p=new Paquete();
          String b=p.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
              
              mv=index(request,response);
              response.sendRedirect("Paquete?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("Paquete/new");
             
          }
          
            mv.addObject("url","Paquete");
       
          
        
         return  mv;
   } 
    
        
        public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           Paquete tp=new Paquete();
          String cod=request.getParameter("cod");
          String d[]=tp.FindQuery("paquetes", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
              mv.addObject("url","Paquete");
           mv.setViewName("Paquete/new");
        
         return  mv;
   } 
        
}
