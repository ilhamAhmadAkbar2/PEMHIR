import java.util.Scanner;

class Song {
    String title;
    Song next;
    public Song(String title) {
        this.title = title;
        this.next = null;
    }
}

class Playlist {
    private Song head;

    public Playlist() {
        this.head = null;
    }

    public void addSong(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = newSong;
        } else {
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
        }
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist kosong.");
        } else {
            Song current = head;
            while (current != null) {
                System.out.println(current.title);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist myPlaylist = new Playlist();
        String title;
        String option;

        do {
            System.out.print("Masukkan judul lagu yang ingin anda tambah ke playlist :\n ");
            title = scanner.nextLine();
            myPlaylist.addSong(title);

            System.out.print("Apakah ingin menambah lagu lagi? (ya / tidak): ");
            option = scanner.nextLine();
        } while (option.equalsIgnoreCase("ya"));

        System.out.println("\nDaftar lagu di playlist:");
        myPlaylist.displayPlaylist();

        scanner.close();
    }
}
