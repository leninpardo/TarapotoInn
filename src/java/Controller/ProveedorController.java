/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proveedor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class ProveedorController extends MultiActionController{
        private String[][] list;
    private String[] nom;
        public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   Proveedor pr=new  Proveedor();
                   list=pr.query("vista_proveedor");
                  nom=pr.getLabelColumn("vista_proveedor");
                  mv.addObject("table", "proveedor");
                  
                    mv.addObject("url","Proveedor");
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
       
         Proveedor p=new Proveedor();
       
           mv.addObject("region", p.query("vista_departamento"));
          mv.addObject("title","Registrando nuevos Proveedor");
          
             
          mv.addObject("url","Proveedor");
             mv.setViewName("Proveedor/new");
         return  mv;
   }
                  public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
      Proveedor p=new Proveedor();
          String b=p.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
               mv=index(request,response);
              response.sendRedirect("Proveedor?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
              mv.addObject("region", p.query("vista_departamento"));
                   mv.addObject("cod",request.getParameter("cod"));
             mv.addObject("rz",request.getParameter("rz"));
             mv.addObject("representante",request.getParameter("representante"));
             mv.addObject("ruc",request.getParameter("ruc"));
                mv.addObject("direccion",request.getParameter("direccion"));
                mv.addObject("telefono",request.getParameter("telefono"));
                mv.addObject("email",request.getParameter("email"));
              mv.setViewName("Proveedor/new");
             
          }
          
            mv.addObject("url","Proveedor");
       
          
        
         return  mv;
   } 
                  
                       public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
          Proveedor a=new Proveedor();
          String cod=request.getParameter("cod");
          String d[]=a.FindQuery("proveedor", cod);
          mv.addObject("cod",cod);
          String [][]r;
          String id=d[1];
          r=a.query("vista_departamento");
          mv.addObject("region",r);
             mv.addObject("rz",d[2]);
             mv.addObject("representante",d[3]);
                mv.addObject("ruc",d[4]);
               mv.addObject("telefono",d[6]);
             mv.addObject("direccion",d[7]);
             UbigeoController ub=new UbigeoController();
             ub.provincia("");
             //ub.distrito(request, response);
             mv.addObject("provincia",id.substring(0, 4)+"00");
              mv.addObject("email",d[8]);
              mv.addObject("url","Proveedor");
           mv.setViewName("Proveedor/new");
        
         return  mv;
   } 
    
}
