/*
 * Java 3
 * Juan Rodriguez
 * I promise I wrote this code.
 * 12/2/2021
 */

import BusinessObjects.appointment;
import BusinessObjects.dentist;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juan3
 */
@WebServlet(urlPatterns = {"/dentistLoginServlet"})
public class dentistLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //get input from loginForm 
        String id, pw;
        id = request.getParameter("dentId");
        pw = request.getParameter("password");
        
       // create dentist object pass through selectDB method
        dentist dent1;
        dent1 = new dentist();
        dent1.selectDB(id);
      
        // create appointment object for later jsp use
        appointment p3;
        p3 = new appointment();
        p3.selectDB(id);
        
        // Put appointment object in session
        HttpSession ses2;
        ses2 = request.getSession();
        ses2.setAttribute("p3", p3); 
        System.out.println("Appointment session");
        
              // Put Dentist object in session
        HttpSession ses1;
        ses1 = request.getSession();
        ses1.setAttribute("dent1",dent1);
        System.out.println("Dentist session");
        
        // if database password and id matches client password and id run the following code if not run else
        if(dent1.getPassword().equals(pw) && dent1.getId().equals(id)){
              RequestDispatcher rd = request.getRequestDispatcher("/dentist.jsp");
             rd.forward(request, response);  
        }else{
         RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
             rd.forward(request, response);  
        }
        
  

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
