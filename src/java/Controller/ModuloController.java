/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Modulo;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author lenin
 */
public class ModuloController extends MultiActionController{
String list[][],nom[];
    private Integer offset;
public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
           
                   Modulo m=new Modulo();
                     mv.addObject("url","Modulo");
                   list=m.query("vista_modulo order by codigo asc");
                  nom=m.getLabelColumn("vista_modulo");
                  mv.addObject("table", "modulo");
                  
                    mv.addObject("title","Modulos registrados");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("Modulo/index");
		return  mv;

	}

	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
            Modulo m=new Modulo();
             ModelAndView mv=new ModelAndView();
		 mv.addObject("title","registrando Modulos");
                  mv.addObject("padre",m.query("vista_modulos where submodulo=0"));
                  
          mv.addObject("url","Modulo");
             mv.setViewName("Modulo/new");
         return  mv;

	}
        
          public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
          Modulo m=new Modulo();
          String b=m.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
              
              mv=index(request,response);
              
              response.sendRedirect("Modulo?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("urlm",request.getParameter("urlm"));
                mv.addObject("modulo",request.getParameter("modulo"));
              mv.setViewName("Modulo/new");
             
          }
          
            mv.addObject("url","Modulo");
       
          
        
         return  mv;
   }

	public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
         Modulo m=new Modulo();
          String cod=request.getParameter("cod");
          String d[]=m.FindQuery("modulo", cod);
          mv.addObject("cod",cod);
          mv.addObject("padre", m.query("vista_modulos where submodulo=0"));
             mv.addObject("modulo",d[1]);
               mv.addObject("urlm",d[2]);
              mv.addObject("url","Modulo");
           mv.setViewName("Modulo/new");
        
         return  mv;

	}
}
