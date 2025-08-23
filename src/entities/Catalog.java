package entities;

import java.util.ArrayList;
import java.util.List;

public class Catalog{

private List<Medias> mediaList = new ArrayList<>();

public Catalog(){
}

//Método para listar o catálogo
public String listingMedia(){

        //SE não tiver mídias.
        if(mediaList.isEmpty()){

            return "No media.";

        }

        //StringBuilder para incrementar nos textos do catálogo
        StringBuilder sbMusic = new StringBuilder();

        sbMusic.append("Musics:\n");

        for(Medias i : mediaList){

            //SE a midia listada for instância de música, ela será adicionada ao StringBuilder
            if(i instanceof Music){
                sbMusic.append(i).append("\n\n");
            }

        }

        sbMusic.append("Audiobooks:\n");

        for(Medias i : mediaList){

            //SE a midia listada for instância de audiobook, ela será adicionada ao StringBuilder
            if(i instanceof Audiobook){
                sbMusic.append(i).append("\n\n");
            }

        }

        sbMusic.append("Podcasts:\n");

        for(Medias i : mediaList){

            //SE a midia listada for instância de podcast, ela será adicionada ao StringBuilder
            if(i instanceof Podcast){

                sbMusic.append(i).append("\n\n");

            }

        }

        return sbMusic.toString();
    }

    //Método para adicionar mídia
    public void addMedia(Medias media){

    mediaList.add(media);

}

//Método para remover mídia
public void removeMedia(Medias media){

    mediaList.remove(media);

}



}
