package entities;

import exceptions.ValidTime;

import javax.swing.*;
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
        StringBuilder sbMedia = new StringBuilder();

        sbMedia.append("Musics:\n");

        //Listando músicas
        sbMedia.append(listMusic());

        sbMedia.append("Audiobooks:\n");

        //Listando audiobooks
        sbMedia.append(listAudiobook());

        sbMedia.append("Podcasts:\n");

        //Listando podcasts
        sbMedia.append(listPodcast());

        return sbMedia.toString();
    }

    //Método para listar músicas
    public String listMusic(){

    StringBuilder sbMusic = new StringBuilder();

        for(Medias i : mediaList){

            //SE a midia listada for instância de música, ela será adicionada ao StringBuilder
            if(i instanceof Music){
                sbMusic.append(i).append("\n\n");
            }
        }

        return sbMusic.toString();

    }

    //Método para listar audiobooks
    public String listAudiobook(){

    StringBuilder sbAudiobook = new StringBuilder();

        for(Medias i : mediaList){

            //SE a midia listada for instância de audiobook, ela será adicionada ao StringBuilder
            if(i instanceof Audiobook){
                sbAudiobook.append(i).append("\n\n");
            }

        }

        return sbAudiobook.toString();

    }

    //Método para listar podcast
    public String listPodcast(){

    StringBuilder sbPodcast = new StringBuilder();

        for(Medias i : mediaList){

            //SE a midia listada for instância de podcast, ela será adicionada ao StringBuilder
            if(i instanceof Podcast){

                sbPodcast.append(i).append("\n\n");

            }

        }

        return sbPodcast.toString();

    }


    //Método para adicionar mídia
    public void addMedia(Medias media) throws ValidTime {

    //Fazendo exceção de tempo válido
    if(media.getMinutes() < 0 || media.getSeconds() > 59 || media.getSeconds() < 0){

        throw new ValidTime("Insira um tempo válido");

    }

    mediaList.add(media);

}

//Método para remover mídia
public void removeMedia(Medias media){

    mediaList.remove(media);

}

    public void buscarPorTitulo(String titulo) {
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.getTitle().trim().substring(0, 1).toLowerCase().contains(titulo.toLowerCase().substring(0, 1)) ||
                    m.getTitle().trim().equalsIgnoreCase(titulo)) {
                JOptionPane.showMessageDialog(null, m);
                achou = true;
            }
        }
        if (!achou) JOptionPane.showMessageDialog(null, "Nenhuma mídia encontrada com esse título.");
    }

}
