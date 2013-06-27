/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoServicio;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class TipoServicioController extends MultiActionController{
     private String[][] list;
    private String[] nom;
        public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   TipoServicio th=new  TipoServicio();
                   list=th.query("tipo_servicio");
                  nom=th.getLabelColumn("tipo_servicio");
                    mv.addObject("url","TipoServicio");
                    mv.addObject("title","Tipo de Servicio registrados");
                     mv.addObject("cant",nom.length);
                     
                     mv.addObject("nom",nom);//nombres de los campos ee vectores
                     
                   mv.addObject("list",list );//matriz de datos
                   mv.setViewName("index");
		return  mv;

	}
        
        public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String tiph[][];
          mv.addObject("title","Registrando tipos de servicio");
          mv.addObject("url","TipoServicio");
             mv.setViewName("TipoServicio/new");
         return  mv;
   }
    
            public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoServicio tp=new TipoServicio();
          String b=tp.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
              
              mv=index(request,response);
              response.sendRedirect("TipoServicio?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("TipoServicio/new");
             
          }
          
            mv.addObject("url","TipoServicio");
       
          
        
         return  mv;
   } 
   
                
   public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoServicio tp=new TipoServicio();
          String cod=request.getParameter("cod");
          String d[]=tp.FindQuery("tipo_servicio", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
              mv.addObject("url","TipoServicio");
           mv.setViewName("TipoServicio/new");
        
         return  mv;
   } 
        
    
}
