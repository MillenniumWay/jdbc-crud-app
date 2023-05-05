package Service;

import DAO_LAYERS.ClientsDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.SQLException;

public class ClientService {
    ClientsDAO clientsDAO = new ClientsDAO();


    public void jspInsertNewClient (HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<><>");

    }

    public void jspShowTable(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        PrintWriter printWriter = resp.getWriter();

        printWriter.write(
                "<center> <table class=\"table\" style=\"position: relative; left: auto; right: auto; top: -250px\" >\n" +
                        "\t<thead>\n" +
                        "\t\t<tr>\n" +
                        "\t\t\t<th>FIRST-NAME</th>\n" +
                        "\t\t\t<th>LAST-NAME</th>\n" +
                        "\t\t\t<th>PASSPORT-NUM</th>\n" +
                        "\t\t\t<th>CODE-OF-DIAGNOSE</th>\n" +
                        "\t\t\t<th>DATE-ENTRY</th>\n" +
                        "\t\t</tr>\n" +
                        "\t</thead>\n");

        for (int i = 0; i < clientsDAO.readAllClients().size(); i++) {
            try {
                printWriter.write(
                        "\t<tbody>\n" +
                                "\t\t<tr>\n" +
                                "\t\t\t<td>" + clientsDAO.readAllClients().get(i).getFirst_name() + "</td>\n" +
                                "\t\t\t<td>" + clientsDAO.readAllClients().get(i).getLast_name() + "</td>\n" +
                                "\t\t\t<td>" + clientsDAO.readAllClients().get(i).getPassport_num() + "</td>\n" +
                                "\t\t\t<td>" + clientsDAO.readAllClients().get(i).getCode_of_diagnose() + "</td>\n" +
                                "\t\t\t<td>" + clientsDAO.readAllClients().get(i).getDate_entry() + "</td>\n" +
                                "\t\t</tr>\n" +
                                "\t</tbody>\n");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        printWriter.write("</table> </center>");
    }
}
