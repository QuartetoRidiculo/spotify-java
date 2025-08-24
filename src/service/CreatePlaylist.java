package service;

import entities.Playlist;
import entities.User;

import javax.swing.*;

public class CreatePlaylist {
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

        user.createPlaylist(name);
    }
}
