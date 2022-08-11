import java.util.Scanner;
public class StepTracker {
    public static void inputSteps(int[][] statSteps) {
        System.out.println("Введите номер месяца, начиная с 0");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        if ((month >= 0) & (month < 12)) {
            System.out.println("Введите дату месяца");
            int data = scanner.nextInt();
            if ((data >= 1) & (data <= 30)) {
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                if (steps > 0) {
                    statSteps[month][(data - 1)] = steps;
                    System.out.println("Ваше значение введено");
                } else {
                    System.out.println("Введено некорректное значение шагов");
                }
            } else {
                System.out.println("Введена некорректная дата");
            }
        } else {
            System.out.println("Введено некорректное значение месяца");
        }
    }

    public static void printStats(int[][] statSteps, int goal) { //выводим статистику за месяц
        System.out.println("Введите номер месяца, начиная с 0, за который хотите получить статистику");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        if ((month >= 0) & (month < 12)) {
            for (int i = 0; i <= 29; i++) {
                System.out.println((i + 1) + " день: " + statSteps[month][i]);
            }
        } else {
            System.out.println("Вы ввели некорректное значение месяца");
        }
        System.out.println("Общее количество шагов за месяц - " + sumStep(month, statSteps));
        findMaxSteps(month, statSteps);
        findAverageSteps(sumStep(month, statSteps));
        Converter.converter(sumStep(month, statSteps));
        findBestSeries(month, goal, statSteps);
    }

    public static int changeGoal() { //вводим новую цель
        System.out.println("Введите новую цель шагов за день");
        Scanner scanner = new Scanner(System.in);
        int newGoal = scanner.nextInt();
        if (newGoal > 0) {
            System.out.println("Новая цель - " + newGoal + " шагов");
        } else {
            System.out.println("Вы ввели некорректное значение");
        }
        return newGoal;
    }

    public static int sumStep(int month, int[][] statSteps) { //считаем общее количество шагов за месяц
        int sum = 0;
        for (int i = 0; i <= 29; i++) {
            sum = sum + statSteps[month][i];
        }
        return sum;
    }

    public static void findMaxSteps(int month, int[][] statSteps) { //находим максимальное число шагов за месяц
        int maxSteps = 0;
        for (int i = 0; i <= 29; i++) {
            if (statSteps[month][i] > maxSteps) {
                maxSteps = statSteps[month][i];
            }
        }
        System.out.println("Максимальное количество шагов - " + maxSteps);
    }

    public static void findAverageSteps(int sum) { //находим среднее количество шагов за месяц
        double averageSteps = sum / 30;
        System.out.println("Среднее количество шагов - " + averageSteps);
    }

    public static void findBestSeries(int month, int goal, int[][] statSteps) { //находим лучшую серию
        int[] series = new int[30];
        int count = 0;
        for (int i = 0; i <= 29; i++) { //находим серии и записываем их длинны в массив
            if (statSteps[month][i] >= goal) {
                count = count + 1;
                series[i] = count;
            } else {
                count = 0;
                series[i] = 0;
            }
        }
        int maxSeries = 0;
        for (int i = 0; i <= 29; i++) { //находим максимальную серию
            if (series[i] > maxSeries) {
                maxSeries = series[i];
            }
        }
        System.out.println("Максимальная серия дней, в течение которых количество шагов за день было равно или выше целевого, составляет - " + maxSeries);
    }

}
