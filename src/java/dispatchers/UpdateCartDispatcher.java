/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import model.Book;
import model.CartItem;

/**
 *
 * @author Matthew Mowbray
 */
public class UpdateCartDispatcher implements IDispatcher {

    
    /**
     * Removes book from cart and redirects to cart page
     * @param request
     * @return string path cart page 
     */
    @Override
    public String execute(HttpServletRequest request) {
            Map cart = null;
            Book book = null;
            CartItem item = null;
            String isbn = null;
            String nextPage = "/jsp/cart.jsp";
            HttpSession session = request.getSession();
            cart = (Map) session.getAttribute("cart");
            String[] booksToRemove = request.getParameterValues("remove");
            if (booksToRemove != null) {
                for (int i = 0; i < booksToRemove.length; i++) {
                    cart.remove(booksToRemove[i]);
                }
            }
            Set entries = cart.entrySet();
            Iterator iter = entries.iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                isbn = (String) entry.getKey();
                item = (CartItem) entry.getValue();
                int quantity = Integer.parseInt((request.getParameter(isbn)));
                item.updateQuantity(quantity);
            }
            
            
            
            return nextPage;
    }
    
}
