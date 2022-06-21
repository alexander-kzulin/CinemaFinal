package by.academy;

import static by.academy.controller.MainMenuController.MainMenuStart;
import static by.academy.dataBase.createTable.CreateTable.*;

public class Main {

    public static void main(String[] args) {

        try {

            createTableFilms();
            createTableTickets();
            createTableUsers();
        } catch (Throwable e) {
            System.out.println("Tables already exists...");
        } finally {
            System.out.println("Connection...");
            MainMenuStart();
        }
    }


}