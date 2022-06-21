package by.academy.service;

import by.academy.controller.userController.UserMenu;
import by.academy.entity.Film;
import by.academy.entity.Ticket;
import by.academy.entity.User;
import by.academy.repository.FilmRepositoryImpl;
import by.academy.util.ConnectionManager;
import com.mysql.jdbc.ResultSetImpl;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

import static by.academy.controller.MainMenuController.MainMenuStart;
import static by.academy.controller.managerController.ManagerMenu.managerMenuStart;
import static javax.swing.JOptionPane.*;

public class UserService {

    public boolean userLogin(User user) {
        JTextField userLoginIn = new JTextField();
        JTextField passwordIn = new JPasswordField();

        Object[] message = {
                "UserName:", userLoginIn,
                "Password:", passwordIn};

        int x = JOptionPane.showConfirmDialog(null, message, "Login", OK_CANCEL_OPTION);
        String userLogin = userLoginIn.getText();
        String userPassword = Base64.getEncoder().encodeToString(passwordIn.getText().getBytes(StandardCharsets.UTF_8));
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT user_login ," +
                    " user_password FROM users WHERE user_login='" + userLoginIn.getText() + "'  AND"
                    + " user_password='" + userPassword + "'");

            ResultSetImpl resultSet = (ResultSetImpl) preparedStatement.executeQuery();

            if (resultSet.next()) {
                return userRole(userLogin, userPassword);

            } else if (x == CLOSED_OPTION) {
                showMessageDialog(null, "EXIT");
                System.exit(0);

            } else if (x == CANCEL_OPTION) {
                MainMenuStart();

            } else {
                JOptionPane.showMessageDialog(null, "Login false. Try again");
                userLogin(user);
            }
        } catch (NullPointerException|SQLException e) {
            e.printStackTrace();
            System.out.println("There is no user with such name/password");
        }
        return true;
    }


    public boolean userRole(String userLogin, String userPassword) {

        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * from users WHERE user_login ='" + userLogin + "'  AND"
                    + " user_password='" + userPassword + "'");
            ResultSetImpl rs = (ResultSetImpl) ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("user_login");
                String password = rs.getString("user_password");
                String userRole = rs.getString("user_role");

                if (userRole == null || userRole.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No such role for this login");
                } else if (userRole.equals("admin")) {
                    FilmRepositoryImpl filmRepository = new FilmRepositoryImpl();
                    filmRepository.create(new Film());
                    UserService userService = new UserService();
                    userService.userLogin(new User());
                } else if (userRole.equals("manager")) {
                    managerMenuStart();
                } else {
                    User user = new User(id, username, password, userRole);
                    UserMenu userMenu = new UserMenu();
                    userMenu.userMenuStart(user, new Film(), new Ticket());
                }
            }
        } catch (SQLException e) {
            System.out.println("Something goes wrong " + e.getSQLState());
        }
        return false;
    }
}
