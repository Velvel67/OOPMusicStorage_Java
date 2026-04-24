public class SongClass implements ManageableInterface{
    
    private String songTitle;
    private String songArtist;
    private String songGenre;
    private double songDuration;
    private static int favoriteCount=0;
    private boolean isFavorite = false;

    /**
     * constructor for the song class
     * each song takes 4 attributes
     */
    public SongClass(String title, String artist, String genre, double time){
        songTitle = title;
        songArtist = artist;
        songGenre = genre;
        songDuration = time;
    }

    /**
     * using the interfaces method which 
     * displays songs info. Used in playlist and library
     * class
     */
    public void displayInfo(){
        System.out.printf( "[%s, %s, %.2f, %s]\n", songTitle, songArtist, songDuration, songGenre );
    }

    /**
     * marks a song as favorite by making
     * the boolean True, also makes the total
     * favorite count go up
     */
    public void makeFavorite(){
        isFavorite = true;
        favoriteCount++;
    }

    /**
     * checks if a song is favorite
     */
    public boolean isFavorite(){
        return isFavorite;
    }

    /**
     * all getters for the songclass
     * can return favoriteCount, or any attribute
     * of the Song, for whatever purpose.
     */
    public static int getFavoriteCount(){return favoriteCount;}    
    public String getTitle(){return songTitle;}
    public String getArtist(){return songArtist;}
    public String getGenre(){return songGenre;}    
    public double getDuration(){return songDuration;}

    /**
     * all setters for the songclass, if anything needs to change
     * e.g. a name was spelled wrong. the user can change things
     * as they need
     */
    public void setTitle(String title){songTitle = title;}
    public void setArtist(String artist){songArtist = artist;}
    public void setDuration(double time){songDuration = time;}
    public void setGenre(String genre){songGenre = genre;}

    /**
     * checks if a song is equal to another song
     * by checking title name(this doesnt really make sense
     * now that im writing the block code.) it should check artist name
     * as well. the method uses the same logic as the practice midterm
     * bookclass.
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof SongClass){
            SongClass other = (SongClass) obj;
            if (songTitle.equals(other.getTitle())){
                return true;
            }
        }
        return false;
    }

    /**
     * returns the song with its title and name in string format.
     */
    @Override
    public String toString(){
        return songTitle + "by" +songArtist;
    }
}