package Servlets;

import DAO_LAYERS.UserDAO;
import Models.UserBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Writer;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Phase #1 You in LoginServlet");
        try (Writer writer = resp.getWriter()) {
            UserBean userBean = new UserBean(request.getParameter("password"), request.getParameter("email"));
               UserBean searchByDataBase = userDAO.yakkkuithemaid(userBean.getEmail());
                UserBean example = new UserBean(searchByDataBase.getId(),searchByDataBase.getLogin(),searchByDataBase.getPassword(),searchByDataBase.getEmail());
                System.out.println("Phase #2 You in Try/Catch");

                HttpSession session = request.getSession();
                session.setAttribute("login", searchByDataBase.getLogin());
                session.setAttribute("email", searchByDataBase.getEmail());
                session.setAttribute("id", searchByDataBase.getId());
                session.setAttribute("password", searchByDataBase.getPassword());

                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,resp);


                String email = (String) session.getAttribute("email");
                Cookie cookie = new Cookie("cookie_settings_email", email);
                cookie.setMaxAge(60*60*60);
                cookie.setPath("/");
                resp.addCookie(cookie);
              if (cookie == null) {
                System.out.println("Cookies is null");
            } else {
                System.out.println("Info-Cookies: " + " /Name/: " + cookie.getName() +
                        " /Value/: " + cookie.getValue() + " /MaxAge/: " + cookie.getMaxAge());
            }


            System.out.println("Phase #3 You in If/Else (NOT NOW)");
            System.out.println(searchByDataBase.toString());
                System.out.println("Phase #4 Success Login");
                  resp.sendRedirect("index.jsp");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    }

