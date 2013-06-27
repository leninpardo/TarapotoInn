/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.bean;

/**
 *
 * @author lenin
 */
public class BeanLogin {
    private final String id;
    private final String nombre;
    private final String usuario;
    private final String clave;
  private final String idperfil;
  private final String perfil;
    public BeanLogin(String id, String nombres, String usuario, String clave,String idperfil,String perfil) {
      super();
  this.id = id;
  this.nombre = id;
  this.usuario = usuario;
  this.clave = clave;
this.idperfil=idperfil;
this.perfil=perfil;
    }
    public String getId()
    {
        return this.id;
    }
     public String getNombre()
    {
        return this.nombre;
    }
      public String getUsuario()
    {
        return this.usuario;
    }
       public String getClave()
    {
        return this.clave;
    }
       public String getIdperfil()
    {
        return this.idperfil;
    }
        public String getPerfil()
    {
        return this.perfil;
    }
}
