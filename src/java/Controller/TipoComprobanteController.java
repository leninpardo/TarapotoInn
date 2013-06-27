/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoComprobante;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class TipoComprobanteController extends MultiActionController {
    private String[][] list;
    private String[] nom;
 public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   TipoComprobante th=new  TipoComprobante();
                   list=th.query("tipo_comprobante");
                  nom=th.getLabelColumn("tipo_comprobante");
                  mv.addObject("table", "tipo_comprobante");
                  
                    mv.addObject("url","TipoComprobante");
                    mv.addObject("title","Tipo de Comprobantes registrados");
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
          mv.addObject("title","registrando nuevos Tipo de comprobante");
          mv.addObject("url","TipoComprobante");
             mv.setViewName("TipoComprobante/new");
         return  mv;
   }
    
    public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoComprobante tc=new TipoComprobante();
          String b=tc.save(request,response);
          if("true".equals(b))
          {
              mv.addObject("msg","correcto"); 
              
              mv=index(request,response);
              response.sendRedirect("TipoComprobante?option=index");
              
          }
          else
          {
              mv.addObject("msg",b); 
                   mv.addObject("cod",request.getParameter("cod"));
                        //mv.addObject("code",request.getParameter("cod"));
                        
             mv.addObject("descrip",request.getParameter("descripcion"));
              mv.addObject("serie",request.getParameter("serie"));
               mv.addObject("numero",request.getParameter("numero"));
              mv.setViewName("TipoComprobante/new");
             
          }
          
            mv.addObject("url","TipoComprobante");
       
          
        
         return  mv;
   } 
   
    
     public ModelAndView edit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
           TipoComprobante tp=new TipoComprobante();
          String cod=request.getParameter("cod");
          String d[]=tp.FindQuery("tipo_comprobante", cod);
          mv.addObject("cod",cod);
             mv.addObject("descrip",d[1]);
                 mv.addObject("serie",d[2]);
                  mv.addObject("numero",d[3]);
              mv.addObject("url","TipoComprobante");
           mv.setViewName("TipoComprobante/new");
        
         return  mv;
   } 
    
}
