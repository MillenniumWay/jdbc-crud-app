package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/CheckCookiesServlet")

public class CheckCookiesServlet extends HttpServlet {
    private LoginServlet loginServlet;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
        System.out.println("Is new?: " + session.isNew() + " " + "getCreationTime: " + session.getCreationTime() );
       for(Cookie cookie: cookies){
           System.out.println(cookie.getName()+ " "  + cookie.getValue()+ " " + cookie.getMaxAge()+ " "
                   + cookie.getMaxAge());
       }
        resp.sendRedirect("index.jsp");
    }
}
