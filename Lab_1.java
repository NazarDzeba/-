package Lab_1_Algorithms; // підключаємо пакет для зберігання файлів
import java.util.Scanner; // підключаємо клас вводу

public class main1 { // головний клас з назвою Main
    public static void main(String[] args) { // головний метод (main), який є входом програми
        final int N = 13; // кількість елементів в масиві
        int[] arr = {-1, 5, 3, -9, 7, 4, 12, 19, -17, -4, 0, 10, 15}; // ініціалізуємо масив
        System.out.println("Вміст масиву arr:"); // виводимо заголовок
        printArray(arr, "arr", 0, N - 1); // викликаємо метод printArray для виводу масиву

        for(int i = 0; i < N; i++) { // цикл для заповнення масиву випадковими числами
            arr[i] = (int) (-21 + Math.random() * 42); // заповнюємо масив випадковими числами (від -20 до 20), використовуючи "Downcast" з double до int
        }
        System.out.println("Випадкові числа в масиві arr:"); // виводимо заголовок
        printArray(arr, "arr", 0, N -1); // викликаємо метод printArray для виводу масиву
        System.out.println("Введіть в масив arr цілі числа з клаввіатури"); // виводимо заголовок
        int[] numbers = new int[N]; // створюємо новий масив, в який ми запишемо числа введені з клавіатури
        for (int i = 0; i < N; i++) { // цикл, який дозволяє вводити числа в масив
            System.out.print("arr[" + i + "]" + " = "); // виводимо запрошення
            Scanner scanner = new Scanner(System.in); // підключаємо клас Scanner, щоб вводити числа в консоль
            if (scanner.hasNextInt()) { // умова, яка перевіряє, чи користувач ввів число, а не, наприклад, текст
                numbers[i] = scanner.nextInt(); // присвоюємо числа, які ввів користувач в масив numbers
            } else { // інакше
                System.out.println("Помилка! Введіть ціле число"); // якщо користувач ввів, наприклад слово, то виведеться заголовок
                i--; // декремент, щоб поки користувач не ввів число, цикл не продовжував свою роботу
            }
        }
        System.out.println("\nВміст масиву arr:"); // виводимо заголовок
        printArray(numbers, "arr", 0, N - 1); // викликаємо метод printArray для виводу масиву

        // Вирішуємо завдання
        float sumNegativeElements = 0; // середнє арифметичне від'ємних елементів
        int countNegativeElements = 0; // кількість від'ємних елементів
        int countZeroElements = 0; // кількість елементів рівних нулю

        for (int i = 0; i < N; i++) { // цикл, який перебирає всі елементи масиву
            if (numbers[i] < 0) { // умова, якщо елемент масиву менший за нуль
                countNegativeElements++; // якщо число менше за нуль, змінна countNegativeElements збільшується на 1
            }
            if (numbers[i] == 0) { // умова, якщо елемент масиву рівний нулю
                countZeroElements++; // якщо число рівне нулю, змінна countZeroElements збільшується на 1
            }
        }

        for (int i = 0; i < N; i++) { // цикл, який перебирає всі елементи масиву
            if (numbers[i] < 0) { // умова, якщо елемент масиву менший за нуль
                sumNegativeElements += numbers[i]; // якщо умова здійснюється, змінна sumNegativeElements додає цей елемент масиву
            }
        }
        if (countNegativeElements == 0) { // умова, якщо countNegativeElements рівна нулю
            System.out.println("В масиві немає від'ємних елементів"); // виводимо заголовок
        } else { // інакше
            System.out.println("Середнє арифметичне від'ємних елементів рівне " + sumNegativeElements/countNegativeElements); // виводимо середнє арифметичне від'ємних елементів
        }
        System.out.println("Кількість нульових елементів в масиві: " + countZeroElements); // кількість нульових елементів в масиві
    }

    public static void printArray( // функція для виводу одновимірного масиву
            int[] a, // назва масиву, який потрібно вивести
            String name, // ім'я масиву
            int p,  // початковий індекс виведення
            int k  // кінцевий індекс виведення
    ) {
        int coutOfFor = 0; // інтервал переводу рядка
        for (int i = p; i <= k; i++) { // цикл, який виводить масив
            System.out.print(name + "[" + i + "]" + " = " + a[i] + "\t\t"); // виводимо масив
            if (coutOfFor == 4) { // перевірка для переводу рядка
                System.out.println(); // переводимо на новий рядок
                coutOfFor = 0; // обнуляємо змінну інтервалу
            } else { // інакше
                ++coutOfFor; // збільшуємо змінну інтервалу
            }
        }
        System.out.println(); // переводимо на новий рядок
    }
}
package Lab_1_Algorithms; // підключаємо пакет для зберігання файлів
import java.util.Scanner; // підключаємо клас вводу

