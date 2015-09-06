package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.User;
import database.UserMgr;
import java.util.logging.Logger;

/**
 *
 * @author Evilill
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user_email = request.getParameter("user_email");
        String user_password = request.getParameter("user_password");
        Logger.getLogger(Login.class.getName()).info(user_email);
        
        try {
            User user = UserMgr.login(user_email, user_password);
            if (user.isValid()) {
                out.printf("\u005B\"OK\",\"%s %s\"\u005D",user.fName,user.lName);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                //out.println(session.getAttribute("email"));
                //response.sendRedirect(request.getHeader("Referer"));
            } else {
                out.printf("\u005B\"ERR\"\u005D");
            }

        } catch (Exception e) {
            out.print("Error:" + e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String act = request.getParameter("act");
        if (user != null) {
            if (act != null && act.equals("logout")) {
                session.removeAttribute("user");
                //response.sendRedirect(request.getHeader("Referer"));
            } else {
                out.print(user.fName + " " + user.lName);
            }
        }
    }

    public String getServletInfo() {
        return "Short description";
    }

}
