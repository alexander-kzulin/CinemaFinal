package by.academy.entity;

import javax.swing.*;

public class Ticket {
    private int ticketId;

    private String userLogin;

    private String filmName;

    private int ticketPrice;

    private String sessionDate;

    private String sessionTime;

    private String placeNumber;

    public Ticket() {
    }

    public Ticket(int ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(String userLogin, String filmName, String placeNumber, String sessionDate, String sessionTime, int ticketPrice) {
        this.userLogin = userLogin;
        this.filmName = filmName;
        this.placeNumber = placeNumber;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(String placeNumber) {
        this.placeNumber = placeNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId: " + ticketId +
                ", userLogin: " + userLogin +
                ", filmName: " + filmName +
                ", ticketPrice: " + ticketPrice +
                ", sessionDate: " + sessionDate +
                ", sessionTime: " + sessionTime +
                ", placeNumber: " + placeNumber +
                '}';
    }
}

