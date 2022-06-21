package by.academy.dataBase;

import by.academy.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDataBase {


    public void createDB() {
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatement = conn.prepareStatement("CREATE DATABASE cinema");
            preparedStatement.executeUpdate();
            System.out.println("Data Base Created!");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.out.println("DB already exists");

        }
    }
}

