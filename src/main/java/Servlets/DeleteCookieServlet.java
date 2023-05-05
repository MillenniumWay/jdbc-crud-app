package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/DeleteCookieServlet")
public class DeleteCookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("cookie_settings", "");
        HttpSession session = req.getSession();
        session.invalidate();
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect("index.jsp");
    }
}
