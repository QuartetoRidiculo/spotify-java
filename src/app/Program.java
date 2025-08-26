package app;

import entities.*;
import enums.Genre;
import exceptions.ValidTime;
import service.*;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<String> mainMenu = new ArrayList<>(List.of(
                "Gerenciar Playlists",
                "Catálogo de Mídias",
                "Sair"));

        List<String> playlistMenu = new ArrayList<>(List.of(
                "Criar playlist",
                "Listar playlists",
                "Adicionar mídia à playlist",
                "Remover mídia da playlist",
                "Visualizar detalhes da playlist",
                "Excluir playlist"));

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

        List<String> genreMusic = new ArrayList<>(List.of(
                "ROCK",
                "POP",
                "JAZZ",
                "INDIE",
                "MPB",
                "RAP"));

        Catalog catalog = new Catalog();
        User user = null;

        boolean login = false;

        do {
            String name;
            while (true) {
                name = JOptionPane.showInputDialog("nome do usuário:");

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
                email = JOptionPane.showInputDialog("email do usuário:");

                if (email == null) {
                    int exit = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
                    if (exit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                    continue;
                }

                if (!email.isBlank() && email.contains("@") && email.contains("mail")) {
                    break;
                }
            }

            user = new User(name, email);
            login = true;

            Medias music = new Music("Rap do Minecraft", "Tauz", 3, 10, Genre.RAP);
            Medias audiobook = new Audiobook("O Hobbit", "J. R. R Tolkien", 180, 30, Genre.FANTASY);
            Medias podcast = new Podcast("Entrevistando Sophio", "Flow Podcast", 120, 30);

            try {
                catalog.addMedia(music);
                catalog.addMedia(audiobook);
                catalog.addMedia(podcast);
            } catch (ValidTime e) {
                System.out.println(e.getMessage());
            }
        } while (!login);

        while (login) {
            int choice = Utils.exibirMenu(mainMenu);

            if (choice == -1 || choice == 2) {
                int exit = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
                if (exit == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            switch (choice) {
                case 0: // Gerenciar playlists
                    while (true) {
                        int playlistChoice = Utils.exibirMenu(playlistMenu);
                        if (playlistChoice == -1) break;

                        switch (playlistChoice) {
                            case 0:
                                PlaylistService.createPlaylist(user);
                                break;
                            case 1:
                                PlaylistService.listPlaylists(user);
                                break;
                            case 2:
                                PlaylistService.addMediaPlaylist(user, catalog);
                                break;
                            case 3:
                                // Remover mídia da playlist (a implementar)
                                break;
                            case 4:
                                PlaylistService.viewPlaylistInformation(user);
                                break;
                            case 5:
                                PlaylistService.removePlaylist(user);
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                case 1: // Catálogo de mídias
                    while (true) {
                        int catalogChoice = Utils.exibirMenu(catalogMenu);
                        if (catalogChoice == -1) break;

                        switch (catalogChoice) {
                            case 0:
                                int escolhaMidia = Utils.exibirMenu(choiceMedia);
                                if (escolhaMidia == -1) break;

                                switch (escolhaMidia) {
                                    case 0:
                                        AddMedia.createAudiobook(genreAudiobook, catalog);
                                        break;
                                    case 1:
                                        AddMedia.createMusic(genreMusic, catalog);
                                        break;
                                    case 2:
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
                                // Buscar audiobook (implementar)
                                break;
                            case 3:
                                // Buscar música (implementar)
                                break;
                            case 4:
                                // Buscar podcast (implementar)
                                break;
                            case 5:
                                String titulo = JOptionPane.showInputDialog(null, "Digite o título para realizar a busca: ");
                                catalog.buscarPorTitulo(titulo);
                                break;
                            case 6:
                                String artista = JOptionPane.showInputDialog(null, "Digite o nome do artista para realizar a busca: ");
                                catalog.buscarPorArtista(artista);
                                break;
                            case 7:
                                catalog.BuscarPorGenero(genreAudiobook, genreMusic);
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                default:
                    break;
            }
        }
    }
}