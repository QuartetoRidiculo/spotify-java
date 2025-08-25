package entities;

import enums.Genre;

public class Music extends Medias{

    public Music(){
        super();
    }

    public Music(String title, String artist, Integer minutes, Integer seconds, Genre genre){

        super(title,artist,minutes,seconds,genre);

    }
    @Override
    public String toString(){
        return "Type: Music\n" + super.toString();
    }

}
