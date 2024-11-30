/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Book;
import model.CartItem;

/**
 *
 * @author Matthew Mowbray
 */
public class AddToCartDispatcher implements IDispatcher {
    
    /**
     * Method that processes the add_to_cart request
     * @param request
     * @return string path for page forwarding 
     */
    @Override
    public String execute(HttpServletRequest request) {
            String nextPage = "/jsp/titles.jsp";
            HttpSession session = request.getSession();
            Map cart = (Map) session.getAttribute("cart");
            String[] selectedBooks = request.getParameterValues("add");

            if (cart == null && selectedBooks != null) {
                cart = new HashMap();
                for (int i = 0; i < selectedBooks.length; i++) {
                    String isbn = selectedBooks[i];
                    int quantity = Integer.parseInt(request.getParameter(isbn));
                    Book book = this.getBookFromList(isbn, session);
                    CartItem item = new CartItem(book);
                    item.setQuantity(quantity);
                    cart.put(isbn, item);
                }  // end for
                session.setAttribute("cart", cart);
            } // end if
            else if(selectedBooks != null) {
                for (int i = 0; i < selectedBooks.length; i++) {
                    String isbn = selectedBooks[i];
                    int quantity = Integer.parseInt(request.getParameter(isbn));
                    if (cart.containsKey(isbn)) {
                        CartItem item = (CartItem) cart.get(isbn);
                        item.setQuantity(quantity);
                    } // end if
                    else {
                        Book book = this.getBookFromList(isbn, session);
                        CartItem item = new CartItem(book);
                        item.setQuantity(quantity);
                        cart.put(isbn, item);
                    } // end else
                }
               
            } //end else
             return nextPage;
    }
    
        /**
         * Finds specific Book 
         * @param isbn
         * @param session
         * @return Book
         */
        private Book getBookFromList(String isbn, HttpSession session) {
        List list = (List) session.getAttribute("books");
        Book aBook = null;
        for (int i = 0; i < list.size(); i++) {
            aBook = (Book) list.get(i);
            if (isbn.equals(aBook.getIsbn())) {
                break;
            } // end if
        } // end for
        return aBook;
    } // end getBookFromList
    
}
