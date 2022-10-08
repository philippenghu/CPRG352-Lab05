package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
         String message;
        if(logout != null){
            session.invalidate();
            session = request.getSession();
            message="Log out.";
             request.setAttribute("message", message);
        }
       User user = (User)session.getAttribute("user");
        if( user != null){
            response.sendRedirect("home");
            return;
        }
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       return; 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session;
        String username ;
        String password ;
        User user;
        String message;
        username = request.getParameter("username");
        password = request.getParameter("password");
        user=new User(username,password);
        if (username==null||username.equals("") ||password==null || password.equals("")) {
            message = "Please enter both username and password";   
            request.setAttribute("user", user);
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }      
        AccountService account = new AccountService();
        if(account.login(username, password)!=null){
            session = request.getSession(); 
            session.setAttribute("user", user); 
             response.sendRedirect("home");
            return;
        }
        else{ 
         session = request.getSession(); 
            session.setAttribute("user", user);
            message = "Invalid username or password";
         request.setAttribute("message", message);
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }

}
