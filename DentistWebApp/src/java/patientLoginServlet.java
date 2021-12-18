/*
 * Java 3
 * Juan Rodriguez
 * I promise I wrote this code.
 * 12/2/2021
 */
import BusinessObjects.patient;
import BusinessObjects.appointment;
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
@WebServlet(urlPatterns = {"/patientLoginServlet"})
public class patientLoginServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
             //get input from loginForm 
        String id, pw;
        id = request.getParameter("id");
        pw = request.getParameter("password");
        
       // create patient object pass through selectDB method
        patient p1;
        p1 = new patient();
        p1.selectDB(id);
      
        // create appointment object for later jsp use
        appointment p2;
        p2 = new appointment();
        p2.selectDB(id);
        
        // Put appointment object in session
        HttpSession ses2;
        ses2 = request.getSession();
        ses2.setAttribute("p2", p2); 
        System.out.println("Appointment session");
        
              // Put customer object in session
        HttpSession ses1;
        ses1 = request.getSession();
        ses1.setAttribute("p1",p1);
        System.out.println("Patient session");
        
        // if database password and id matches client password and id run the following code if not run else
        if(p1.getPassWD().equals(pw) && p1.getPatId().equals(id)){
              RequestDispatcher rd = request.getRequestDispatcher("/patient.jsp");
             rd.forward(request, response);  
             

        }else{
         RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
             rd.forward(request, response);  
        }
        
  


       }finally{
          
        
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
