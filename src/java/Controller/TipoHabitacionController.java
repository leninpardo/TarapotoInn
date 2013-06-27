/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoHabitacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author lenin
 */
public class TipoHabitacionController extends MultiActionController {
    String list[][]=null,nom[]=null;
    public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   TipoHabitacion th=new TipoHabitacion();
                   list=th.query("tipo_habitacion");
                  nom=th.getLabelColumn("tipo_habitacion");
                  mv.addObject("table", "almacen");
                  
                    mv.addObject("url","tipo_habitacion");
                    mv.addObject("title","Tipo de Habitaciones registrados");
                     mv.addObject("cant",nom.length);
                     mv.addObject("table", "tipo_habitacion");
                     mv.addObject("nom",nom);//nombres de los campos ee vectores
                     
                   mv.addObject("list",list );//matriz de datos
                   mv.setViewName("TipoHabitacion/index");
		return  mv;

	}
    
      public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String tiph[][];
          mv.addObject("title","registrando nuevas Habitaciones");
          mv.addObject("url","TipoHabitacion");
             mv.setViewName("TipoHabitacion/new");
         return  mv;
   }
    public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoHabitacion th=new TipoHabitacion();
          String b=th.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
              
              mv=index(request,response);
              response.sendRedirect("TipoHabitacion?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("TipoHabitacion/new");
             
          }
          
            mv.addObject("url","TipoHabitacion");
       
          
        
         return  mv;
   }  
    
   public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoHabitacion th=new TipoHabitacion();
          String cod=request.getParameter("cod");
          String d[]=th.FindQuery("tipo_habitacion", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
              mv.addObject("url","TipoHabitacion");
           mv.setViewName("TipoHabitacion/new");
        
         return  mv;
   }   
}
