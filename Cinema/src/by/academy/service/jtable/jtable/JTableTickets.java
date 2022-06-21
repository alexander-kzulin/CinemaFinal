package by.academy.service.jtable.jtable;

import by.academy.util.ConnectionManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JTableTickets {

    public static void jtableTickets() {

        Object[][] rowData = {{"ticket_id", "user_login", "film_name", "place_number", "session_date", "session_time", "ticket_price"}};

        Object[] columnNames = {"Ticket ID", "User Login", "Film Name", "Place Number", "Session_date", "Session_time", "Ticket_price"};

        DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
        JTable table = new JTable(mTableModel);


        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM tickets");
            ResultSet resSet = preparedStatement.executeQuery();
            {

                Object[] rows;
                JTableFilms.JTablePreferences(mTableModel, table);


                while (resSet.next()) {
                    rows = new Object[]{resSet.getInt(1),
                            resSet.getString(2), resSet.getString(3),
                            resSet.getString(4), resSet.getString(5),
                            resSet.getString(6), resSet.getInt(7)
                    };

                    mTableModel.addRow(rows);
                }
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            }
        } catch (SQLException e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }


}
