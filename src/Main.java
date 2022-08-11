import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] statSteps = new int[12][30];
        int goal = 10000;

        printMenu();
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        processInput(userInput, statSteps, goal);
    }

    public static void printMenu() { // печать меню
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }

    public static void processInput(int userInput, int[][] statSteps, int goal) {
        while (userInput != 0) { // обработка разных случаев
            if (userInput == 1) {
                StepTracker.inputSteps(statSteps);
            } else if (userInput == 2) {
                StepTracker.printStats(statSteps, goal);
            } else if (userInput == 3) {
                goal = StepTracker.changeGoal();
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }
}
