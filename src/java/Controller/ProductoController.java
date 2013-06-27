/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Almacen;
import model.Producto;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class ProductoController extends MultiActionController{
    private String[][] list;
    private String[] nom;
        public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                   Producto a=new Producto();
                   list=a.query("vista_producto");
                  nom=a.getLabelColumn("vista_producto");
                  
                  mv.addObject("table", "producto");
                  
                    mv.addObject("title","Productos registrados");
                     mv.addObject("url","Producto");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("Producto/index");
		return  mv;

	}
             public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String Alm[][];
         Producto p=new Producto();
          mv.addObject("title","registrando nuevos Productos");
          mv.addObject("ubi",p.query("vista_ubicacion"));
          mv.addObject("tipo_producto",p.query("tipo_producto"));
          mv.addObject("url","Producto");
             mv.setViewName("Producto/new");
         return  mv;
   }
              public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
      Producto p=new Producto();
          String b=p.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
               mv=index(request,response);
              response.sendRedirect("Producto?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descrip",request.getParameter("descripcion"));
             mv.addObject("stock",request.getParameter("stock"));
             mv.addObject("pc",request.getParameter("pc"));
              mv.setViewName("Producto/new");
             
          }
          
            mv.addObject("url","Producto");
       
          
        
         return  mv;
   }  
     public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
          Producto a=new Producto();
          String cod=request.getParameter("cod");
          String d[]=a.FindQuery("producto", cod);
          mv.addObject("cod",cod);
          mv.addObject("ubi",a.query("vista_ubicacion"));
           mv.addObject("tipo_producto",a.query("tipo_producto"));
             mv.addObject("stock",d[3]);
             mv.addObject("pc",d[5]);
               mv.addObject("obs",d[6]);
             mv.addObject("descrip",d[7]);
              mv.addObject("url","Producto");
           mv.setViewName("Producto/new");
        
         return  mv;
   }             
              

}
