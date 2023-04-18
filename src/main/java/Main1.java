import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Main1 main = new Main1();
        main.run();
    }

    private void run() { // Задача "Спіраль"
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter("output.txt");
            int n = scanner.nextInt();
            if (n == 1) {
                out.println("0");
                out.close();
                System.exit(0);
            }
            char[][] a = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = '0';
                }
            }
            drawPart(0, a);
            a[n/2][n/2] = '0';
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(a[i][j]);
                }
                out.println();
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    public void drawPart(int m, char[][] a) {
        int n = a.length;
        for (int i = 0; i < n - 2 * m; i++) {
            a[m][m + i] = '1';
        }
        for (int i = 0; i < n - 2 * m; i++) {
            a[m + i][n - m - 1] = '1';
        }
        for (int i = 0; i < n - 2 * m; i++) {
            a[n - m - 1][n - m - i - 1] = '1';
        }
        for (int i = 0; i < n - 2 * m - 2; i++) {
            a[n - m - i - 1][m] = '1';
        }
        if (m + 2 < n) {
            a[m + 2][m + 1] = '1';
            drawPart(m + 2, a);
        }
    }
}