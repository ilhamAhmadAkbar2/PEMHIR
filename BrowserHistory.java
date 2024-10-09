import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {
    private Stack<String> historyStack;

    public BrowserHistory() {
        historyStack = new Stack<>();
    }

    public void browse(String website) {
        historyStack.push(website);
        System.out.println("Browsing: " + website);
    }

    public void back() {
        if (historyStack.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
        } else {
            String removedWebsite = historyStack.pop();
            System.out.println("Kembali dari: " + removedWebsite);
            if (!historyStack.isEmpty()) {
                System.out.println("Sekarang di: " + historyStack.peek());
            } else {
                System.out.println("Tidak ada website saat ini.");
            }
        }
    }

    public void view() {
        if (historyStack.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("History Browser (dari yang terbaru):");
            Stack<String> tempStack = (Stack<String>) historyStack.clone();
            while (!tempStack.isEmpty()) {
                System.out.println("- " + tempStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu Browser:");
            System.out.println("1. Browse Website");
            System.out.println("2. Kembali (Back)");
            System.out.println("3. Lihat History");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan URL website: ");
                    String website = scanner.nextLine();
                    browser.browse(website);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.view();
                    break;

                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
