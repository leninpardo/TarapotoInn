/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.TipoHabitacion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
/**
 *
 * @author lenin
 */
public class ClienteController extends MultiActionController{
  String list[][]=null,nom[]=null;
  public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                
                   Cliente c=new Cliente();
                   list=c.index();
                  nom=c.getColumnIndex();
                  
                  mv.addObject("table", "cliente");
                  
                    mv.addObject("title","Clientes registrados");
                      mv.addObject("url","Cliente");
                     mv.addObject("cant",nom.length);
                     mv.addObject("nom",nom);
                   mv.addObject("list",list );
                   mv.setViewName("Cliente/index");
		return  mv;

	}     
     public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         String cr[][];
          mv.addObject("title","registrando nuevos Cliente");
          
           
          mv.addObject("url","Cliente");
             mv.setViewName("Cliente/new");
         return  mv;
   }
}
