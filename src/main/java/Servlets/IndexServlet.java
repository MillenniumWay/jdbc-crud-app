package Servlets;

import DAO_LAYERS.ClientsDAO;
import DAO_LAYERS.HospitalDAO;
import Models.Client;
import Models.Hospital;
import Models.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
  private HospitalDAO hospitalDAO = new HospitalDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkCookie(req,resp);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
        try (PrintWriter writer = resp.getWriter()){
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client1 = new Client(req.getParameter("FIRSTNAME"),req.getParameter("LASTNAME"),
                req.getParameter("PASSPORT"), req.getParameter("CODE"), req.getParameter("DATE"),
                Integer.parseInt(req.getParameter("FK_DOC")));

        System.out.println(client1.getFirst_name()+ " " + client1.getLast_name()+ " " +
                client1.getPassport_num()+ " " +client1.getCode_of_diagnose()+ " " +
                client1.getDate_entry()+ " " + client1.getFk_doctor_id());

        System.out.println("IN #TRY/CATCH#");

        try {
            ClientsDAO clientsDAO = new ClientsDAO();

            clientsDAO.insertIntoClients(new Client(client1.getFirst_name(), client1.getLast_name(),
                    client1.getPassport_num(),client1.getCode_of_diagnose(),
                    client1.getDate_entry(), client1.getFk_doctor_id()));
            System.out.println("Success #INSERT#");
            resp.sendRedirect("/index.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void checkCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie: cookies) {
            System.out.println(cookie.getValue() + " " + cookie.getName() + " " + cookie.getComment());
        }
    }
}
