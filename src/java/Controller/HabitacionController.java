/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Habitacion;
import model.TipoHabitacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author lenin
 */
public class HabitacionController extends MultiActionController{
     String list[][]=null,nom[]=null;
  public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                   Habitacion h=new Habitacion();
                   list=h.query("vista_habitacion");
                  nom=h.getLabelColumn("vista_habitacion");
                  
                  mv.addObject("table", "habitacion");
                  
                    mv.addObject("title","Habitaciones registrados");
                     mv.addObject("url","Habitacion");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("Habitacion/index");
		return  mv;

	}  
  
   public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String tiph[][];
          mv.addObject("title","registrando nuevas Habitaciones");
          
              TipoHabitacion th=new TipoHabitacion();
              tiph=th.query("tipo_habitacion");
              mv.addObject("th",tiph);
          mv.addObject("url","Habitacion");
             mv.setViewName("Habitacion/new");
         return  mv;
   }
   public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        String tiph[][];
         ModelAndView mv=new ModelAndView();
           Habitacion h=new Habitacion();
          String b=h.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
                 mv=index(request,response);
               response.sendRedirect("Habitacion?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                TipoHabitacion th=new TipoHabitacion();
              tiph=th.query("tipo_habitacion");
              mv.addObject("th",tiph);
          mv.addObject("url","Habitacion");
             mv.addObject("cod",request.getParameter("cod"));
              mv.addObject("numero",request.getParameter("numero"));
              mv.addObject("costo",request.getParameter("costo"));
             mv.addObject("descripcion",request.getParameter("descripcion"));
               mv.setViewName("Habitacion/new");
          }
          
            mv.addObject("url","Habitacion");
       
         
        
         return  mv;
   }  
   
 public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
          String tiph[][];
              TipoHabitacion th=new TipoHabitacion();
              tiph=th.query("tipo_habitacion");
              mv.addObject("th",tiph);
          mv.addObject("url","Habitacion");
          String cod=request.getParameter("cod");
          Habitacion h=new Habitacion();
           String d[]=h.FindQuery("habitacion", cod);
          mv.addObject("cod",cod);
           mv.addObject("numero",d[2]);
            mv.addObject("costo",d[3]);
             mv.addObject("descripcion",d[4]);
             mv.setViewName("Habitacion/new");
        
         return  mv;
   }   
    
   }

