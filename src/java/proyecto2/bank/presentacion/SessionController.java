/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bank.presentacion;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class SessionController {
    
    
      private void noCache(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Cache-Control", "no-cache");
    }
    
}
