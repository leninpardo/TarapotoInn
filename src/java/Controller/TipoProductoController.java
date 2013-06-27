/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoProducto;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class TipoProductoController extends MultiActionController{
    private String[][] list;
    private String[] nom;
        public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   TipoProducto th=new  TipoProducto();
                   list=th.query("tipo_producto");
                  nom=th.getLabelColumn("tipo_producto");
                  mv.addObject("table", "tipo_producto");
                  
                    mv.addObject("url","TipoProducto");
                    mv.addObject("title","Tipo de Productos registrados");
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
          mv.addObject("title","registrando nuevos Productos");
          mv.addObject("url","TipoProducto");
             mv.setViewName("TipoProducto/new");
         return  mv;
   }
    
            public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoProducto tp=new TipoProducto();
          String b=tp.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
              
              mv=index(request,response);
              response.sendRedirect("TipoProducto?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.setViewName("TipoProducto/new");
             
          }
          
            mv.addObject("url","TipoProducto");
       
          
        
         return  mv;
   } 
   
                
   public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoProducto tp=new TipoProducto();
          String cod=request.getParameter("cod");
          String d[]=tp.FindQuery("tipo_producto", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
              mv.addObject("url","TipoProducto");
           mv.setViewName("TipoProducto/new");
        
         return  mv;
   } 
        
}
