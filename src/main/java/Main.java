import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
//      try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        try (BufferedReader reader = Files.newBufferedReader(Path.of("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            String line = reader.readLine();
            String[] s = line.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                s = line.split(" ");
                for (int j = 0; j < s.length; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }

            int[] max = new int[m];
            for (int j = 0; j < m; j++) {
                max[j] = a[0][j];
                for (int i = 1; i < n; i++) {
                    if (a[i][j] > max[j]) max[j] = a[i][j];
                }
            }

            for (int i = 0; i < m; i++) {
                out.print(max[i]+" ");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    }

}
