package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountService;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user!=null){
           getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
       return;
       
        }
        else 
        {
            response.sendRedirect("login");
            return;
        }
      
       }
         
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
      
    }

}
