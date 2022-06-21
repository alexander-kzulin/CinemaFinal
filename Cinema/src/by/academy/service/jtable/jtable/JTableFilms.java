package by.academy.service.jtable.jtable;

import by.academy.util.ConnectionManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JTableFilms {
    public static void JTableFilm() {

        Object[][] rowData = {{"film_id", "film_name", "session_date", "session_time", "ticket_price"}};

        Object[] columnNames = {"Film ID", "Film Name", "Session Date", "Session Time", "Ticket Price"};

        DefaultTableModel mTableModel = new DefaultTableModel(rowData, columnNames);
        JTable table = new JTable(mTableModel);

        try (Connection conn = ConnectionManager.open()) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM films");
            ResultSet resSet = preparedStatement.executeQuery();
            {
                JTablePreferences(mTableModel, table);
                Object[] rows;

                while (resSet.next()) {
                    rows = new Object[]{resSet.getInt(1), resSet.getString(2),
                            resSet.getString(3), resSet.getString(4),
                            resSet.getString(5)
                    };

                    mTableModel.addRow(rows);
                }
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            }
        } catch (SQLException e) {
            System.out.println("Connection failed..." + e);
        }
    }

    static void JTablePreferences(DefaultTableModel mTableModel, JTable table) {
        JFrame frameFilms = new JFrame();
        frameFilms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(table);
        frameFilms.add(scrollPane, BorderLayout.CENTER);
        frameFilms.setSize(850, 200);
        frameFilms.setLocation(250, 10);
        frameFilms.setVisible(true);

        mTableModel.removeRow(0);

    }
}
