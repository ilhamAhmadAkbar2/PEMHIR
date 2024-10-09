import java.util.Scanner;

class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

public class Flight {
    private Passenger head;
    private Scanner scanner;

    public Flight() {
        this.head = null;
        this.scanner = new Scanner(System.in);
    }

    public void addPassenger() {
        System.out.print("Masukkan nama penumpang: ");
        String name = scanner.nextLine();
        Passenger newPassenger = new Passenger(name);

        if (head == null) {
            head = newPassenger;
        } else {
            Passenger temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newPassenger;
        }
        System.out.println(name + " ditambahkan ke daftar penumpang.");
    }

    public void removePassenger() {
        System.out.print("Masukkan nama penumpang yang ingin dihapus: ");
        String name = scanner.nextLine();

        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " telah dihapus dari daftar penumpang.");
            return;
        }

        Passenger temp = head;
        while (temp.next != null && !temp.next.name.equals(name)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(name + " tidak ditemukan dalam daftar penumpang.");
        } else {
            temp.next = temp.next.next;
            System.out.println(name + " telah dihapus dari daftar penumpang.");
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        Passenger temp = head;
        System.out.println("Daftar Penumpang:");
        while (temp != null) {
            System.out.println("- " + temp.name);
            temp = temp.next;
        }
    }

    public void run() {
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Penumpang");
            System.out.println("2. Hapus Penumpang");
            System.out.println("3. Tampilkan Daftar Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPassenger();
                    break;
                case 2:
                    removePassenger();
                    break;
                case 3:
                    displayPassengers();
                    break;
                case 4:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        Flight flight = new Flight();
        flight.run();
    }
}
