package service;

import entities.*;
import enums.Genre;
import exceptions.CancelOperation;
import exceptions.ValidTime;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class AddMedia {

    /*Aba responsável por adicionar novas mídias, AudioBook, Musicas e Podcasts*/

    //Aqui começamos coletando os dados do "genreAudiobook para musicas/audiobook e catalog" lista de opções já criadas.
    public static void createAudiobook(List<String> genreAudiobook, Catalog catalog) {
        try {
        //O "Objeto []" é o tipo da variável que está disponibilizando as informações captadas na classe "ObterDadosMedia" Como: títulos, artistass e etc..., Para a variável infoAudiobook
        Object[] infoAudiobook = ObterDadosMedia.obterDadosMedia();

        //aqui a index onde solicita o menu geral criado na classe "Utils"

        int generoEscolhido = Utils.exibirMenu(genreAudiobook);
        Genre genero = Genre.values()[generoEscolhido + 6];

        
        //Aqui é adicionadas as informações seguindo a posição pré-determinada e é adicionada a variável que recebe os valores
        Medias audiobook = new Audiobook((String) infoAudiobook[0], (String) infoAudiobook[1], (Integer) infoAudiobook[2], (Integer) infoAudiobook[3], genero);

        //Try-catch é inserido para confirmar se a ação foi efetuada com sucesso ou ocorreu alguma falha.

            //aqui é onde a mídia é adicionada ao catalogo principal através do "catalog.addMedia(audiobook);"
            catalog.addMedia(audiobook);
            JOptionPane.showMessageDialog(null,"Audiobook cadastrado com sucesso!");
        } catch (CancelOperation e){
            //Faz nada
        } catch (ValidTime e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void createMusic(List<String> genreMusica, Catalog catalog) {

        Object[] infoMusica = ObterDadosMedia.obterDadosMedia();

        int genero = Utils.exibirMenu(genreMusica);
        Genre generoMusic = Genre.values()[genero];

        Medias musicas = new Music((String) infoMusica[0], (String) infoMusica[1], (Integer) infoMusica[2], (Integer) infoMusica[3], generoMusic);

        try {
            catalog.addMedia(musicas);
            JOptionPane.showMessageDialog(null,"Musica cadastrada com sucesso!");
        } catch (ValidTime e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //A unica um pouco distinta é a createPodcast, pois ela não tem genero pré-determinado, tirando esse detalhe a inserção é igual.
    public static void createPodcast(Catalog catalog) {

        Object[] infoPodcast = ObterDadosMedia.obterDadosMedia();

        Medias podcast = new Podcast((String) infoPodcast[0], (String) infoPodcast[1], (Integer) infoPodcast[2], (Integer) infoPodcast[3]);
        try {
            JOptionPane.showMessageDialog(null,"Podcast adicionado com sucesso!");
            catalog.addMedia(podcast);
        } catch (ValidTime e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
