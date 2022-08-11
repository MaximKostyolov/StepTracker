public class Converter {

    public static void converter(int sum) { //конвенртируем шаги в километры и калории
        double distance = (sum * 0.75) / 1000;
        double calories = (sum * 50) / 1000;
        System.out.println("Пройденная дистаниция за месяц - " + distance + " км");
        System.out.println("Количество сожженых килокалорий за месяц - " + calories);
    }
}
