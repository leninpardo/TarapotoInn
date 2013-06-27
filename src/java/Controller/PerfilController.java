/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Perfil;
import model.TipoHabitacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class PerfilController extends MultiActionController{
     String list[][]=null,nom[]=null;
    public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   Perfil p=new Perfil();
                   list=p.index();
                  nom=p.getColumnIndex();
                    mv.addObject("url","Perfil");
                    mv.addObject("title","Perfil Registrados");
                     mv.addObject("cant",nom.length);
                     
                     mv.addObject("nom",nom);//nombres de los campos ee vectores
                     
                   mv.addObject("list",list );//matriz de datos
                   mv.setViewName("Perfil/index");
		return  mv;

	} 
       public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String perfil[][];
          mv.addObject("title","registrando nuevas Habitaciones");
          
              Perfil p=new Perfil();
              perfil=p.index();
             // mv.addObject("perfils",perfil);
          mv.addObject("url","Perfil");
             mv.setViewName("Perfil/new");
         return  mv;
   }
          public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           Perfil p=new Perfil();
          String b=p.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
               mv=index(request,response);
              response.sendRedirect("Perfil?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("Perfil/new");
             
          }
          
            mv.addObject("url","Perfil");
       
          
        
         return  mv;
   } 
          
          //edit
             public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           Perfil p=new Perfil();
          String cod=request.getParameter("cod");
          String d[]=p.FindQuery("perfil", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
              mv.addObject("url","Perfil");
           mv.setViewName("Perfil/new");
        
         return  mv;
   } 
          
          
}
