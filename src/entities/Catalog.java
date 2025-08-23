package entities;

import enums.Genre;
import exceptions.ValidTime;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Medias> mediaList = new ArrayList<>();

    public Catalog() {
    }

    //Método para listar o catálogo
    public String listingMedia() {

        //SE não tiver mídias.
        if (mediaList.isEmpty()) {

            return "No media.";

        }

        //StringBuilder para incrementar nos textos do catálogo
        StringBuilder sbMusic = new StringBuilder();

        sbMusic.append("Musics:\n");

        for (Medias i : mediaList) {

            //SE a midia listada for instância de música, ela será adicionada ao StringBuilder
            if (i instanceof Music) {
                sbMusic.append(i).append("\n\n");
            }

        }

        sbMusic.append("Audiobooks:\n");

        for (Medias i : mediaList) {

            //SE a midia listada for instância de audiobook, ela será adicionada ao StringBuilder
            if (i instanceof Audiobook) {
                sbMusic.append(i).append("\n\n");
            }

        }

        sbMusic.append("Podcasts:\n");

        for (Medias i : mediaList) {

            //SE a midia listada for instância de podcast, ela será adicionada ao StringBuilder
            if (i instanceof Podcast) {

                sbMusic.append(i).append("\n\n");

            }

        }

        return sbMusic.toString();
    }

    //Método para adicionar mídia
    public void addMedia(Medias media) throws ValidTime {

        //Fazendo exceção de tempo válido
        if (media.getMinutes() < 0 || media.getSeconds() > 59 || media.getSeconds() < 0) {

            throw new ValidTime("Insira um tempo válido");

        }

        mediaList.add(media);

    }

    //Método para remover mídia
    public void removeMedia(Medias media) {

        mediaList.remove(media);
    }

    // Buscar por título
    public void buscarPorTitulo(String titulo) {
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.getTitle().equalsIgnoreCase(titulo)) {
                JOptionPane.showMessageDialog(null,m);
                achou = true;
            }
        }
        if (!achou) JOptionPane.showMessageDialog(null,"Nenhuma mídia encontrada com esse título.");

    }

    // Buscar por artista
    public void buscarPorArtista(String artista) {
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.getArtist().equalsIgnoreCase(artista)) {
                JOptionPane.showMessageDialog(null,m);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhuma mídia encontrada para esse artista.");
    }

    // Buscar por gênero
    public void buscarPorGenero(String genero) {
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.getGenre().toString().equalsIgnoreCase(genero)) {
                JOptionPane.showMessageDialog(null,m);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhuma mídia encontrada nesse gênero.");
    }
}