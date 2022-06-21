
package by.academy.repository;

import by.academy.controller.userController.UserMenu;
import by.academy.entity.Film;
import by.academy.entity.Ticket;
import by.academy.entity.User;
import by.academy.service.jtable.jtable.JTableTickets;
import by.academy.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class TicketRepository implements Repository<Ticket> {

    public Ticket createTicket(User user, Film film, Ticket ticket) {
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatement = conn.prepareStatement
                    ("INSERT INTO tickets( user_login, film_name, place_number,session_date, session_time, ticket_price) VALUES(?,?,?,?,?,?);");
            preparedStatement.setString(1, user.getUserLogin());
            preparedStatement.setString(2, film.getFilmName());
            preparedStatement.setString(3, ticket.getPlaceNumber());
            preparedStatement.setString(4, film.getSessionDate());
            preparedStatement.setString(5, film.getSessionTime());
            preparedStatement.setInt(6, ticket.getTicketPrice());
            preparedStatement.execute();
            UserMenu userMenu = new UserMenu();
            JTableTickets.jtableTickets();
            userMenu.userMenuStart(new User(user.getUserLogin()), new Film(), new Ticket());
        } catch (SQLException e) {
            System.out.println("Ticket don't create" + e);
        }
        return ticket;
    }


    @Override
    public Ticket update(Ticket newUpdate) {
        try (Connection connection3 = ConnectionManager.open()) {
            var preparedStatementUpd = connection3.prepareStatement(
                    "UPDATE tickets SET  user_login=?,film_name=?, place_number=?, session_date=?, session_time=?, ticket_price=? WHERE ticket_id=?");
            preparedStatementUpd.setString(1, newUpdate.getFilmName());
            preparedStatementUpd.setString(2, newUpdate.getPlaceNumber());
            preparedStatementUpd.setInt(3, newUpdate.getTicketId());
            boolean update = preparedStatementUpd.execute();
            if (update) {
                showMessageDialog(null, "Update successful");
            } else {
                showMessageDialog(null, "Update error");
            }
        } catch (SQLException e) {
            System.out.println("Update error");
        }
        return newUpdate;
    }

    @Override
    public Ticket delete(Ticket ticket2) {

        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statementDlt = connection.prepareStatement("DELETE FROM tickets WHERE film_name=? AND place_number=?");
            statementDlt.setString(1, ticket2.getFilmName());
            statementDlt.setInt(2, Integer.parseInt(ticket2.getPlaceNumber()));
            int delete = statementDlt.executeUpdate();
            if (delete > 0) {
                showMessageDialog(null, "Film " + ticket2.getFilmName() + " is deleted.");
                UserMenu userMenu = new UserMenu();
                JTableTickets.jtableTickets();
                userMenu.userMenuStart(new User(ticket2.getUserLogin()), new Film(), new Ticket());
            } else {
                showMessageDialog(null, "You don't have such ticket");
                UserMenu userMenu = new UserMenu();
                userMenu.userMenuStart(new User(ticket2.getUserLogin()), new Film(), new Ticket());
            }
        } catch (SQLException e) {
            showMessageDialog(null, "Something goes wrong");
        }
        return ticket2;
    }

}

