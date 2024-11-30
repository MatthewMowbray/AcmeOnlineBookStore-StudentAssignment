/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;


import ejb.DatabasePersistanceBean;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.Book;


/**
 *
 * @author Matthew Mowbray
 */
public class TitlesDispatcher  implements IDispatcher{
  DatabasePersistanceBean DBPersistence = new DatabasePersistanceBean();
     
     /**
      * Gets all books from the database and adds them to session books session
      * attribute
      * @param request
      * @return nextPage for forwarding
      */
    @Override
    public String execute(HttpServletRequest request) {
        List<Book> books = null;
        String nextPage = "/jsp/error.jsp";
        HttpSession session = request.getSession();
        try{
            //System.out.println("inside try block of ShowHomeAO.exe()");
            books = DBPersistence.getAllBooks();
            session.setAttribute ("books", books);
            nextPage = "/jsp/titles.jsp";
            
        }catch(Exception ex) {
            request.setAttribute ("result",ex.getMessage ());
            nextPage= "/jsp/error.jsp";
        } // end catch
        finally{
            return nextPage;
        }
    }
    
 
 
}
