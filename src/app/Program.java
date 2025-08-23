package app;

import entities.User;
import enums.Genre;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
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

        while (true) {
            String name;
            while (true) {
                name = JOptionPane.showInputDialog("nome do usuário:");

                if (name == null) {
                    int exit = JOptionPane.showConfirmDialog(null,"Deseja encerrar o programa?");

                    if(exit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                    continue;
                }

                if(!name.isBlank()){
                    break;
                }
            }

            String email;
            while (true) {
                email = JOptionPane.showInputDialog("email do usuário:");

                if (email == null) {
                    int exit = JOptionPane.showConfirmDialog(null,"Deseja encerrar o programa?");

                    if(exit == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                    continue;
                }

                if(!email.isBlank() && email.contains("@")){
                    break;
                }
            }

            User user = new User(name, email);

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
                            // criar playlist
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
                            // Visualizar detalhes da playlist (músicas, duração total, etc.)
                            break;
                        case 5:
                            // Excluir playlist
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
                            break;
                        case 1:
                            // Listar todas as mídias do catálogo
                            break;
                        case 2:
                            // Buscar mídia por título
                            break;
                        case 3:
                            // Buscar mídia por artista
                            break;
                        case 4:
                            // Buscar mídia por gênero
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
