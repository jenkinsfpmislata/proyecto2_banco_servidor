/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.presentacion;

/**
 *
 * @author alumno
 */
public class Credenciales {
    
    private String login;
    private String password;

    public Credenciales() {
    }

    public Credenciales(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
