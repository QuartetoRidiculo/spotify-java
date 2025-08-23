package entities;

public class Podcast extends Medias {

    public Podcast(){
        super();
    }

    public Podcast(String title, String artist, Integer minutes, Integer seconds){

        super(title, artist, minutes, seconds);

    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Title: " + title);
        sb.append("\nArtist: " + artist);
        sb.append("\nDuration: " + minutes + ":" + seconds);

        return sb.toString();
    }

}
