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


    // Buscar por musica
    public void buscarPorMusica (String musica){
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.getArtist().trim().substring(0, 1).toLowerCase().contains(musica.toLowerCase().substring(0, 1)) ||
                    m.getArtist().trim().equalsIgnoreCase(musica)) {
                JOptionPane.showMessageDialog(null, m);
                achou = true;
            }

        }
        if (!achou) JOptionPane.showMessageDialog(null, "Nenhuma mídia encontrada para esse artista.");
    }
    // Buscar por podcast
    public void buscarPorPodcast (String podcast){
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.get().trim().substring(0, 1).toLowerCase().contains(podcast.toLowerCase().substring(0, 1)) ||
                    m.getArtist().trim().equalsIgnoreCase(podcast)) {
                JOptionPane.showMessageDialog(null, m);
                achou = true;
            }
        }
        if (!achou) JOptionPane.showMessageDialog(null, "Nenhuma mídia encontrada para esse nome");
    }
    // Buscar por título
    public void buscarPorTitulo(String titulo) {
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.getTitle().trim().substring(0, 1).toLowerCase().contains(titulo.toLowerCase().substring(0, 1)) ||
                    m.getTitle().trim().equalsIgnoreCase(titulo)) {
                JOptionPane.showMessageDialog(null, m);
                achou = true;
            }
            if (!achou) JOptionPane.showMessageDialog(null, "Nenhuma mídia encontrada com esse título.");

        }
    }

    // Buscar por artista
    public void buscarPorArtista (String artista){
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.getArtist().trim().substring(0, 1).toLowerCase().contains(artista.toLowerCase().substring(0, 1)) ||
                    m.getArtist().trim().equalsIgnoreCase(artista)) {
                JOptionPane.showMessageDialog(null, m);
                achou = true;
            }
        }
        if (!achou) JOptionPane.showMessageDialog(null, "Nenhuma mídia encontrada para esse artista.");
    }

    // Buscar por gênero
    public void buscarPorGenero (String genero){
        boolean achou = false;
        for (Medias m : mediaList) {
            if (m.getGenre().trim().substring(0, 1).toLowerCase().contains(genero.toLowerCase().substring(0, 1)) ||
                    m.getGenre().trim().equalsIgnoreCase(genero)) { {
                JOptionPane.showMessageDialog(null, m);
                achou = true;
            }
        }
        if (!achou) JOptionPane.showMessageDialog(null, "Nenhuma mídia encontrada nesse gênero.");
    }
}