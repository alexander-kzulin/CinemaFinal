package by.academy.controller.userController;

import by.academy.entity.Film;
import by.academy.entity.Ticket;
import by.academy.entity.User;
import by.academy.service.jtable.jtable.JTableTickets;

import static by.academy.controller.MainMenuController.ExitFromCinema;
import static by.academy.controller.MainMenuController.MainMenuStart;
import static by.academy.controller.userController.UserTicketController.UserBuyTicketMenu;
import static by.academy.controller.userController.UserTicketController.UserDeleteTicketMenu;
import static javax.swing.JOptionPane.*;

public class UserMenu {
    private User user;

    public boolean userMenuStart(User user, Film film, Ticket ticket) {

        Object[] menu = {"Buy ticket", "Return Ticket", "See my tickets"};
        int x = showOptionDialog(null, "User menu. Select An Action", "Click A Button",
                DEFAULT_OPTION, QUESTION_MESSAGE, null, menu, menu[0]);
        switch (x) {
            case 0:
                UserBuyTicketMenu(user);
            case 1:
                UserDeleteTicketMenu(user);
            case 2:
                JTableTickets.jtableTickets();
                userMenuStart(user, film, ticket);
                break;
            default:
                ExitFromCinema();
        }
        return true;
    }
}
