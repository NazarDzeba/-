package Lab_1_Algorithms;
import java.util.Scanner;

public abstract class main3 {
    public static int recursiveFunction(int N) {
        int a1 = 3; // Перший член арифметичної прогресії
        int d = 4; // різниця між сусідніми членами арифметичної прогресії
        if (N == 1) {
            System.out.println("1-ий член прогресії = " + a1);
            return 3; // повертаємо перший член арифметичної прогресії
        } else {
            if (N <= 10) {
                System.out.println(N + "-ий член прогресії = " + (a1 + (N - 1) * d));
            }
            return recursiveFunction(N - 1) + d;
        }
    }

    public static void main(String[] args) {
        System.out.print("Введіть N: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // число N - число, для якого потрібно знайти n-ий член арифметичної прогресії
        System.out.println("n-ий член арифметичної прогресії = " + recursiveFunction(N));
    }
}
