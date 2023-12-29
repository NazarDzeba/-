import java.util.Scanner;

public class BracketValidator {
    public static boolean isStringValid(String input) {
        CustomStack stack = new CustomStack(input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false; // Немає відповідної відкриваючої дужки
                }
                char opening = stack.pop();
                if ((c == ')' && opening != '(') || (c == ']' && opening != '[') || (c == '}' && opening != '{')) {
                    return false; // Дужки не відповідають одна одній
                }
            }
        }

        return stack.isEmpty(); // Якщо стек порожній, то всі дужки відповідають одна одній
    }

    public static void main(String[] args) {
        System.out.println("Виконання завдання 1:");
        System.out.print("Введіть рядок тексту, в тому числі дужки '(, ), [, ], {, }': ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Чи є рядок коректним? " + isStringValid(scanner.nextLine()));

        System.out.println("\n\nВиконання завдання 2:");
        CustomQueue customQueue1 = new CustomQueue(5);
        CustomQueue customQueue2 = new CustomQueue(5);

        customQueue1.enqueue(1);
        customQueue1.enqueue(2);
        customQueue1.enqueue(5);

        customQueue2.enqueue(3);
        customQueue2.enqueue(4);

        CustomQueue mergedQueue = mergeQueues(customQueue1, customQueue2);

        while (!mergedQueue.isEmpty()) {
            System.out.print(mergedQueue.dequeue() + " ");
        }

        System.out.println("\n\nВиконання завдання 3:");
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);

        System.out.print("Введіть значення х: ");
        int input = scanner.nextInt();
        int occurrences = countOccurrences(root, input);
        System.out.println("Число входжень " + input + " в бінарне дерево: " + occurrences);
    }

    public static CustomQueue mergeQueues(CustomQueue queue1, CustomQueue queue2) {
        CustomQueue mergedQueue = new CustomQueue(queue1.size() + queue2.size());

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int element1 = queue1.dequeue();
            int element2 = queue2.dequeue();

            // Додаємо менший елемент до mergedQueue
            if (element1 < element2) {
                mergedQueue.enqueue(element1);
                // Повертаємо більший елемент назад до відповідної черги
                queue2.enqueue(element2);
            } else {
                mergedQueue.enqueue(element2);
                // Повертаємо більший елемент назад до відповідної черги
                queue1.enqueue(element1);
            }
        }

        while (!queue1.isEmpty()) {
            mergedQueue.enqueue(queue1.dequeue());
        }

        while (!queue2.isEmpty()) {
            mergedQueue.enqueue(queue2.dequeue());
        }

        return mergedQueue;
    }

    public static int countOccurrences(TreeNode root, int x) {
        if (root == null) {
            return 0; // Бінарне дерево порожнє, немає входжень
        }

        int count = 0;

        // Перевіряємо поточний вузол
        if (root.value == x) {
            count++;
        }

        // Рекурсивно перевіряємо ліве та праве піддерево
        count += countOccurrences(root.left, x);
        count += countOccurrences(root.right, x);

        return count;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class CustomStack {
    private final char[] stackArray;
    private int top;

    public CustomStack(int capacity) {
        stackArray = new char[capacity];
        top = -1;
    }

    public void push(char c) {
        if (top < stackArray.length - 1) {
            stackArray[++top] = c;
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }
        return '\0'; // Якщо стек порожній, повертаємо нульовий символ
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class CustomQueue {
    private final int[] queue;
    private int front;
    private int rear;
    private int size;

    public CustomQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Черга переповнена");
            return;
        }
        rear = (rear + 1 == queue.length) ? 0 : rear + 1;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Черга пуста");
            return -1;
        }
        int item = queue[front];
        if (front + 1 == queue.length) {
    		   front = 0;
        } else {
    		   front++;
        }    
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int size() {
        return size;
    }
}
