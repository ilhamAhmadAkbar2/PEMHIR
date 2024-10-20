import java.io.*;
import java.util.*;

public class FileSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<List<String>> queue = new LinkedList<>();

        try {
            // Meminta input path file dari pengguna
            System.out.print("Masukkan path file teks: ");
            String filePath = scanner.nextLine();

            // Meminta ukuran potongan
            System.out.print("Masukkan jumlah baris per bagian: ");
            int chunkSize = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer

            // Membaca file dan memprosesnya menjadi beberapa bagian
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            List<String> currentChunk = new ArrayList<>();
            int lineCount = 0;

            // Membaca file baris demi baris
            while ((line = reader.readLine()) != null) {
                currentChunk.add(line);
                lineCount++;

                // Jika sudah mencapai ukuran potongan, masukkan ke Queue dan buat potongan baru
                if (lineCount == chunkSize) {
                    queue.add(new ArrayList<>(currentChunk));
                    currentChunk.clear();
                    lineCount = 0;
                }
            }

            // Memasukkan potongan terakhir jika masih ada sisa baris
            if (!currentChunk.isEmpty()) {
                queue.add(currentChunk);
            }

            reader.close();

            // Menampilkan setiap bagian dari Queue
            System.out.println("\nHasil Pemotongan File:");
            int part = 1;
            while (!queue.isEmpty()) {
                System.out.println("Bagian " + part + ":");
                List<String> chunk = queue.poll();
                for (String content : chunk) {
                    System.out.println(content);
                }
                System.out.println("--------------------");
                part++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
