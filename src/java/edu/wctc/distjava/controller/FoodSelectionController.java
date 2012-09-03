/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Kevin
 */
public class FoodSelectionController extends HttpServlet {
    private static final String RESULT_PAGE = "result.jsp";
    
        public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

            String one = request.getParameter("item1");
            String two = request.getParameter("item2");
            String three = request.getParameter("item3");
            String four = request.getParameter("item4");
            String five = request.getParameter("item5");
            String six = request.getParameter("item6");
            
        ArrayList<String> selections = new ArrayList<String>();
        
             selections.add(one);
             selections.add(two);
             selections.add(three);
             selections.add(four);
             selections.add(five);
             selections.add(six);
        
             out.println(one);
             
             for (String item : selections){
                out.println(item);}

//       OrderConfirmation oc = new OrderConfirmation(selections);
//       ArrayList<String> result = oc.getChoices();

//        request.setAttribute("choices", selections);
//
//        RequestDispatcher view =
//                request.getRequestDispatcher(RESULT_PAGE);
//        view.forward(request, response);

        }
}
