package by.academy.controller.userController;

import by.academy.entity.Film;
import by.academy.entity.Ticket;
import by.academy.entity.User;
import by.academy.repository.TicketRepository;
import by.academy.service.jtable.jtable.JTableTickets;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class UserTicketController {

    public static void UserBuyTicketMenu(User user) {
        Object[] buttonFilms = {"Terminator 4", "Harry Potter 6"};
        int y = JOptionPane.showOptionDialog(null, "Choice A Film!",
                "Choice A Film!",
                YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttonFilms, buttonFilms[0]);
        if (y == 0) {
            Object[] buttonTickets = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

            ImageIcon cinemaHall = new ImageIcon("pictures/cinema_hall_medium.png");

            int n = JOptionPane.showOptionDialog(
                    null, null, "  --- TERMINATOR 4 ---  --- SESSION TIME: 20:00 ---   --- CHOOSE A PLACE ---",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    cinemaHall, buttonTickets, buttonTickets[0]);


            TicketRepository ticketRepository = new TicketRepository();
            Film film = new Film();
            Ticket ticket = new Ticket();
            ticket.setTicketPrice(12);
            ticket.setPlaceNumber(String.valueOf(n + 1));
            film.setFilmName("Terminator 4");
            film.setSessionDate("2022-06-18");
            film.setSessionTime("20:00");

            ticketRepository.createTicket(user, (new Film(film.getFilmName(), film.getSessionTime(), film.getSessionDate())), ticket);


        } else if (y == 1) {
            Object[] buttonTickets = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

            ImageIcon cinemaHall = new ImageIcon("pictures/cinema_hall_medium.png");

            int n = JOptionPane.showOptionDialog(
                    null, null, "  --- Harry Potter 6 ---  --- SESSION TIME: 18:00 ---   --- CHOOSE A PLACE ---",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    cinemaHall, buttonTickets, buttonTickets[0]);
            TicketRepository ticketRepository = new TicketRepository();
            // User user = new User();
            Film film = new Film();
            Ticket ticket = new Ticket();
            ticket.setTicketPrice(8);
            ticket.setPlaceNumber(String.valueOf(n + 1));
            film.setFilmName("Harry Potter 6");
            film.setSessionDate("2022-06-18");
            film.setSessionTime("18:00");
            ticketRepository.createTicket(user, (new Film(film.getFilmName(), film.getSessionTime(), film.getSessionDate())), ticket);
        } else {

            UserMenu userMenu = new UserMenu();

            userMenu.userMenuStart(user, new Film(), new Ticket());
        }
    }

    public static void UserDeleteTicketMenu(User user) {

        Object[] buttonFilms = {"Terminator 4", "Harry Potter 6"};
        int y = JOptionPane.showOptionDialog(null, "Choice A Film to DELETE!",
                "Choice A Film!",
                YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttonFilms, buttonFilms[0]);

        if (y == YES_OPTION) {
            Object[] buttonTickets = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

            ImageIcon cinemaHall = new ImageIcon("pictures/cinema_hall_medium.png");

            int n = JOptionPane.showOptionDialog(null, null, "  --- TERMINATOR 4 ---  --- SESSION TIME: 20:00 ---   --- CHOOSE A PLACE ---",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    cinemaHall, buttonTickets, buttonTickets[0]);
            Ticket ticket = new Ticket();
            ticket.setFilmName("Terminator 4");
            ticket.setPlaceNumber(String.valueOf(n + 1));
            TicketRepository ticketRepository = new TicketRepository();
            ticketRepository.delete(ticket);
            JTableTickets.jtableTickets();
        } else if (y == NO_OPTION) {
            Object[] buttonTickets = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

            ImageIcon cinemaHall = new ImageIcon("pictures/cinema_hall_medium.png");

            int n = JOptionPane.showOptionDialog(
                    null, null, "  --- Harry Potter 6 ---  --- SESSION TIME: 20:00 ---   --- CHOOSE A PLACE ---",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    cinemaHall, buttonTickets, buttonTickets[0]);
            Ticket ticket2 = new Ticket();
            ticket2.setFilmName("Harry Potter 6");
            ticket2.setPlaceNumber(String.valueOf(n + 1));
            TicketRepository ticketRepository = new TicketRepository();
            ticketRepository.delete(ticket2);
        } else {
            UserMenu userMenu = new UserMenu();
            userMenu.userMenuStart(user, new Film(), new Ticket());
            JTableTickets.jtableTickets();
        }
    }
}