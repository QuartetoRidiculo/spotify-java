package entities;

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

    public User(){
    }

    public User(String username, String email){

        this.username = username;
        this.email = email;

    }

    //Método para criar playlist
    public void createPlaylist(String playlistName){

        Playlist playlist = new Playlist(this, playlistName);

        plDate = LocalDate.now();

        playlists.add(playlist);

    }

    //Método para excluir playlist
    public void removePlaylist(int playlistID){

        playlists.remove(playlistID);

    }

    //Método para adicionar mídia a playlist
    public void addMedia(int playlistID, Medias media){

        playlists.get(playlistID).getListOfMedias().add(media);

    }

    //Método para remover mídia da playlist
    public void removeMedia(int playlistID, int mediaID){

        playlists.get(playlistID).getListOfMedias().remove(mediaID);

    }

    //Método para listar as mídias da playlist
    public String listPlaylist(int playlistID){

        StringBuilder sb = new StringBuilder();

        sb.append("Playlist name: ").append(playlists.get(playlistID).getName()).append("\n");
        sb.append("Playlist time: ").append(playlists.get(playlistID).totalTime()).append("\n");
        sb.append("Playlist created: ").append(plDate.format(dateFormatter)).append("\n");

        for(Medias i : playlists.get(playlistID).getListOfMedias()){
            sb.append(i);
        }

        return sb.toString();

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
