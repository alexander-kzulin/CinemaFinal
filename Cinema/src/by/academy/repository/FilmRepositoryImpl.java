package by.academy.repository;

import by.academy.entity.Film;
import by.academy.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.academy.controller.managerController.ManagerMenu.managerMenuStart;
import static javax.swing.JOptionPane.*;

public class FilmRepositoryImpl implements Repository<Film> {

    public Film create(Film film) {

        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO films(film_name, session_date, session_time, ticket_price) VALUES(?,?,?,?)");
            showMessageDialog(null, "Create film", "Click A Button", INFORMATION_MESSAGE);
            preparedStatement.setString(1, showInputDialog("Enter Film Name"));
            preparedStatement.setString(2, showInputDialog("Enter Session date"));
            preparedStatement.setString(3, showInputDialog("Enter Session time"));
            preparedStatement.setInt(4, Integer.parseInt(showInputDialog("Enter ticket price")));
            preparedStatement.execute();

        } catch (
                SQLException e) {
            System.out.println("Something goes wrong. Try again");
            return create(film);
        }
        return film;
    }

    @Override
    public Film update(Film newUpdate) {
        try (Connection connection3 = ConnectionManager.open()) {
            var preparedStatementUpd = connection3.prepareStatement(
                    "UPDATE films SET film_name=?, session_date=? , session_time =?, ticket_price=? WHERE film_id=?");
            preparedStatementUpd.setString(1, newUpdate.getFilmName());
            preparedStatementUpd.setString(2, newUpdate.getSessionDate());
            preparedStatementUpd.setString(3, newUpdate.getSessionTime());
            preparedStatementUpd.setInt(4, newUpdate.getTicketPrice());
            preparedStatementUpd.setInt(5, newUpdate.getFilmId());

            int update = preparedStatementUpd.executeUpdate();
            if (update == 1) {
                showMessageDialog(null, "Update successful");
                managerMenuStart();
            } else {
                showMessageDialog(null, "Update error");
            }
        } catch (SQLException e) {
            System.out.println("Update error");
            update(new Film());
        }
        return new Film();
    }

    @Override
    public Film delete(Film film) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statementDlt = connection.prepareStatement("DELETE FROM films WHERE film_name=?");
            statementDlt.setString(1, film.getFilmName());
            int delete = statementDlt.executeUpdate();
            if (delete > 0) {
                showMessageDialog(null, "Film " + film.getFilmName() + " is deleted.");
            } else {
                showMessageDialog(null, "Error. Film not found.");
            }
            return film;
        } catch (SQLException e) {
            showMessageDialog(null, "Something goes wrong");
        }
        return film;
    }
}
