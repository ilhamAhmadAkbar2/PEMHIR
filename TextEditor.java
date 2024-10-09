import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private Stack<String> textHistory;
    private Stack<String> redoStack;
    private String currentText;
    public TextEditor() {
        textHistory = new Stack<>();
        redoStack = new Stack<>();
        currentText = "";
    }

    public void write(String newText) {
        textHistory.push(currentText);
        currentText += newText;
        redoStack.clear();
        System.out.println("Teks ditambahkan.");
    }

    public void undo() {
        if (!textHistory.isEmpty()) {
            redoStack.push(currentText);
            currentText = textHistory.pop();
            System.out.println("Undo dilakukan.");
        } else {
            System.out.println("Tidak ada tindakan untuk di-undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            textHistory.push(currentText);
            currentText = redoStack.pop();
            System.out.println("Redo dilakukan.");
        } else {
            System.out.println("Tidak ada tindakan untuk di-redo.");
        }
    }

    public void show() {
        System.out.println("Isi teks saat ini:");
        System.out.println(currentText.isEmpty() ? "[Kosong]" : currentText);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu Text Editor:");
            System.out.println("1. Tulis Teks");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Lihat Teks");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan teks yang ingin ditambahkan : \n ");
                    String newText = scanner.nextLine();
                    editor.write(newText);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.show();
                    break;

                case 5:
                    System.out.println("berhasil keluar. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
