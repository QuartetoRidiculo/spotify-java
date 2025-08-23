package entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    protected User user;
    protected String name;
    private List<Medias> listOfMedias = new ArrayList<>();

    public Playlist(){
    }

    public Playlist(User user, String name){

        this.user = user;
        this.name = name;

    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medias> getListOfMedias() {
        return listOfMedias;
    }

    //Método para calcular o tempo total de mídias em uma playlist
    public String totalTime(){

        Integer totalMinutes = 0;
        Integer totalSeconds = 0;

        for(Medias i : listOfMedias){

            totalMinutes += i.getMinutes();
            totalSeconds += i.getSeconds();

            if(totalSeconds >= 60){

                totalSeconds -= 60;
                totalMinutes += 1;

            }


        }

        return String.format("%02d",totalMinutes) + ":" + String.format("%02d",totalSeconds);

    }

}
