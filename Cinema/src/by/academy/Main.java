package by.academy;

import by.academy.repository.UserRepositoryImpl;

import static by.academy.controller.MainMenuController.MainMenuStart;
import static by.academy.dataBase.createTable.CreateTable.*;

public class Main {

    public static void main(String[] args) {

        try {
            UserRepositoryImpl userRepository = new UserRepositoryImpl();

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