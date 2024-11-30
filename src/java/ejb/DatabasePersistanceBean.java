/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;


import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;
import jakarta.persistence.SynchronizationType;
import java.util.List;
import model.*;
/**
 *
 * @author Matthew Mowbray
 */
@Stateless
public class DatabasePersistanceBean {
//   @PersistenceUnit(unitName = "OnlineBookStorePU")
    static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AcmeOnlineBookStorePU");
    private  EntityManager em = entityManagerFactory.createEntityManager(SynchronizationType.SYNCHRONIZED);
     
    
   
    public DatabasePersistanceBean(){
    
    }
    

    
    /**
     * Gets all books from database using the named query from book entity class
     * @return List<Book>
     */
    public List<Book> getAllBooks(){
        //Query q = em.createNamedQuery("Tbooks.findAll", Book.class );
        Query query = em.createNamedQuery("Book.findAll");
        return (List<Book>)query.getResultList();
        
    
    }
    

    
}
