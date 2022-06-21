package by.academy.controller.managerController;

import by.academy.entity.Film;
import by.academy.repository.FilmRepositoryImpl;
import by.academy.service.jtable.jtable.JTableFilms;

import javax.swing.*;

import static by.academy.controller.MainMenuController.ExitFromCinema;
import static by.academy.controller.managerController.ManagerMenu.managerMenuStart;

public class FilmsEditing {

    public static void ManagerFilmEditorMenu() {
        JTableFilms.JTableFilm();
        JTextField filmIdToInt = new JTextField();
        JTextField filmName = new JTextField();
        JTextField sessionDate = new JTextField();
        JTextField sessionTime = new JTextField();
        JTextField ticketPriceToInt = new JTextField();
        Object[] message = {
                "Film ID: ", filmIdToInt,
                "Film Name: ", filmName,
                "Session date(YYYY-MM-DD): ", sessionDate,
                "Session time(HH:MM) : ", sessionTime,
                "Ticket price: ", ticketPriceToInt
        };
        int x = JOptionPane.showConfirmDialog(null, message, "Edit", JOptionPane.OK_CANCEL_OPTION);
        FilmRepositoryImpl filmRepository = new FilmRepositoryImpl();

        if (x == 1) {
            int filmId = Integer.parseInt(filmIdToInt.getText());
            int ticketPrice = Integer.parseInt(ticketPriceToInt.getText());
            Film film = new Film(filmId, filmName.getText(), sessionDate.getText(), sessionTime.getText(), ticketPrice);
            filmRepository.update(film);
            JTableFilms.JTableFilm();
        } else if (x == 2) {
            managerMenuStart();

        } else {
            ExitFromCinema();
        }
    }

}
