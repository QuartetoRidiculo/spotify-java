package entities;

import javax.print.attribute.standard.Media;
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
        playlists.get(playlistID).getListOfMedias().add(media);
    }

    // Remove mídia de uma playlist específica
    public void removeMediaFromPlaylist(int playlistID, int mediaID) {
        playlists.get(playlistID).getListOfMedias().remove(mediaID);
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

    // Método para listar somente as mídias da playlist
    public String getPlaylistMedias(int playlistID) {
        Playlist playlist = playlists.get(playlistID);
        StringBuilder sb = new StringBuilder();

        sb.append("Mídias da playlist '").append(playlist.getName()).append("':\n");

        int index = 0;
        for (Medias media : playlist.getListOfMedias()) {
            sb.append(index++).append(" - ").append(media).append("\n");
        }

        return sb.toString();
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
