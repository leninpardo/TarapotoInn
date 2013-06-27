/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ubigeo;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class UbigeoController extends MultiActionController{
    
     public ModelAndView provincia(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                 Ubigeo U=new Ubigeo();
                  mv.addObject("name","provincia");
                  
                    mv.addObject("data",U.query("vista_provincia where substr(cast(id_ubigeo as char(6)),1,2)='"+request.getParameter("cod")+"'"));
                   
                   mv.setViewName("select");
		return  mv;

	} 
          public ModelAndView provincia(String id) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                 Ubigeo U=new Ubigeo();
                  mv.addObject("name","provincia");
                  
                    mv.addObject("data",U.query("vista_provincia where substr(cast(id_ubigeo as char(6)),1,2)='"+id+"'"));
                   
                   mv.setViewName("select");
		return  mv;

	} 
       public ModelAndView distrito(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
              
                 Ubigeo U=new Ubigeo();
                  mv.addObject("name","provincia");
                    mv.addObject("data",U.query("vista_distrito where substr(cast(id_ubigeo as char(6)),1,4)='"+request.getParameter("cod")+"'"));
                   
                   mv.setViewName("select");
		return  mv;

	} 
     
}
