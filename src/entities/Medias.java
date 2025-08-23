package entities;

import enums.Genre;

public abstract class Medias{

    protected String title;
    protected String artist;
    protected Integer minutes;
    protected Integer seconds;
    protected Genre genre;

    public Medias(){

    }

    public Medias(String title, String artist, Integer minutes, Integer seconds) {
        this.title = title;
        this.artist = artist;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Medias(String title, String artist, Integer minutes, Integer seconds, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.minutes = minutes;
        this.seconds = seconds;
        this.genre = genre;
    }

    //Método toString para listar a mídia requirida
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Title: " + title);
        sb.append("\nArtist: " + artist);
        sb.append("\nDuration: " + String.format("%02d:%02d",minutes,seconds));
        sb.append("\nGenre: " + genre.toString() + "\n\n");

        return sb.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
