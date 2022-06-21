package by.academy.entity;

public class Film {

    private int filmId;

    private String filmName;

    private String sessionDate;

    private String sessionTime;

    private int ticketPrice;

    public Film() {
    }

    public Film(int filmId, String filmName, String sessionDate, String sessionTime, int ticketPrice) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
        this.ticketPrice = ticketPrice;
    }

    public Film(String filmName, String sessionTime, String sessionDate) {
        this.filmName = filmName;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getFilmId() {
        return filmId;
    }


    public String setFilmName(String filmName) {
        this.filmName = filmName;
        return filmName;
    }

    public String getFilmName() {
        return filmName;
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

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmName= " + filmName +
                ", sessionDate='" + sessionDate + '\'' +
                ", sessionTime='" + sessionTime + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}

