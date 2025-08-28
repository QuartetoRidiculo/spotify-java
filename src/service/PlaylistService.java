package service;

import entities.*;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class PlaylistService {
    public static void createPlaylist(User user){
        String name;
        while(true){
            name = JOptionPane.showInputDialog("Digite o nome do playlist: ");

            if(name == null){
                break;
            }

            if (name.isEmpty()) {
                continue;
            }

            break;
        }

        user.addPlaylist(name);
    }

    public static void removePlaylist(User user) {
        if(user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist foi encontrada.");
            return;
        }
        int playlistChoice = Utils.exibirMenu(user.getPlaylistNames());

        user.deletePlaylist(playlistChoice);

        JOptionPane.showMessageDialog(null, "Removido com sucesso!");
    }

    public static void addMediaPlaylist(User user, Catalog catalog) {
        int playlistId = Utils.exibirMenu(user.getPlaylistNames());

        if (playlistId == -1) {
            return;
        }

        int mediaId = Utils.exibirMenu(catalog.getMediaTitles());

        if (mediaId == -1) {
            return;
        }

        List<Medias> medias = catalog.getMediaList();

        for (Medias m : medias) {

            if (catalog.getMediaList().get(mediaId).getTitle().equals(m.getTitle())){

                if(user.getPlaylistMedias(playlistId).contains(m.getTitle())){
                    JOptionPane.showMessageDialog(null,"Media já na playlist.");
                    return;
                }

                    user.addMediaToPlaylist(playlistId, m);
                    JOptionPane.showMessageDialog(null, "A media foi adicionada com sucesso!");
                    return;
            }
        }

    }

    public static void viewPlaylistInformation(User user) {
        if (user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum playlist foi encontrada!") ;
            return;
        }


        int playlistId = Utils.exibirMenu(user.getPlaylistNames());

        if(playlistId == -1){
            return;
        }

        JOptionPane.showMessageDialog(null, user.getPlaylistInfo(playlistId));
    }

    public static void listPlaylists(User user){
        if(user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist foi encontrada.");
            return;
        }

        int playlistChoice = Utils.exibirMenu(user.getPlaylistNames());

        for(int c = 0; c < user.getPlaylistNames().size(); c++){
            if (playlistChoice == c){
                JOptionPane.showMessageDialog(null, user.getPlaylistMedias(c));
            }
        }
    }
}
