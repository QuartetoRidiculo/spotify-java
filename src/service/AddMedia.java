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

            int generoEscolhido;

            while (true) {
                generoEscolhido = Utils.exibirMenu(genreAudiobook, "Selecionar Gênero de Audiobook");

                if (generoEscolhido == -1) {
                    int exit = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                    if (exit == JOptionPane.YES_OPTION) {
                        return;
                    }
                    continue;
                }

                if (generoEscolhido == -2) {
                    continue;
                }

                break;
            }

            Genre genero = Genre.values()[generoEscolhido + 6];

            Medias audiobook = new Audiobook((String) infoAudiobook[0], (String) infoAudiobook[1], (Integer) infoAudiobook[2], (Integer) infoAudiobook[3], genero);

            catalog.addMedia(audiobook);

            JOptionPane.showMessageDialog(null, "Audiobook adicionado com sucesso!");
        } catch (CancelOperationException e) {
        }
    }

    public static void createMusic(List<String> genreMusic, Catalog catalog) {
        try {
            Object[] infoMusica = ObterDadosMedia.obterDadosMedia();

            int generoEscolhido;

            while (true) {
                generoEscolhido = Utils.exibirMenu(genreMusic, "Selecionar Gênero de Música");

                if (generoEscolhido == -1) {
                    int exit = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                    if (exit == JOptionPane.YES_OPTION) {
                        return;
                    }
                    continue;
                }

                if (generoEscolhido == -2) {
                    continue;
                }

                break;
            }

            Genre genero = Genre.values()[generoEscolhido];

            Medias musica = new Music((String) infoMusica[0], (String) infoMusica[1], (Integer) infoMusica[2], (Integer) infoMusica[3], genero);

            catalog.addMedia(musica);

            JOptionPane.showMessageDialog(null, "Musica adicionada com sucesso!");
        } catch (CancelOperationException e) {
        }
    }

    public static void createPodcast(Catalog catalog) {
        try {
            Object[] infoPodcast = ObterDadosMedia.obterDadosMedia();

            Medias podcast = new Podcast((String) infoPodcast[0], (String) infoPodcast[1], (Integer) infoPodcast[2], (Integer) infoPodcast[3]);

            catalog.addMedia(podcast);

            JOptionPane.showMessageDialog(null, "Podcast adicionado com sucesso!");
        } catch (CancelOperationException e) {
        }
    }
}
