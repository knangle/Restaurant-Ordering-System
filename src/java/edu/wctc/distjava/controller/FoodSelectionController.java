
package edu.wctc.distjava.controller;

import edu.wctc.distjava.model.OrderConfirmation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
* The FoodSelectionController class is a Controller layer class that receives 
* menu selections from the View layer, passes them in a List to the Model layer,
* retrieves a List of customer selected items from the Model layer, and passes 
* that List back to the View layer.
*<p>
* @author Kevin Nangle, knangle@my.wctc.edu
* @version 2
*/
public class FoodSelectionController extends HttpServlet {
    private static final String RESULT_PAGE = "result.jsp";
    
        public void doPost(HttpServletRequest request, HttpServletResponse 
                            response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        
        /**
         * Create String variables to collect parameters from the View layer.
         */
            String item1 = request.getParameter("item1");
            String item2 = request.getParameter("item2");
            String item3 = request.getParameter("item3");
            String item4 = request.getParameter("item4");
            String item5 = request.getParameter("item5");
            String item6 = request.getParameter("item6");
            
         /**
         * Place menu selection variables into a List for transport to the 
         * Model layer.
         */  
            List allItems = new ArrayList();
            
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
            allItems.add(item4);
            allItems.add(item5);
            allItems.add(item6);

        /**
        * Instantiate the Model layer class and pass the List of menu choices 
        * to the Model layer for processing
        */     
        OrderConfirmation oc = new OrderConfirmation(allItems);
        List result = oc.getChoices();
        
        /**
        * Send the result set (customer selections from the menu) to the 
        * request object.
        */         
        request.setAttribute("choices", result);
        
        /**
        * Pass the request object to the View layer.
        */
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);

        }
}
