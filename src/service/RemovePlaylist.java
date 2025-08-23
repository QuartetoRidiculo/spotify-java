package service;

import entities.User;
import utils.Utils;

import javax.swing.*;

public class RemovePlaylist {
    public static void removePlaylist(User user) {
        if(user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist foi encontrada.");
            return;
        }
        int playlistChoice = Utils.exibirMenu(user.getPlaylistNames());

        user.removePlaylist(playlistChoice);

        JOptionPane.showMessageDialog(null, "Removido com sucesso!");
    }
}
