package service;

import entities.Playlist;
import entities.User;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListPlaylist {
    public static void listPlaylist(User user) {
        if (user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum playlist foi encontrada!") ;
            return;
        }


        int playlistId = Utils.exibirMenu(user.getPlaylistNames());

        if(playlistId == -1){
            return;
        }

        JOptionPane.showMessageDialog(null, user.listPlaylist(playlistId));
    }
}
