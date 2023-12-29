package Lab_1_Algorithms;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Lab_4_Structures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Character> charList1 = new LinkedList<>();
        CharLinkedList charList2 = new CharLinkedList();

        System.out.println("Введіть символ для однозв'язного списку. Введіть '0' щоб зупинитись.");
        while (true) {
            String input = scanner.next();
            if (input.equals("0")) {
                break;
            }
            if (input.length() == 1) {
                char ch = input.charAt(0);
                charList2.addToEnd(ch);
            } else {
                System.err.println("Помилка! Введіть символ.");
            }
        }

        System.out.println("Введіть символ для двохзв'язного списку. Введіть '0' щоб зупинитись.");
        while (true) {
            String input = scanner.next();
            if (input.equals("0")) {
                break;
            }
            if (input.length() == 1) {
                char ch = input.charAt(0);
                charList1.add(ch);
            } else {
                System.out.println("Помилка! Введіть символ.");
            }
        }

        System.out.println("Список символів однозв'язного списку: ");
        charList2.printList();
        System.out.print("Список символів двохзв'язного списку: " + charList1);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nВведіть число щоб виконати дію: ");
            System.out.println("1. Додати символ на початок.");
            System.out.println("2. Додати символ в кінець.");
            System.out.println("3. Додати символ всередину.");
            System.out.println("4. Видалити символ.");
            System.out.println("5. Знайти символ за значенням.");
            System.out.println("0. Вийти.");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Введіть символ, який ви хочете додати: ");
                    char ch1 = scanner.next().charAt(0);
                    // Операції додавання
                    charList1.addFirst(ch1);
                    charList2.addToFront(ch1);
                    System.out.println("Дію виконано!");
                    break;
                case 2:
                    System.out.println("Введіть символ, який ви хочете додати в кінець: ");
                    char ch2 = scanner.next().charAt(0);
                    charList1.addLast(ch2);
                    charList2.addToEnd(ch2);
                    System.out.println("Дію виконано!");
                    break;
                case 3:
                    System.out.println("Введіть символ, який ви хочете додати в середину однозв'язного списку: ");
                    char addForSingleList = scanner.next().charAt(0);
                    System.out.println("Введіть символ, який ви хочете додати в середину двозв'язного списку: ");
                    char addForDoublyList = scanner.next().charAt(0);
                    System.out.println("Введіть символ, після якого ви хочете додати в середину однозв'язного списку: ");
                    char addAfterForSingleList = scanner.next().charAt(0);
                    System.out.println("Введіть символ, після якого ви хочете додати в середину двозв'язного списку: ");
                    char addAfterForDoublyList = scanner.next().charAt(0);

                    ListIterator<Character> iterator = charList1.listIterator();
                    while (iterator.hasNext()) {
                        if (iterator.next() == addAfterForDoublyList) {
                            iterator.add(addForDoublyList);
                            break;
                        }
                    }
                    charList2.addAfterValue(addAfterForSingleList, addForSingleList);
                    System.out.println("Дію виконано!");
                    break;
                case 4:
                    System.out.println("Введіть символ, який ви хочете видалити: ");
                    char ch4 = scanner.next().charAt(0);
                    charList1.removeFirstOccurrence(ch4);
                    charList2.delete(ch4);
                    System.out.println("Дію виконано!");
                    break;
                case 5:
                    System.out.println("Введіть символ, який ви хочете знайти: ");
                    char ch5 = scanner.next().charAt(0);
                    if (charList1.contains(ch5)) {
                        int index = charList1.indexOf(ch5);
                        System.out.println("Шуканий символ '" + ch5 + "' знаходиться на індексі " + index + " в двохзв'язному списку");
                    } else {
                        System.out.println("Символ '" + ch5 + "' не знайдено.");
                    }
                    System.out.print("Чи включає однозв'язний список символ " + ch5 + "?\t");
                    System.out.println(charList2.contains(ch5));
                    System.out.println("Дію виконано!");
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Неправильоно введено число!");
                    break;
            }
        }

        System.out.println("Модифікований список символів: " + charList1);
        System.out.print("Модифікований список символів: ");
        charList2.printList();

        System.out.println("\n\nЗавдання 1:");
        // Створення третього списку
        CharLinkedList result1 = new CharLinkedList();
        System.out.println("Введіть символ: ");
        char ch6 = scanner.next().charAt(0); // Заданий символ для порівняння

        for (Character ch : charList1) {
            if (ch < ch6) {
                result1.addToEnd(ch);
            }
        }
        LinkedList<Character> charList2AsLinkedList = new LinkedList<>();
        char[] charList2Array = charList2.filterCharsLessThan(ch6);
        for (char ch : charList2Array) {
            result1.addToEnd(ch);

        }
        System.out.print("Результуючий список: ");
        result1.printList();
        System.out.println();

        System.out.println("\nЗавдання 2:");
        CharLinkedList result2 = new CharLinkedList();
        for (Character ch : charList1) {
            if (ch != 'a') {
                result2.addToEnd(ch);
            }
        }
        charList2Array = charList2.allElementsExceptA();
        charList2AsLinkedList.clear();  // Очищаємо charList2AsLinkedList перед використанням
        for (char ch : charList2Array) {
            result2.addToEnd(ch);
        }
        System.out.print("Результуючий список: ");
        result2.printList();
    }
}

package Lab_1_Algorithms;

public class CharLinkedList {

    private CharNode head;
    private int size;

    private static class CharNode {
        char data;
        CharNode next;

        CharNode(char data) {
            this.data = data;
        }
    }

    // Додавання елемента на початок списку
    public void addToFront(char data) {
        CharNode newNode = new CharNode(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Додавання елемента в кінець списку
    public void addToEnd(char data) {
        CharNode newNode = new CharNode(data);
        if (head == null) {
            head = newNode;
        } else {
            CharNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Додавання елемента в середину списку (після заданого значення)
    public void addAfterValue(char value, char data) {
        CharNode newNode = new CharNode(data);
        CharNode current = head;
        while (current != null && current.data != value) {
            current = current.next;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Видалення елемента зі списку
    public void delete(char data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }
        CharNode current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    // Пошук елемента за значенням
    public boolean contains(char data) {
        CharNode current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public char[] filterCharsLessThan(char target) {
        int resultSize = 0;
        CharNode current = head;
        while (current != null) {
            if (current.data < target) {
                resultSize++;
            }
            current = current.next;
        }
        char[] result = new char[resultSize];
        int index = 0;
        current = head;
        while (current != null) {
            if (current.data < target) {
                result[index] = current.data;
                index++;
            }
            current = current.next;
        }
        return result;
    }

    public char[] allElementsExceptA () {
        int resultSize = 0;
        CharNode current = head;
        while (current != null) {
            if (current.data != 'a') {
                resultSize++;
            }
            current = current.next;
        }
        char[] result = new char[resultSize];
        int index = 0;
        current = head;
        while (current != null) {
            if (current.data != 'a') {
                result[index] = current.data;
                index++;
            }
            current = current.next;
        }
        return result;
    }

    // Виведення списку на екран
    public void printList() {
        CharNode current = head;
        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.next;
        }
    }

    public int size() {
        return size;
    }
}
