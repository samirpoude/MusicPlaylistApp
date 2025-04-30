import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class MusicPlaylistApp {
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        ListIterator<String> iterator = playlist.listIterator();
        Scanner scanner = new Scanner(System.in);

        String currentSong = null;
        boolean running = true;

        while (running) {
            System.out.println("\n--- Music Playlist Menu ---");
            System.out.println("1. Add song");
            System.out.println("2. Next song");
            System.out.println("3. Previous song");
            System.out.println("4. Remove current song");
            System.out.println("5. Display current song");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter song name to add: ");
                    String song = scanner.nextLine().trim();
                    playlist.add(song);
                    // Reset iterator to the start
                    iterator = playlist.listIterator();
                    System.out.println("Added: " + song);
                }

                case 2 -> {
                    if (iterator.hasNext()) {
                        currentSong = iterator.next();
                        System.out.println("Now playing: " + currentSong);
                    } else {
                        System.out.println("End of playlist.");
                    }
                }

                case 3 -> {
                    if (iterator.hasPrevious()) {
                        currentSong = iterator.previous();
                        System.out.println("Now playing: " + currentSong);
                    } else {
                        System.out.println("Start of playlist.");
                    }
                }

                case 4 -> {
                    if (currentSong != null) {
                        iterator.remove();  // remove last returned by next()/previous()
                        System.out.println("Removed: " + currentSong);
                        currentSong = null;
                    } else {
                        System.out.println("No song selected to remove.");
                    }
                }

                case 5 -> {
                    if (currentSong != null) {
                        System.out.println("Current song: " + currentSong);
                    } else {
                        System.out.println("No song is currently selected.");
                    }
                }

                case 6 -> {
                    running = false;
                    System.out.println("Exiting playlist...");
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
