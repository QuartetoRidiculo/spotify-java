package entities;

import utils.Utils;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User extends Playlist {
    private String username;
    private String email;
    private LocalDate plDate;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private List<Playlist> playlists = new ArrayList<>();

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Cria nova playlist
    public void addPlaylist(String playlistName) {
        Playlist playlist = new Playlist(this, playlistName);
        plDate = LocalDate.now();
        playlists.add(playlist);
    }

    // Remove playlist pelo índice
    public void deletePlaylist(int playlistID) {
        playlists.remove(playlistID);
    }

    // Adiciona mídia a uma playlist específica
    public void addMediaToPlaylist(int playlistID, Medias media) {
        playlists.get(playlistID).getMediasList().add(media);
    }

    // Remove mídia de uma playlist específica
    public void removeMediaFromPlaylist(int playlistID, int mediaID) {
        playlists.get(playlistID).getMediasList().remove(mediaID);
    }

    // Método para mostrar informações gerais da playlist
    public String getPlaylistInfo(int playlistID) {
        Playlist playlist = playlists.get(playlistID);
        StringBuilder sb = new StringBuilder();

        sb.append("Playlist name: ").append(playlist.getName()).append("\n");
        sb.append("Playlist time: ").append(playlist.totalTime()).append("\n");
        sb.append("Playlist created: ").append(plDate.format(dateFormatter)).append("\n");

        return sb.toString();
    }

    public void getFormattedPlaylistMedias(int playlistID) {
        Playlist playlist = playlists.get(playlistID);

        if (playlist.getMediasList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Esta playlist não possui nenhuma mídia.");
            return;
        }

        List<String> mediaMenu = new ArrayList<>();
        for (Medias media : playlist.getMediasList()) {
            mediaMenu.add(media.getTitle());
        }

        int choiceMedia = Utils.exibirMenu(mediaMenu,"Selecionar Mídia");

        if (choiceMedia == -1 || choiceMedia == -2) {
            return;
        }

        JOptionPane.showMessageDialog(null, playlist.getMediasList().get(choiceMedia));
    }

    public List<Medias> getPlaylistMedias(int playlistID) {
        Playlist playlist = playlists.get(playlistID);

        return playlist.getMediasList();
    }

    public List<String> getPlaylistNames() {
        List<String> names = new ArrayList<>();
        for (Playlist p : playlists) {
            names.add(p.getName());
        }
        return names;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
