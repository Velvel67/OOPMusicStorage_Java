import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main{
    /**
     * Many people enjoy listening to music using popular apps like Spotify, iTunes, or YouTube.
     * But these apps have their own problems that can make it challenging to enjoy; some have
     * subscriptions, many ads, or just poor features. It would be nice to have your own platform
     * that plays any music you want to listen to instantly without any ads. Additionally, it would
     * be great if you could enhance this platform in your own way.
     * 
     * My program does just that! Using several classes, a simple interface, and a child class, you can now
     * create a platform that has your music, stored as objects, that can be stored in several playlists, and
     * those playlists can be stored in your library. The song playlists and library all have their own unique and
     * similar features. Some important features/problems are creating an instance of a Song allowing it to have 
     * its own methods like displayInfo and Favorite. Another would be creating an instance of a Playlist,
     * which has its own methods like addSong, remove Song, and getTotalDuration. Another would be Library,
     * which stores all the playlists and also has its own methods. Lastly, a Main method that actually runs 
     * the program which connects all the classes with the user, giving it an authentic feeling.
     * *Unfortanetly, there is no way to actually play the music... yet.
     */
    public static void main(String[] args){

        //creates playlists
        PlaylistClass p1 = new PlaylistClass("Main");
        PlaylistClass p2 = new PlaylistClass("Random");
        PlaylistClass p3 = new PlaylistClass("Rock");

        //create one library, no attribute needed when initialized 
        LibraryClass library = new LibraryClass();

        //add playlists to the library
        library.addPlaylist(p1);
        library.addPlaylist(p2);
        library.addPlaylist(p3);

        /**
         * when the program runs, each line in a text file is converted into an instance of the song class
         * each song is then added to the first playlist "Main"
         * opens and reads the file, runs a while loop till it reaches the last line.
         * catchs an error if it cannot add the song from a file
         */
        try {
            BufferedReader reader = new BufferedReader(new FileReader("songs.txt"));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                SongClass song = new SongClass(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
                p1.addSong(song);
            }
            reader.close();
        } catch(Exception e){
            System.out.println("Could not load songs file!");
        }


        /**
         * simple check in main method to see if the smartPlaylist works,
         * I left it out as it doesnt really fit well into my programs purpose,
         * but it works.
         */
        // SmartPlaylist popOnly = new SmartPlaylist("Pop Only", "Pop");
        // SongClass s1 = new SongClass("Titi Mi Pregunto", "Bad Bunny", "Pop", 4.03);
        // SongClass s2 = new SongClass("ZEZE", "Kodak Black", "Rap", 3.48);
        // popOnly.addSong(s1); // works, s1 is Pop
        // popOnly.addSong(s2); // rejected, s3 is Rap
        
        // Scanner reads user input from terminal
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Welcome to Your Music Library!");
        System.out.println("There are already some songs and playlists saved for you!");
        System.out.println("Type /help to see available commands. Make sure to use the / when typing commands!");
        System.out.println("Type /exit to quit.");

        /**
         * Start of the actual program, runs till user types "/exit"
         * commands are mentioned above, /help /exit /anything else
         */
        while(!input.equals("/exit")){
            System.out.print("\n> ");
            input = scanner.nextLine();

            /**
             * a large set of anything the user can type into the terminal
             * that runs the program, help shows them each command. The implementation of said
             * commands is written below this if statement. a total of 6 commands were written to 
             * reflect the methods from all classes.
             * implements the scanner which actually takes the user input.
             */
            if (input.equals("/help")){
                System.out.println("Available commands:");
                System.out.println("/allSongs - display all songs in library");
                System.out.println("/allPlaylists - display all playlists");
                System.out.println("/createPlaylist - create a new playlist");
                System.out.println("/addSong - add a song to a playlist. You can also add songs to the Songs.txt file and restart the program.");
                System.out.println("/removeSong - remove a song from a playlist");
                System.out.println("/changeLibraryName - change your library name");
                System.out.println("/exit - quit the program");

            } else if (input.equals("/allSongs")){
                library.displayAllSongs();

            } else if (input.equals("/allPlaylists")){
                library.displayAllPlaylists();

            } else if (input.equals("/createPlaylist")){
                System.out.print("Enter playlist name: ");
                String name = scanner.nextLine();
                PlaylistClass newPlaylist = new PlaylistClass(name);
                library.addPlaylist(newPlaylist);
                System.out.println("Playlist '" + name + "' created!");

            } else if (input.equals("/addSong")){
                System.out.print("Enter song title: ");
                String title = scanner.nextLine();
                System.out.print("Enter artist: ");
                String artist = scanner.nextLine();
                System.out.print("Enter genre: ");
                String genre = scanner.nextLine();
                System.out.print("Enter duration: ");
                double duration = Double.parseDouble(scanner.nextLine());
                System.out.print("Which playlist? ");
                String playlistName = scanner.nextLine();
                
                PlaylistClass found = library.getPlaylistName(playlistName);
                if(found != null){
                    SongClass newSong = new SongClass(title, artist, genre, duration);
                    found.addSong(newSong);
                    System.out.println("Song added to " + playlistName + "!");
                } else {
                    System.out.println("Playlist not found!");
                }

            } else if (input.equals("/removeSong")){
                System.out.print("Enter song title to remove: ");
                String title = scanner.nextLine();
                System.out.print("Which playlist? ");
                String playlistName = scanner.nextLine();

                PlaylistClass found = library.getPlaylistName(playlistName);
                if(found != null){
                    found.removeSong(title);
                    System.out.println("Song removed from " + playlistName + "!");
                } else {
                    System.out.println("Playlist not found!");
                }

            } else if (input.equals("/changeLibraryName")){
                System.out.print("Enter new library name: ");
                String newName = scanner.nextLine();
                library.setLibraryName(newName);
                System.out.println("Library name changed to '" + newName + "'!");
            //last written command!
            } else if (!input.equals("/exit")){
                System.out.println("Unknown command! Type /help to see available commands.");
            } //left as else if becuase there can be an infinite amount of commands, as long as it connects to a method or purpose.
              //not every method was put in main, but it can.
        }
        System.out.println("User has exited the program.\nGoodbye for now :)");
        scanner.close();
    }
}
