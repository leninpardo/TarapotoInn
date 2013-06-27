/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoRuta;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class TipoRutaController extends MultiActionController{
    private String[][] list;
    private String[] nom;
           public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   TipoRuta th=new  TipoRuta();
                   list=th.query("tipo_ruta");
                  nom=th.getLabelColumn("tipo_ruta");
                    mv.addObject("url","TipoRuta");
                    mv.addObject("title","Tipo de Rutas registrados");
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
          mv.addObject("title","registrando nuevas tipos Rutas");
          mv.addObject("url","TipoRuta");
             mv.setViewName("TipoRuta/new");
         return  mv;
   }
                  
   public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoRuta tr=new TipoRuta();
          String b=tr.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
              
              mv=index(request,response);
              response.sendRedirect("TipoRuta?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("TipoRuta/new");
             
          }
          
            mv.addObject("url","TipoRuta");
       
          
        
         return  mv;
   }  
                  
   public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoRuta tr=new TipoRuta();
          String cod=request.getParameter("cod");
          String d[]=tr.FindQuery("tipo_ruta", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
              mv.addObject("url","TipoRuta");
           mv.setViewName("TipoRuta/new");
        
         return  mv;
   } 
     
}
