package Servlets;

import DAO_LAYERS.UserDAO;
import DTO_LAYERS.CreateUserDto;
import Entity.Gender;
import Entity.Role;
import Models.UserBean;
import Utils.JSPHELPER;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/registration")

public class RegistrationServlet extends HttpServlet {
  private UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", Role.values());
        req.setAttribute("genders", Gender.values());
        req.getRequestDispatcher("registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, RuntimeException, IOException {
        UserBean userBean = new UserBean(req.getParameter("name"), req.getParameter("email"), req.getParameter("pwd"));
        System.out.println(userBean.getLogin() +  req.getParameter("email") +  req.getParameter("pwd"));
//        var userDto = CreateUserDto.builder()
//                .login(req.getParameter("name"))
//                .email(req.getParameter("email"))
//                .password(req.getParameter("pwd"))
//                .build();
        try {
           userDAO.insertUsers(new UserBean(userBean.getLogin(), userBean.getEmail(), userBean.getPassword()));
           resp.sendRedirect("login.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
