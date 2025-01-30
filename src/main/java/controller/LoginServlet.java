package controller;

import dao.imp.LoginDaoImp;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.LoginService;
import service.imp.LoginServiceImp;
import util.HibernateUtil;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    public LoginServlet(LoginService loginService){
        this.loginService = loginService;
    }

    public LoginServlet(){
        this.loginService = new LoginServiceImp(
                new LoginDaoImp(HibernateUtil.getSessionFactory()));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the session if it exists
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirect to index.jsp
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (loginService.validateUser(username, password)) {
            User user = loginService.getUserByNameAndId(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());

            // Redirecting to home
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        } else {
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
    }

}
