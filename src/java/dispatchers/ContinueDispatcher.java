/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dispatchers;


import jakarta.servlet.http.HttpServletRequest;


/**
 *
 * @author Matthew Mowbray
 */
public class ContinueDispatcher implements IDispatcher {

    /**
     * 
     * @param request
     * @return string path for titles page 
     */
    @Override
    public String execute(HttpServletRequest request) {
       String nextPage = "/jsp/titles.jsp";
       return nextPage;
    }
    
}
