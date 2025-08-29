package service;

import entities.*;
import utils.Utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistService {
    public static void createPlaylist(User user) {
        String name;
        while (true) {
            name = JOptionPane.showInputDialog("Digite o nome do playlist: ");

            if (name == null) {
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
        if (user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist foi encontrada.");
            return;
        }
        int playlistChoice = Utils.exibirMenu(user.getPlaylistNames(), "Selecionar Playlist");

        if (playlistChoice == -1 || playlistChoice == -2) {
            return;
        }

        user.deletePlaylist(playlistChoice);

        JOptionPane.showMessageDialog(null, "Removido com sucesso!");
    }

    public static void addMediaPlaylist(User user, Catalog catalog) {
        if (user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist foi encontrada.");
            return;
        }

        int playlistId = Utils.exibirMenu(user.getPlaylistNames(), "Selecionar Playlist");

        if (playlistId == -1 || playlistId == -2) {
            return;
        }

        int mediaId = Utils.exibirMenu(catalog.getMediaTitles(), "Selecionar Mídia");

        if (mediaId == -1 || mediaId == -2) {
            return;
        }

        List<Medias> medias = catalog.getMediaList();

        for (Medias m : medias) {
            if (m.getTitle().equals(medias.get(mediaId).getTitle())) {
                if (m instanceof Podcast || m instanceof Music) {
                    user.addMediaToPlaylist(playlistId, m);
                }
            }
        }

        JOptionPane.showMessageDialog(null, "A media foi adicionada com sucesso!");
    }

    public static void removeMediaPlaylist(User user) {
        if (user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist foi encontrada.");
            return;
        }

        int playlistId = Utils.exibirMenu(user.getPlaylistNames(), "Selecionar Playlist");

        if (playlistId == -1 || playlistId == -2) {
            return;
        }

        List<String> medias = new ArrayList<>();

        for (Medias m : user.getPlaylistMedias(playlistId)) {
            medias.add(m.getTitle());
        }

        if (medias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma mídia foi encontrada.");
            return;
        }

        int mediaId = Utils.exibirMenu(medias, "Selecionar Mídia");

        if (mediaId == -1 || mediaId == -2) {
            return;
        }

        user.removeMediaFromPlaylist(playlistId, mediaId);

        JOptionPane.showMessageDialog(null, "A media foi removida com sucesso!");
    }

    public static void viewPlaylistInformation(User user) {
        if (user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum playlist foi encontrada!");
            return;
        }

        int playlistId = Utils.exibirMenu(user.getPlaylistNames(), "Selecionar Playlist");

        if (playlistId == -1 || playlistId == -2) {
            return;
        }

        JOptionPane.showMessageDialog(null, user.getPlaylistInfo(playlistId));
    }

    public static void listPlaylists(User user) {
        if (user.getPlaylistNames().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma playlist foi encontrada.");
            return;
        }

        int playlistChoice = Utils.exibirMenu(user.getPlaylistNames(), "Selecionar Playlist");

        if (playlistChoice == -1 || playlistChoice == -2) {
            return;
        }

        for (int c = 0; c < user.getPlaylistNames().size(); c++) {
            if (playlistChoice == c) {
                user.getFormattedPlaylistMedias(c);
            }
        }
    }
}
