/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItemServicio;
import model.TipoServicio;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class ItemServicioController extends MultiActionController{
    private String[][] list;
    private String[] nom;
        public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   ItemServicio it=new  ItemServicio();
                   list=it.query("vista_servicios");
                  nom=it.getLabelColumn("vista_servicios");
                  
                  mv.addObject("table", "item_servicio");
                  
                    mv.addObject("url","ItemServicio");
                    mv.addObject("title","Servicios registrados");
                     mv.addObject("cant",nom.length);
                     
                     mv.addObject("nom",nom);//nombres de los campos ee vectores
                     
                   mv.addObject("list",list );//matriz de datos
                   mv.setViewName("index");
		return  mv;

	}
        
          
   public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String tips[][];
          mv.addObject("title","Registrando nuevos Items Servicios");
          
              ItemServicio th=new  ItemServicio();
              tips=th.query("tipo_servicio");
              mv.addObject("ts",tips);
          mv.addObject("url","ItemServicio");
             mv.setViewName("ItemServicio/new");
         return  mv;
   }
   
   public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        String tiph[][];
         ModelAndView mv=new ModelAndView();
           ItemServicio h=new ItemServicio();
          String b=h.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
                 mv=index(request,response);
               response.sendRedirect("ItemServicio?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                TipoServicio th=new TipoServicio();
              tiph=th.query("tipo_servicio");
              mv.addObject("ts",tiph);
          mv.addObject("url","Habitacion");
             mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("descripcion",request.getParameter("descripcion"));
               mv.setViewName("ItemServicio/new");
          }
          
            mv.addObject("url","ItemServicio");
       
         
        
         return  mv;
   } 
   
    public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
          String tiph[][];
              TipoServicio th=new TipoServicio();
              tiph=th.query("tipo_servicio");
              mv.addObject("ts",tiph);
          mv.addObject("url","ItemServicio");
          String cod=request.getParameter("cod");
          ItemServicio h=new ItemServicio();
           String d[]=h.FindQuery("item_servicio", cod);
          mv.addObject("cod",cod);
             mv.addObject("descripcion",d[2]);
             mv.setViewName("ItemServicio/new");
        
         return  mv;
   } 
    
}
