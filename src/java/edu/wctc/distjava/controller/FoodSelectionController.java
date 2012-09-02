/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.controller;

import edu.wctc.distjava.model.OrderConfirmation;
import java.io.IOException;
import java.io.PrintWriter;
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

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        try {
            out.println("You selected:<br/>");
            String one = request.getParameter("choice1");
            String two = request.getParameter("choice2");
            String three = request.getParameter("choice3");
            String four = request.getParameter("choice4");
            String five = request.getParameter("choice5");
            String six = request.getParameter("choice6");
            out.println(one);
            out.println(two);
            out.println(three);
            out.println(four);
            out.println(five);
            out.println(six);
        
        // Create a new instance of a model object
        // For some applications, we would not want to create a new one each time.
        OrderConfirmation oc = new OrderConfirmation(one, two, three, four, five, six);
        // Always a good idea to trim and/or validate input data
        List result = oc.getChoices();

        // Parameters are read only Request object properties, but attributes
        // are read/write. We can use attributes to store data for use on
        // another page.
        request.setAttribute("choices", result);
        
        // This object lets you forward both the request and response
        // objects to a destination page
        RequestDispatcher view =
                request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    


        }
}
