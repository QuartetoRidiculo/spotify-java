package service;

import entities.User;
import utils.Utils;

import javax.swing.*;

public class ViewPlaylist {
    public static void viewPlaylist(User user){
        if(user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist foi encontrada.");
            return;
        }

        int playlistChoice = Utils.exibirMenu(user.getPlaylistNames());

        for(int c = 0; c < user.getPlaylistNames().size(); c++){
            if (playlistChoice == c){
                JOptionPane.showMessageDialog(null, user.listPlaylist(c));
            }
        }
    }
}
