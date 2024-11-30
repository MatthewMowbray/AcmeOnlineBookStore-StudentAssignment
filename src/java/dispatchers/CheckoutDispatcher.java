/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;


import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 * @author @author Matthew Mowbray
 */
public class CheckoutDispatcher implements IDispatcher {

    
    /**
     * 
     * @param request
     * @return the checkoutpage to forward to 
     */
    @Override
    public String execute(HttpServletRequest request) {
         String nextPage = "/jsp/checkout.jsp";
         return nextPage;
    }
    
}
