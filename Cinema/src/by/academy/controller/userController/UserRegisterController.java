package by.academy.controller.userController;

import by.academy.entity.User;
import by.academy.repository.UserRepositoryImpl;
import by.academy.service.UserService;

import static by.academy.controller.MainMenuController.ExitFromCinema;
import static by.academy.controller.MainMenuController.MainMenuStart;
import static javax.swing.JOptionPane.*;

public class UserRegisterController {

    public static void userLoginRegisterMenu() {
        try {


            Object[] menu = {"Log In", "Register"};
            int x = showOptionDialog(null, "Select An Action", "Click A Button",
                    DEFAULT_OPTION, INFORMATION_MESSAGE, null, menu, menu[0]);

            if (x == 0) {
                UserService userService = new UserService();
                userService.userLogin(new User());
            } else if (x == 1) {

                UserRepositoryImpl userRepository = new UserRepositoryImpl();
                userRepository.create(new User());
                userLoginRegisterMenu();
            } else {
                ExitFromCinema();
            }
        } catch (RuntimeException e) {
            System.out.println("Main menu error" + e.getMessage());
            userLoginRegisterMenu();
        }
    }
}

