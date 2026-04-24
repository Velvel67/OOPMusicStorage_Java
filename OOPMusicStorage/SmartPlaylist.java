/**
 * simple, child class that only 
 * allows song of a specific genre.
 */

public class SmartPlaylist extends PlaylistClass {
    private String genre;

    /**
     * creates constructor, takes parents name but
     * sets the genre as an attribute as well.
     */
    public SmartPlaylist(String name, String genre){
        super(name); // calls PlaylistClass constructor
        this.genre = genre;
    }

    /**
     * adds a song in to the smart playlist
     * using the PlaylistClass method but 
     * overrides it by only allowing the 
     * correct genre.
     */
    @Override
    public void addSong(SongClass song){
        if(song.getGenre().equals(genre)){
            super.addSong(song); // calls PlaylistClass addSong
        } else {
            System.out.println("Song not added — wrong genre for this playlist!");
        }
    }

    /**
     * gets the genre of the playlist
     */
    public String getGenre(){ return genre; }
}
