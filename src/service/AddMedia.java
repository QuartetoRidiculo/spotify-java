package service;

import entities.*;
import enums.Genre;
import exceptions.ValidTime;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AddMedia {
    public static void createAudiobook(List<String> genreAudiobook, Catalog catalog) {
        Object[] infoAudiobook = ObterDadosMedia.obterDadosMedia();

        int generoEscolhido = Utils.exibirMenu(genreAudiobook);
        Genre genero = Genre.values()[generoEscolhido + 6];

        Medias audiobook = new Audiobook((String) infoAudiobook[0], (String) infoAudiobook[1], (Integer) infoAudiobook[2], (Integer) infoAudiobook[3], genero);
        try {
            catalog.addMedia(audiobook);
        } catch (ValidTime e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void createMusic(List<String> genreMusic, Catalog catalog) {
        Object[] infoMusica = ObterDadosMedia.obterDadosMedia();

        int generoEscolhido = Utils.exibirMenu(genreMusic);
        Genre genero = Genre.values()[generoEscolhido];

        Medias musica = new Music((String) infoMusica[0], (String) infoMusica[1], (Integer) infoMusica[2], (Integer) infoMusica[3], genero);

        try {
            catalog.addMedia(musica);
        } catch (ValidTime e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void createPodcast(Catalog catalog) {
        Object[] infoPodcast = ObterDadosMedia.obterDadosMedia();

        Medias podcast = new Podcast((String) infoPodcast[0], (String) infoPodcast[1], (Integer) infoPodcast[2], (Integer) infoPodcast[3]);
        try {
            catalog.addMedia(podcast);
        } catch (ValidTime e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
