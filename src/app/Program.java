package app;

import entities.*;
import enums.Genre;
import exceptions.ValidTime;
import service.*;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {

    public static void main(String[] args) throws ValidTime {
        // Menu principal
        List<String> mainMenu = new ArrayList<>(List.of(
                "Gerenciar Playlists",
                "Catálogo de Mídias",
                "Sair"));

        // Gerenciar Playlists
        List<String> playlistMenu = new ArrayList<>(List.of(
                "Criar playlist",
                "Listar playlists",
                "Adicionar mídia à playlist",
                "Remover mídia da playlist",
                "Visualizar detalhes da playlist",
                "Excluir playlist"));

        // Catálogo de Mídias
        List<String> catalogMenu = new ArrayList<>(List.of(
                "Cadastrar nova mídia",
                "Listar todas as mídias do catálogo",
                "Buscar audio book",
                "Buscar música",
                "Buscar podcast",
                "Buscar mídia por título",
                "Buscar mídia por artista",
                "Buscar mídia por gênero"));

        List<String> choiceMedia = new ArrayList<>(List.of(
                "Audiobook",
                "Música",
                "Podcast"));

        List<String> genreAudiobook = new ArrayList<>(List.of(
                "FANTASY",
                "SCI_FI",
                "ROMANCE",
                "RELIGIOUS"));

        List<String> genreMusica = new ArrayList<>(List.of(
                "ROCK",
                "POP",
                "JAZZ",
                "INDIE",
                "MPB",
                "RAP"));

        Catalog catalog = new Catalog();
        User user = null;

        Boolean login = false;

        do {
            String name;
            while (true){
                name = JOptionPane.showInputDialog("Nome do usuário:");

                if (name == null) {
                    int exit = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");

                    if (exit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                    continue;
                }

                if (!name.isBlank()) {
                    break;
                }
            }

            String email;
            while (true) {
                email = JOptionPane.showInputDialog("E-mail do usuário:");

                if (email == null) {
                    int exit = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");

                    if (exit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                    continue;
                }

                if (!email.isBlank() && email.contains("@gmail.com")) {
                    break;
                }
            }

            user = new User(name, email);

            login = true;

            Medias music = new Music("Rap do Minecraft", "Tauz", 3, 10, Genre.RAP);

            try {
                catalog.addMedia(music);
            } catch (ValidTime e) {
                System.out.println(e.getMessage());
            }

            Medias audiobook = new Audiobook("O Hobbit", "J. R. R Tolkien", 180, 30, Genre.FANTASY);

            try {
                catalog.addMedia(audiobook);
            } catch (ValidTime e) {
                System.out.println(e.getMessage());
            }

            Medias podcast = new Podcast("Entrevistando Sophio", "Flow Podcast", 120, 30);

            try {
                catalog.addMedia(podcast);
            } catch (ValidTime e) {
                System.out.println(e.getMessage());
            }
        } while (!login);

        while (true) {
            int choice = Utils.exibirMenu(mainMenu);

            if (choice == -1 || choice == 4) {
                break;
            }

            switch (choice) {

                case 0:

                    int playlistChoice = Utils.exibirMenu(playlistMenu);

                    if (playlistChoice == -1)
                        continue;

                    switch (playlistChoice) {
                        case 0:
                            CreatePlaylist.createPlaylist(user);
                            break;
                        case 1:
                            // listar playlist
                            break;
                        case 2:
                            // Adicionar mídia à playlist
                            break;
                        case 3:
                            // Remover mídia da playlist
                            break;
                        case 4:
                            ViewPlaylist.viewPlaylist(user);
                            break;
                        case 5:
                            RemovePlaylist.removePlaylist(user);
                            break;
                        default:
                            break;
                    }
                    break;

                case 1:

                    int cataloChoice = Utils.exibirMenu(catalogMenu);

                    if (cataloChoice == -1)
                        continue;

                    switch (cataloChoice) {
                        case 0:
                            // Cadastrar nova mídia (música, podcast, audiobook)
                            int escolhaMidia  = Utils.exibirMenu(choiceMedia);

                            if (escolhaMidia == -1) {
                                break;
                            }
                                switch (escolhaMidia){

                                    case 0:
                                        //Add Audiobook

                                        AddMedia.createAudiobook(genreAudiobook, catalog);
                                        break;
                                    case 1:
                                        //Add musica
                                        AddMedia.createMusic(genreMusica, catalog);
                                        break;
                                    case 2:
                                        //Add Podcast
                                        AddMedia.createPodcast(catalog);
                                        break;
                                    default:
                                        break;
                                }
                            break;
                        case 1:
                            ListMedia.listMedia(catalog);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            String titulo = JOptionPane.showInputDialog(null, "Informe o título para realizar a busca: ");
                            catalog.buscarPorTitulo(titulo);
                            break;
                        case 6:
                            String artista = JOptionPane.showInputDialog(null, "Informe o nome do ártista para realizar a busca: ");
                            break;
                        case 7:
                            String genero = JOptionPane.showInputDialog(null, "Informe o gênero para realizar a buscar: ");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    int exit = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");

                    if (exit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                default:
                    break;
            }
        }
    }
}
