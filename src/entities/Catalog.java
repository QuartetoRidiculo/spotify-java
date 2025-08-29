package entities;

import enums.Genre;
import exceptions.ValidTime;
import utils.Utils;

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
    public String listMusic() {

        StringBuilder sbMusic = new StringBuilder();

        for (Medias i : mediaList) {

            //SE a midia listada for instância de música, ela será adicionada ao StringBuilder
            if (i instanceof Music) {
                sbMusic.append(i).append("\n\n");
            }
        }

        return sbMusic.toString();

    }

    //Método para listar audiobooks
    public String listAudiobook() {

        StringBuilder sbAudiobook = new StringBuilder();

        for (Medias i : mediaList) {

            //SE a midia listada for instância de audiobook, ela será adicionada ao StringBuilder
            if (i instanceof Audiobook) {
                sbAudiobook.append(i).append("\n\n");
            }

        }

        return sbAudiobook.toString();

    }

    //Método para listar podcast
    public String listPodcast() {

        StringBuilder sbPodcast = new StringBuilder();

        for (Medias i : mediaList) {

            //SE a midia listada for instância de podcast, ela será adicionada ao StringBuilder
            if (i instanceof Podcast) {

                sbPodcast.append(i).append("\n\n");

            }

        }

        return sbPodcast.toString();

    }


    //Método para adicionar mídia
    public void addMedia(Medias media) {
        mediaList.add(media);
    }

    //Método para remover mídia
    public void removeMedia(Medias media) {

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

    // Buscar por artista
    public void buscarPorArtista(String artista) {
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
    public void BuscarPorGenero(List<String> genreAudiobook, List<String> genreMusica) {
        ArrayList<String> Midias = new ArrayList<>(List.of("Musicas", "AudioBook"));

        int MidiaEscolhida = Utils.exibirMenu(Midias, "Escolha o Tipo de Mídia");
        int GeneroEscolhido;
        Genre genero = null;

        if (MidiaEscolhida == 0) {
            GeneroEscolhido = Utils.exibirMenu(genreMusica, "Selecionar Gênero de Música");
            genero = Genre.values()[GeneroEscolhido];
        } else if (MidiaEscolhida == 1) {
            GeneroEscolhido = Utils.exibirMenu(genreAudiobook, "Selecionar Gênero de Audiobook");
            genero = Genre.values()[GeneroEscolhido + 6];
        }

        ArrayList<String> MidiaFiltrada = new ArrayList<>();

        for (Medias midia : mediaList) {
            if (midia.getGenre() == genero) {
                MidiaFiltrada.add(midia.getTitle());
            }
        }

        String resultado = String.join("/n", MidiaFiltrada);

        if (MidiaFiltrada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma mídia foi encontrada.");
        } else {
            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    public ArrayList<String> getMediaTitles() {
        ArrayList<String> titles = new ArrayList<>();
        for (Medias m : mediaList) {
            if (m instanceof Podcast || m instanceof Music) {
                titles.add(m.getTitle());
            }
        }

        return titles;
    }

    public List<Medias> getMediaList() {
        return mediaList;
    }
}





