/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.bean.BeanLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Principal;
import model.Usuario;

/**
 *
 * @author lenin
 */
public class LoginController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

             BeanLogin bu;
           String user,clave;
           user=request.getParameter("user");
           clave=request.getParameter("clave");
         Usuario u=new Usuario();
           bu=u.login(user, clave);


          if(bu!=null)
           {

                request.getSession().setAttribute("user", bu.getUsuario());
             request.getSession().setAttribute("nombres", bu.getNombre());
             request.getSession().setAttribute("idusuario", bu.getId());
               request.getSession().setAttribute("idperfil", bu.getIdperfil());
                 request.getSession().setAttribute("perfil", bu.getPerfil());
               response.sendRedirect("Sistema");

           }
           
        } 
        catch(Exception e){
             response.sendRedirect("Sistema");
           }
        finally {
            out.close();
        }
    } */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       // processRequest(request, response);
        
try
{
             BeanLogin bu;
           String user,clave;
           user=request.getParameter("user");
           clave=request.getParameter("clave");
         Usuario u=new Usuario();
           bu=u.login(user, clave);
           // PrintWriter out = response.getWriter();
              //out.print(bu.getNombre());
          if(bu!=null)
           {

                request.getSession().setAttribute("user", bu.getUsuario());
             request.getSession().setAttribute("nombres", bu.getNombre());
             request.getSession().setAttribute("idusuario", bu.getId());
               request.getSession().setAttribute("idperfil", bu.getIdperfil());
                 request.getSession().setAttribute("perfil", bu.getPerfil());
               response.sendRedirect("Sistema");
             
           }
          else{
               //Principal p=new Principal();
               // response.sendRedirect("index?msg="+p.getError());
                Principal p=new Principal();
 response.sendRedirect("index?msg=usuario o clave incorrecto"+p.getError());
          }
}
catch(Exception e)
{
    Principal p=new Principal();
 response.sendRedirect("index?msg=usuario o clave incorrecto"+p.getError());
}
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
  /*  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }*/

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
///    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
