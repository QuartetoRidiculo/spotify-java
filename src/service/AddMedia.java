package service;

import entities.*;
import enums.Genre;
import exceptions.CancelOperationException;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class AddMedia {
    public static void createAudiobook(List<String> genreAudiobook, Catalog catalog) {
        try {
            Object[] infoAudiobook = ObterDadosMedia.obterDadosMedia();

            int generoEscolhido = Utils.exibirMenu(genreAudiobook, "Selecionar Gênero de Audiobook");
            Genre genero = Genre.values()[generoEscolhido + 6];

            Medias audiobook = new Audiobook((String) infoAudiobook[0], (String) infoAudiobook[1], (Integer) infoAudiobook[2], (Integer) infoAudiobook[3], genero);

            catalog.addMedia(audiobook);
        } catch (CancelOperationException e) {}
    }

    public static void createMusic(List<String> genreMusic, Catalog catalog) {
        try {
            Object[] infoMusica = ObterDadosMedia.obterDadosMedia();

            int generoEscolhido = Utils.exibirMenu(genreMusic, "Selecionar Gênero de Música");
            Genre genero = Genre.values()[generoEscolhido];

            Medias musica = new Music((String) infoMusica[0], (String) infoMusica[1], (Integer) infoMusica[2], (Integer) infoMusica[3], genero);


            catalog.addMedia(musica);
        } catch (CancelOperationException e) {}
    }

    public static void createPodcast(Catalog catalog) {
        try {
            Object[] infoPodcast = ObterDadosMedia.obterDadosMedia();

            Medias podcast = new Podcast((String) infoPodcast[0], (String) infoPodcast[1], (Integer) infoPodcast[2], (Integer) infoPodcast[3]);

            catalog.addMedia(podcast);
        } catch (CancelOperationException e) {}
    }
}
