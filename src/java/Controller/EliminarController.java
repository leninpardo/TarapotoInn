/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Principal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class EliminarController extends MultiActionController{
        public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
                   ModelAndView mv=new ModelAndView();
                   Principal p=new Principal();
                   String msg=p.delete(request.getParameter("table"), request.getParameter("cod"));
                   mv.addObject("msg", msg);
                   mv.setViewName("msg");
		return  mv;

	}
    
}
