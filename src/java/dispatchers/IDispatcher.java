/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author dalevanh
 */
public interface IDispatcher {
    public String execute(HttpServletRequest request);
    
}
