/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Profesion;
import model.TipoHabitacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class ProfesionController  extends MultiActionController{
   String list[][]=null,nom[]=null;
    public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   Profesion p=new Profesion();
                   list=p.query("profesion");
                  nom=p.getLabelColumn("profesion");
                  
                  mv.addObject("table", "profesion");
                    mv.addObject("url","Profesion");
                    mv.addObject("title","Profesiones registrados");
                     mv.addObject("cant",nom.length);
                     
                     mv.addObject("nom",nom);//nombres de los campos ee vectores
                     
                   mv.addObject("list",list );//matriz de datos
                   mv.setViewName("Profesion/index");
		return  mv;

	}
    
      public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
        
          mv.addObject("title","registrando nuevas Profesiones");
          mv.addObject("url","Profesion");
             mv.setViewName("Profesion/new");
         return  mv;
   }
    public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           Profesion p=new Profesion();
          String b=p.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
               mv=index(request,response);
             response.sendRedirect("Profesion?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("Profesion/new");
             
          }
          
            mv.addObject("url","Profesion");
       
          
        
         return  mv;
   }  
    
   public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoHabitacion th=new TipoHabitacion();
          String cod=request.getParameter("cod");
          String d[]=th.FindQuery("Profesion", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
              mv.addObject("url","Profesion");
           mv.setViewName("Profesion/new");
        
         return  mv;
   }    
}
