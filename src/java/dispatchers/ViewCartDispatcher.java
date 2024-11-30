/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 * @author dalevanh
 */
public class ViewCartDispatcher implements IDispatcher {

    
    /**
     * Create a map of car from session attribute
     * @param request
     * @return nextPage for forwarding
     */
    @Override
    public String execute(HttpServletRequest request) {
            String nextPage ="/jsp/cart.jsp";
            HttpSession session = request.getSession(true);
            Map cart = (Map) session.getAttribute("cart");
            if (cart == null) {
                nextPage = "/jsp/titles.jsp";
            }
            
            
            return nextPage;
    }
    
}
