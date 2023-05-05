package Servlets;

import DTO_LAYERS.HospitalDTO;
import Service.HospitalService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/info")

public class PostgresServlet extends HttpServlet {
    private final HospitalService hospitalService = HospitalService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HospitalDTO> hospitalServiceAlltals = null;
        try {
            hospitalServiceAlltals = hospitalService.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("hospitalServiceAlltals", hospitalServiceAlltals);
            req.getRequestDispatcher("/info.jsp").forward(req, resp);

    }
}


