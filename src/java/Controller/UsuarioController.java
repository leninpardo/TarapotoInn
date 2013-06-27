/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Perfil;
import model.Profesion;
import model.Usuario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/** 
 *
 * @author lenin el Bàrbaro, el temible,gengis kan,etc.
 */
public class UsuarioController extends MultiActionController{

    String list[][]=null,nom[]=null;
    public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
                   ModelAndView mv=new ModelAndView();
                 
                   Usuario U=new Usuario();
                   list=U.query("vista_sesion");
                  nom=U.getLabelColumn("vista_sesion");
                    mv.addObject("url","Usuario");
                    mv.addObject("title","Usuarios registrados");
                     mv.addObject("cant",nom.length);
                     
                     mv.addObject("nom",nom);//nombres de los campos ee vectores
                     
                   mv.addObject("list",list );//matriz de datos
                   mv.setViewName("Usuario/index");
		return  mv;

	}
      public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         ModelAndView mv=new ModelAndView();
         Profesion pr=new Profesion();
         Usuario U=new Usuario();
         String profesion[][],perfil[][];
         profesion=pr.query("profesion");
         Perfil p=new Perfil();
         mv.addObject("profesion", profesion);
          mv.addObject("perfil", p.query("Perfil"));
           mv.addObject("region", U.query("vista_departamento"));
          mv.addObject("title","registrando nuevos Usuarios");
          
             
          mv.addObject("url","Usuario");
             mv.setViewName("Usuario/new");
         return  mv;
   }
    

}