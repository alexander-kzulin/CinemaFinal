package by.academy.dataBase.createTable;

import by.academy.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {

    public static void createTableUsers() {
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement stmt = conn.prepareStatement("Create Table If Not Exists users"
                    + "("
                    + "user_id int auto_increment primary key,"
                    + "user_login varchar (30) not null unique,"
                    + "user_password varchar (20) not null,"
                    + "user_role text not null"
                    + ")");
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createTableFilms() {
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement stmt = conn.prepareStatement("Create Table If Not Exists films"
                    + "("
                    + "film_id int auto_increment primary key,"
                    + "film_name varchar (50) not null,"
                    + "session_date varchar (30) not null,"
                    + "session_time varchar (30) not null,"
                    + "ticket_price int  null"
                    + ")");
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createTableTickets() {
        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement stmt = conn.prepareStatement("Create Table If Not Exists tickets"
                    + "("
                    + "ticket_id int auto_increment primary key ,"
                    + "user_login varchar (30) not null,"
                    + "film_name varchar (50) not null,"
                    + "place_number int  null,"
                    + "session_date varchar (30) not null,"
                    + "session_time varchar (30) not null,"
                    + "ticket_price int null"
                    + ")");
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
