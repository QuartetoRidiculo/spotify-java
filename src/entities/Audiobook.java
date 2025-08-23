package entities;

import enums.Genre;

public class Audiobook extends Medias {

    public Audiobook(){
        super();
    }

    public Audiobook(String title, String artist, Integer minutes, Integer seconds, Genre genre){
        super(title,artist,minutes,seconds,genre);
    }

    @Override
    public String toString(){
        return "Type: Audiobook\n" + super.toString();
    }
}