public class main2 { // головний клас з назвою Main
    public static void main(String[] args) { // головний метод (main), який є входом програми
        final int N = 5; // кількість рядків масиву
        final int M = 6; // кількість стовбців масиву
        float[][] arr = {{3.2f, -7.3f, 8.0f, 16.2f, 18.5f, -13.4f}, // масив
                                 {-1.2f, 0.7f, 9.9f, -2.3f, -0.9f, -4.7f},
                                 {-19.1f, 3.9f, 17.8f, -11.3f, 5.7f, 8.4f},
                                 {2.9f, 6.4f, -8.2f, 2.2f, -6.0f, -14.8f},
                                 {7.7f, -9.8f, -19.2f, 18.3f, 1.3f, 6.7f}};
        System.out.println("Вміст масиву arr[n][m]:"); // виводимо заголовок
        printDoubleArray(arr, "arr", N, M); // виводимо масив

        for (int i = 0; i < N; i++) { // цикл по рядках
            for (int j = 0; j < M; j++) { // цикл по стовбцях
                arr[i][j] = (float) (-21 + Math.random() * 22); // заповнюємо масив випадковими числами (від -20 до 20)
            }
        }
        System.out.println("Випадкові дійсні числа в масиві arr[n][m]:"); // виводимо заголовок
        printDoubleArray(arr, "arr", N, M); // виводимо масив
        float[][] numbers = new float[N][M]; // масив, який зберігає введені користувачем числа
        System.out.println("Введіть в масив arr[n][m] дійсні числа з клавіатури:"); // виводимо заголовок
        for (int i = 0; i < N; i++) { // цикл по рядках
            for (int j = 0; j < M; j++) { // цикл по стовбцях
                System.out.print("arr[" + i + "][" + j + "] = "); // заголовок
                Scanner scanner = new Scanner(System.in); // підключаємо клас Scanner, щоб вводити числа в консоль
                if (scanner.hasNextFloat()) { // умова, яка перевіряє, чи користувач ввів число, а не, наприклад, текст
                    numbers[i][j] = scanner.nextFloat(); // присвоюємо числа, які ввів користувач в масив numbers
                } else { // інакше
                    System.out.println("Помилка! Введіть дійсне число!"); // виводимо заголовок
                    j--; // декремент, щоб поки коритсувач не ввів число, цикл не продовжував свою роботу
                }
            }
        }
        System.out.println("\nДійсні числа в масиві arr[n][m]:"); // виводимо заголовок
        printDoubleArray(numbers, "arr", N, M); // виводимо масив

        // Вирішуємо завдання
        int quantityNumber = 0; // кількість елементів в масиві, більших за 1
        float sumNumbers = 0; // середнє арифметичне всіх елементів більших за 1
        for (int i = 0; i < N; i++) { // цикл по рядках
            for (int j = 0; j < M; j++) { // цикл по стовбцях
                if (numbers[i][j] > 1) { // умова, якщо число більше за 1
                    quantityNumber++; // то збільшуємо змінну quantityNumber на 1
                }
            }
        }
        for (int i = 0; i < N; i++) { // цикл по рядках
            for (int j = 0; j < M; j++) { // цикл по стовбцях
                if (numbers[i][j] > 1) { // умова, якщо число більше за 1
                        sumNumbers += numbers[i][j]; // додаємо всі елементи масиву, більші за 1 до змінної sumNumbers
                }
            }
        }
        System.out.println("Середнє арифметичне всіх елементів більших за один: " + sumNumbers/quantityNumber); // виводимо заголовок
    }

    public static void printDoubleArray( // функція для виводу одновимірного масиву
            float[][] a, // назва масиву, який потрібно вивести
            String name, // ім'я масиву
            int n,  // початковий індекс виведення
            int m  // кінцевий індекс виведення
    ) {
        int coutOfFor = 0; // інтервал переводу рядка
        for (int i = 0; i < n; i++) { // цикл по рядках
            for (int j = 0; j < m; j++) { // цикл по стовбцях
                System.out.printf("%s[%d][%d] = %.2f\t", name, i, j, a[i][j]); // виводимо масив
                if (coutOfFor == 2) { // перевірка для переводу рядка
                    System.out.println(); // переводимо на новий рядок
                    coutOfFor = 0; // обнуляємо змінну інтервалу
                } else { // інакше
                    ++coutOfFor; // збільшуємо змінну інтервалу
                }
            }
        }
        System.out.println(); // переводимо на новий рядок
    }
}
