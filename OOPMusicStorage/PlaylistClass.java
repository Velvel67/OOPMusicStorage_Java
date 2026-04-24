import java.util.ArrayList;

public class PlaylistClass {

    private String playlistName;
    private ArrayList<SongClass> songsInPlaylist;
    private double playlistDuration;

    /**
     * Constructor for Playlist class
     * must take a name. also creates an empty arraylist
     * which will store any song that gets added.
     */
    public PlaylistClass(String name){
        playlistName = name;
        songsInPlaylist = new ArrayList<>();
    }

    /**
     * takes a song adds it to the arraylist(the playlist)
     */
    public void addSong(SongClass song){
        songsInPlaylist.add(song);
    }

    /**
     * opposite of add song, removes a song from the playlist,
     * uses a simplified for loop with a condition
     */
    public void removeSong(String title){
        songsInPlaylist.removeIf(song -> song.getTitle().equals(title));
    }

    /**
     * Displays all songs in a playlist
     * *Important*: it is different from display
     * all songs in the library class, this is only for
     * a specific playlist.
     */
    public void displayAllSongs(){
        System.out.println("Playlist: " + playlistName);
        for(int i = 0; i < songsInPlaylist.size(); i++){
            System.out.print("Song " + (i+1) + ": ");
            songsInPlaylist.get(i).displayInfo();
        }
    }

    /**
     * gets the total length of a playlist
     * by adding the time of all songs. It is not 
     * that accurate, as song length is not converted into
     * a double, rather just represented as minutes and seconds
     * in double form. e.g. 1:47 --> 1.47,  but 1.47 minutes would really
     * be roughly 1.29.
     */
    public double getTotalDuration(){
        playlistDuration=0;
        for(SongClass song : songsInPlaylist){
            playlistDuration = playlistDuration + song.getDuration();
        }
        return playlistDuration;
    }
    
    /**
     * used for displayAllSongs in the LibraryClass
     * gets ALL songs for ALL playlists, not just the playlist
     * we are working in. 
     */
    public ArrayList<SongClass> getSongs(){
        return songsInPlaylist;
    }

    /**
     * returns playlist name as a getter
     * if the user calls it.
     */
    public String getPlaylist(){return playlistName;}

    /**
     * returns the playlist name
     */
    @Override
    public String toString(){
        return playlistName;
    }

}
