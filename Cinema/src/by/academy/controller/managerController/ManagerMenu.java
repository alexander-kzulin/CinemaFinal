package by.academy.controller.managerController;

import by.academy.controller.MainMenuController;
import by.academy.service.jtable.jtable.JTableTickets;

import static by.academy.controller.MainMenuController.ExitFromCinema;
import static by.academy.controller.managerController.FilmsEditing.ManagerFilmEditorMenu;
import static by.academy.controller.managerController.TicketMenu.managerTicketMenu;
import static by.academy.service.jtable.jtable.JTableTickets.jtableTickets;
import static javax.swing.JOptionPane.*;

public class ManagerMenu {

    public static void managerMenuStart() {
        jtableTickets();
        Object[] menu = {"Films Editing", "Tickets Editing"};
        int x = showOptionDialog(null, "Manager Menu. Select An Action", "Click A Button",
                YES_NO_CANCEL_OPTION, QUESTION_MESSAGE, null, menu, menu[0]);

        switch (x) {

            case 0:
                ManagerFilmEditorMenu();

            case 1:
                managerTicketMenu();
                break;

            default:
                ExitFromCinema();
        }
    }
}



