/*
 * Java 3
 * Juan Rodriguez
 * I promise I wrote this code.
 * 12/2/2021
 */

import BusinessObjects.dentist;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juan3
 */
@WebServlet(urlPatterns = {"/dentistUpdateInfo"})
public class dentistUpdateInfo extends HttpServlet {

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
                   //get input from loginForm 
        String id,fname, lname, office;
        id = request.getParameter("id");
        fname = request.getParameter("fname");
        lname = request.getParameter("lname");
        office = request.getParameter("office");

       // create patient object pass through selectDB method
        dentist dent1;
        dent1 = new dentist();
        dent1.selectDB(id);
        
        
        if(dent1.getId().equals(id)){
          dent1.updateDB(id, fname, lname, office);
           RequestDispatcher rd = request.getRequestDispatcher("/dentistsLogin.jsp");
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
