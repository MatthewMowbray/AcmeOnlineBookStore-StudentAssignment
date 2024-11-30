/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;


import ejb.DatabasePersistanceBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Book;


/**
 *
 * @author Matthew Mowbray
 */
public class HomeDispatcher implements IDispatcher {
  
    
    /**
     * <p>
     * Creates an instance of the EntityManager gets all books from database and
     * sets books session attribute
     * </p>
     * @param request
     * @return nextPage for forwarding
     */
    @Override
    public String execute(HttpServletRequest request) {
       DatabasePersistanceBean EntityManager = new DatabasePersistanceBean();
        String nextPage = "/jsp/titles.jsp";
        List<Book> books = null;
        HttpSession session = request.getSession();
        try {
                System.out.println("inside try block of ShowHomeAO.exe()");
                books = EntityManager.getAllBooks();
                session.setAttribute("books", books);
                nextPage = "/jsp/titles.jsp";
            } catch (Exception ex) {
                request.setAttribute("result", ex.getMessage());
                nextPage ="/jsp/error.jsp";
            } finally {
                return nextPage;
            }
    }
    
    

    
}
