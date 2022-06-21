package by.academy.repository;

import by.academy.entity.User;
import by.academy.util.ConnectionManager;


import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;

import static by.academy.controller.userController.UserRegisterController.userLoginRegisterMenu;
import static javax.swing.JOptionPane.*;

public class UserRepositoryImpl implements Repository<User> {

    public User create(User user) {

        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO users(user_login," +
                    " user_password, user_role)" +
                    " VALUES(?,?,'user')");
            String result = showInputDialog("Enter User Login");
            preparedStatement.setString(1, result);
            String result2 = showInputDialog("Enter Password");
            String result3 = Base64.getEncoder().encodeToString(result2.getBytes(StandardCharsets.UTF_8));
            preparedStatement.setString(2, result3);

            if (Objects.equals(result, "")) {
                showMessageDialog(null, "Fields can't be empty");
                userLoginRegisterMenu();
            } else if (Objects.equals(result2, "")) {
                showMessageDialog(null, "Fields can't be empty");
                userLoginRegisterMenu();
            }
            preparedStatement.execute();
        } catch (
                SQLException e) {
            System.out.println("User name already exists");
            userLoginRegisterMenu();
        }
        return user;
    }


    @Override
    public User update(User newUpdate) {
        try (Connection connection3 = ConnectionManager.open()) {
            var preparedStatementUpd = connection3.prepareStatement
                    ("UPDATE users SET user_login =?, user_password =?,user_role=? WHERE user_id =?;");

            preparedStatementUpd.setString(1, newUpdate.getUserLogin());
            preparedStatementUpd.setString(2, newUpdate.getUserPassword());
            preparedStatementUpd.setString(3, newUpdate.getUserRole());
            preparedStatementUpd.setInt(4, newUpdate.getUserId());
            int update = preparedStatementUpd.executeUpdate();
            if (update == 1) {
                showMessageDialog(null, "Update successful");
                update(newUpdate);
                return newUpdate;
            } else {
                showMessageDialog(null, "Update error");
            }
        } catch (SQLException e) {
            System.out.println("Update error 2 " + e);
        }
        return new User();
    }

    @Override
    public User delete(User user) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statementDlt = connection.prepareStatement
                    ("DELETE FROM users WHERE user_id=?");
            statementDlt.setInt(1, user.getUserId());
            int delete = statementDlt.executeUpdate();
            if (delete > 0) {
                showMessageDialog(null, "User " + user.getUserLogin() + " is deleted.");
            } else {
                showMessageDialog(null, "Error. User not found.");
            }
            return user;
        } catch (SQLException e) {
            System.out.println("Delete error" + e);
        }
        return user;
    }
}


