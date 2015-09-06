package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.istack.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.UserMgr;

/**
 *
 * @author Evilill
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String user_email = request.getParameter("user_email");
        String user_password = request.getParameter("user_password");
        String user_fname = request.getParameter("user_fname");
        String user_lname = request.getParameter("user_lname");
        
        PrintWriter out = response.getWriter();

        try {
            Logger.getLogger(Register.class).info(user_fname);
            Logger.getLogger(Register.class).info(user_lname);
            UserMgr.register(user_email, user_password, user_fname, user_lname);
            //response.sendRedirect(request.getHeader("Referer"));
        } catch (Exception e) {
            out.print("Err" + e);
        }

        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
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
