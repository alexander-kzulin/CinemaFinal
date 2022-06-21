package by.academy.controller.managerController;

import by.academy.entity.Ticket;
import by.academy.service.ManagerService;
import by.academy.service.jtable.jtable.JTableFilms;
import by.academy.service.jtable.jtable.JTableTickets;

import javax.swing.*;

import java.awt.*;
import java.util.Objects;


import static javax.swing.JOptionPane.*;

public class TicketMenu {

    public static void managerTicketMenu() {
        JTableTickets.jtableTickets();
        Object[] usersMenu = {"Create ticket", "Delete ticket"};
        int y = JOptionPane.showOptionDialog(null, "User Editor", "Click A Button", YES_NO_OPTION, QUESTION_MESSAGE, null, usersMenu, usersMenu[0]);
        if (y == 0) {
            JTableFilms.JTableFilm();
            JTextField PressedUserName = new JTextField();
            JTextField filmName = new JTextField();
            JTextField placeNumber = new JTextField();
            JTextField PressedSessionDate = new JTextField();
            JTextField PressedSessionTime = new JTextField();
            JTextField ticketPriceToInt = new JTextField();
            Object[] message1 = {
                    "User Login:", PressedUserName,
                    "Film Name: ", filmName,
                    "Place number(1-18): ", placeNumber,
                    "Session date (YYYY-MM-DD)", PressedSessionDate,
                    "Session time (HH:MM)", PressedSessionTime,
                    "Ticket price: ", ticketPriceToInt
            };
            int x = JOptionPane.showConfirmDialog(null, message1, "Create ticket for user", JOptionPane.OK_CANCEL_OPTION);
            try {
                String userLogin = PressedUserName.getText();
                int ticketPrice = Integer.parseInt(ticketPriceToInt.getText());
                String sessionDate = PressedSessionDate.getText();
                String sessionTime = PressedSessionTime.getText();

                if (x == 0) {

                    Ticket ticket = new Ticket(userLogin, filmName.getText(), placeNumber.getText(), sessionDate, sessionTime, ticketPrice);

                    ManagerService managerService = new ManagerService();
                    managerService.createTicketForUser(ticket);


                } else if (x == 2) {

                    ManagerMenu.managerMenuStart();

                } else {

                    ManagerMenu.managerMenuStart();
                }
            } catch (HeadlessException | NumberFormatException e) {
                showMessageDialog(null, "Wrong data entered");
                managerTicketMenu();
            }

        } else if (y == 1) {

            JTextField PressedTicketId = new JTextField();
            Object[] message1 = {
                    "Ticket ID:", PressedTicketId,
            };
            int x = JOptionPane.showConfirmDialog(null, message1, "Delete ticket", JOptionPane.OK_CANCEL_OPTION);
            try {
                if (x == 0) {
                    int ticketId = Integer.parseInt(PressedTicketId.getText());
                    Ticket ticket = new Ticket(ticketId);
                    ManagerService managerService = new ManagerService();
                    managerService.deleteTicketForUser(ticket);
                } else if (x == 2) {
                    ManagerMenu.managerMenuStart();
                } else {
                    ManagerMenu.managerMenuStart();
                }
            } catch (HeadlessException | NumberFormatException e) {
                showMessageDialog(null, "Wrong data entered");
                managerTicketMenu();
            }
        } else {
            ManagerMenu.managerMenuStart();
        }
    }
}


