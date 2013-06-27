/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Estadia;
import model.TipoHabitacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Fredesvinda
 */
public class EstadiaController extends MultiActionController{
      String list[][]=null,nom[]=null;
      int cant_hab,residuo,cociente,total_filas;
    public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   Estadia e=new Estadia();
                   list=e.index();
                  nom=e.getColumnIndex();
                 cant_hab=e.getfilas();
                 residuo=cant_hab%8;
                 cociente =(cant_hab-residuo)/8;
                 if(residuo==0){
total_filas = cociente;

}
else {
total_filas = cociente+1;
}
                 
 mv.addObject("total_filas",total_filas);
                   mv.addObject("cant_hab",cant_hab);
                    mv.addObject("url","Estadia");
                    mv.addObject("title","Modulo de Estadias.<h1>Habitaciones dispoibles<h1>");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("habit",list );
                   mv.setViewName("Estadia/index");
		return  mv;

	}
}
