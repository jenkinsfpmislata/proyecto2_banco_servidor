/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto2.bank.negocio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import org.jasypt.util.password.BasicPasswordEncryptor;
/**
 *
 * @author alumno
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente implements Serializable {
    
    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String login;
    private String password;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String login, String password) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.login = login;
        this.password = password;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
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
    
       public boolean checkPassword(String unEncryptedPassword) { //no encriptado
        String cryptedPassword=getPassword(); // encriptado
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
       // String encryptedPassword = passwordEncryptor.encryptPassword(password); crear usuario

        if (passwordEncryptor.checkPassword(unEncryptedPassword, cryptedPassword)) {
            return true;
        } else {
            return false;
        }
    }
    
}
