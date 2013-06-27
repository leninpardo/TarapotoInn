/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Perfil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class PermisoController extends MultiActionController {
 public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
          Perfil p=new Perfil();
                     mv.addObject("url","Modulo");
                     
                   //list=p.query("perfil");
                  //nom=p.getLabelColumn("vista_modu");
                    mv.addObject("title","Modulos registrados");
                  mv.addObject("data",p.query("perfil"));
                   mv.setViewName("Permiso/index");
		return  mv;

	}
   
}
