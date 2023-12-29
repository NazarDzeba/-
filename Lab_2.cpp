#include <iostream>
#include <cmath>
#include <climits>

using namespace std;

int main()
{
   /* 
	Дано ціле число R і цілочисельний масив розміру N. Знайти два різних елементи масиву, сума яких найбільш близька до числа R, і 	вивести ці елементи, а елементи, які знаходяться між ними, розмістити в пам'динамічно і роздрукувати. Якщо елементи 	знаходяться поруч - видалити відповідне повідомлення.
        Виконуємо завдання:
   */
    int N, R; // Кількість елементів у масиві та число R
    cout << "Введіть кількість елементів в масиві, N = ";
    cin >> N;
    cout << "Введіть число R = ";
    cin >> R;
    int* A = new int [N]; // Динамічний масив для зберігання чисел
    cout << "Введіть в масиві А цілі числа: \n";
    for (int i = 0; i < N; i++) {
        cout << "A[" << i + 1 << "] = ";
        cin >> A[i]; // Зчитування чисел та зберігання їх у масиві A
    }
    cout << endl; 
    int bestNumber1, // змінна, в якій зберігається одне з чисел, сума яких найбільш близька до числа R.
        bestNumber2,
        currentSum,
        difference,
        closestSum = INT_MAX, // Змінна для зберігання найближчої різниці до R
        index1, // Індекс першого числа в парі
        index2; // Індекс другого числа в парі   
    // Пошук пари чисел у масиві, сума яких найближча до R
    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            currentSum = A[i] + A[j]; // Обчислення суми пари чисел
            difference = abs(currentSum - R); // Розрахунок різниці від R
            if (difference < closestSum) {
                closestSum = difference;
                bestNumber1 = A[i];
                index1 = i;
                bestNumber2 = A[j];
                index2 = j;
            }
        }
    }
    cout << "Найближчі числа до R: " << bestNumber1 << " і " << bestNumber2 << endl;
    cout << "Їхня сума: " << bestNumber1 + bestNumber2 << endl;
    int iStart, iEnd;
    // Визначення діапазону елементів для масиву B
    if (abs(index1 - index2) > 1) { // Перевірка, чи індекси не сусідні
        if (index1 > index2) {
            iStart = index2 + 1;
            iEnd = index1 - 1;
        } else {
            iStart = index1 + 1;
            iEnd = index2 - 1;
        }
        int k = abs(iEnd - iStart) + 1; // Розмір масиву B
        int* B = new int[k]; // Створення динамічного масиву B
        cout << "\nЕлементи динамічного масиву:\n";
        for (int i = 0; i < k; i++) {
            B[i] = A[iStart + i]; // Копіювання елементів із A до B
            cout << "B[" << i + 1 << "] = " << B[i] << "\t";
        }
        delete [] B; // Видалення масиву B
    } else {
        cout << "Масив неможливо вивести!" << endl;
    }
    delete [] A; // Видалення масиву A
    return 0;
}
