import java.util.ArrayList;

public class LibraryClass {
    private String libraryName;
    private ArrayList<PlaylistClass> libraryList;

    /**
     * Constructor for LibraryClass
     * It does not need any parameters
     * as the name is hardcoded to start
     * for simplicity, and the list starts
     * empty, it only grows with the user.
     */
    public LibraryClass(){
        libraryName = "YourLibrary";
        libraryList = new ArrayList<>();
    }

    /**
     * if the user does not like the hardCoded
     * name, they can always set it to something 
     * else.
     */
    public void setLibraryName(String name){
        libraryName = name;
    }

    /**
     * takes an object of type playlist and
     * adds it to the libraryList, it does not have
     * to return anything. it shows all the playlists
     * in your library.
     */
    public void addPlaylist(PlaylistClass playlist){
        libraryList.add(playlist);
    }

    /**
     * opposite of addPlaylist, same idea
     * runs through library list, removing the playlist
     * if it is found in the library. literally just a 
     * simplified for loop with an if condition.
     */
    public void removePlaylist(String playlistTitle){
        libraryList.removeIf(playlist -> playlist.getPlaylist().equals(playlistTitle));        
    }

    /**
     * prints out all your playlists
     */
    public void displayAllPlaylists(){
        System.out.println("Your Library: " + libraryList);
    }

    /**
     * displays all your songs in a nice manner using displayInfo() at the bottom.
     * it works by creating a hidden playlist(just a collection of all your songs) 
     * that only adds unique songs, so it goes through each song which is stored in at
     * least one playlist(probably main) and adds it if it is unique, this ensures that 
     * when this code is run, each song is displayed with its info, but there are no 
     * duplicates. 
     */
    public void displayAllSongs(){
        ArrayList<SongClass> unique = new ArrayList<>();
        
        for(PlaylistClass playlist : libraryList){
            for(SongClass song : playlist.getSongs()){
                if(!unique.contains(song)){
                    unique.add(song);
                }
            }
        }
        
        System.out.println("All Songs in Your Library:");
        for(int i = 0; i < unique.size(); i++){
            System.out.print("Song " + (i+1) + ": ");
            unique.get(i).displayInfo();
        }
    }

    /**
     * checks to see if a playlist name entered actually
     * exists, if it doesnt it returns null.
     */
    public PlaylistClass getPlaylistName(String playlistTitle){
        for(PlaylistClass playlist : libraryList){
            if(playlist.getPlaylist().equals(playlistTitle)){
                return playlist;
            }
        }
        return null; 
    }
}
