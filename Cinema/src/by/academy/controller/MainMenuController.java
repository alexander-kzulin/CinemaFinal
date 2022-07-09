package by.academy.controller;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static by.academy.controller.userController.UserRegisterController.userLoginRegisterMenu;
import static javax.swing.JOptionPane.*;

public class MainMenuController extends JFrame {
    public MainMenuController() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
    }

    public static void MainMenuStart() {
        try {
            MainMenuController frame = new MainMenuController();
            BufferedImage bufferedImage = ImageIO.read(new File("Cinema/pictures/Belarus_medium.png"));
            Image image = bufferedImage.getScaledInstance(500, 250, Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(image);
            Object[] button = {"Continue", "Exit"};
            int result = JOptionPane.showOptionDialog(frame,
                    "TODAY IN OUR CINEMA: \nTerminator 4\nHarry Potter 6",
                    "WELCOME TO OUR CINEMA!",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, button, button[0]);

            if (result == YES_OPTION) {
                userLoginRegisterMenu();

            } else {
                ExitFromCinema();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Main menu error " + e.getMessage());
        }
    }

    public static void ExitFromCinema() {
        Object[] button1 = {"YES", "NO"};
        int result1 = showOptionDialog(null, "Are you sure want to quit?", "Click A Button",
                YES_NO_CANCEL_OPTION, INFORMATION_MESSAGE, null, button1, button1[0]);
        if (result1 == YES_OPTION) {
            System.exit(0);
        } else if (result1 == NO_OPTION) {
            MainMenuStart();
        } else {
            System.exit(0);
        }
    }
}