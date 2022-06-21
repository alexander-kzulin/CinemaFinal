package by.academy.service;


import by.academy.entity.Ticket;
import by.academy.service.jtable.jtable.JTableTickets;
import by.academy.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.academy.controller.managerController.ManagerMenu.managerMenuStart;
import static javax.swing.JOptionPane.showMessageDialog;

public class ManagerService {

    public void createTicketForUser(Ticket ticket) {
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatement = conn.prepareStatement
                    ("INSERT INTO tickets( user_login, film_name, place_number,session_date, session_time, ticket_price) VALUES(?,?,?,?,?,?);");
            preparedStatement.setString(1, ticket.getUserLogin());
            preparedStatement.setString(2, ticket.getFilmName());
            preparedStatement.setString(3, ticket.getPlaceNumber());
            preparedStatement.setString(4, ticket.getSessionDate());
            preparedStatement.setString(5, ticket.getSessionTime());
            preparedStatement.setInt(6, ticket.getTicketPrice());

            preparedStatement.execute();
            String textOut = "Your Film: " + ticket.getFilmName() + "\n" +
                    "Your Place Number : " + ticket.getPlaceNumber() + "\n" +
                    "Ticket Price: " + ticket.getTicketPrice() + "$";

            showMessageDialog(null, textOut);
            managerMenuStart();

        } catch (SQLException e) {
            System.out.println("Wrong data entered. Try again" + e.getMessage() + e.getSQLState());
            managerMenuStart();

        }
    }

    public void deleteTicketForUser(Ticket ticket) {
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatementDlt = conn.prepareStatement
                    ("DELETE FROM tickets WHERE ticket_id =?;");
            preparedStatementDlt.setInt(1, ticket.getTicketId());
            int delete = preparedStatementDlt.executeUpdate();
            if (delete > 0) {
                showMessageDialog(null, "Ticket " + ticket.getTicketId() + " is deleted.");
                JTableTickets.jtableTickets();
            } else {
                showMessageDialog(null, "Error. Ticket not found.");
            }
        } catch (SQLException e) {
            System.out.println("Something goes wrong. Try again" + e.getMessage() + e.getSQLState());
        }
        managerMenuStart();


    }
}

