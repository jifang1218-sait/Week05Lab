/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author jifang
 */
public class LoginServlet extends HttpServlet {


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
        String sessionUsername = (String)request.getSession().getAttribute("username");
        String logout = request.getParameter("logout");
        if (logout == null) { 
            if (sessionUsername != null) { // login state, jump to home
                String url = "/WEB-INF/home.jsp";
                request.setAttribute("user", new User(sessionUsername, ""));
                getServletContext().getRequestDispatcher(url)
                        .forward(request, response);
            } else { // show login page
                String username = (String)request.getParameter("username");
                String password = (String)request.getParameter("password");
                User user = new User(username, password);
                request.setAttribute("user", user);
                String url = "/WEB-INF/login.jsp";
                getServletContext().getRequestDispatcher(url)
                        .forward(request, response);
            }
        } else { // logout request
            String url = "/WEB-INF/login.jsp";
            request.getSession().removeAttribute("username");
            request.getSession().invalidate();
            request.setAttribute("message", "You have successfully logged out.");
            getServletContext().getRequestDispatcher(url)
                .forward(request, response);
        } 
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
        String message;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null 
                || username.length() <= 0 
                || password.length() <= 0) {
            message = "username or password cannot be empty.";
        } else {
            AccountService as = new AccountService();
            User user = as.login(username, password);
            if (user != null) {
                String url = "home";
                request.getSession().setAttribute("username", username);
                response.sendRedirect(url);
                return;
            } else {
                message = "Incorrect username/password.";
            }
        }
        
        request.setAttribute("user", new User(username, password));
        request.setAttribute("message", message);
        String url = "/WEB-INF/login.jsp";
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }
}
