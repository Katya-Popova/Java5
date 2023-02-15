import java.util.HashMap;
import java.util.Map;

//Записать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности Имени.
public class task2 {

    public static void main(String[] args) {
        Map<String, Integer> listWorkers = new HashMap<>();
        String workers = "Иван Иванов Светлана Петрова Кристина Белова Анна Мусина Анна Крутова " +
                "Иван Юрин Петр Лыков Павел Чернов Петр Чернышов Мария Федорова " +
                "Марина Светлова Мария Савина Мария Рыкова Марина Лугова " +
                "Анна Владимирова Иван Мечников Петр Петин Иван Ежов ";

        String[] nameStrings = workers.split(" ");
        for (int i = 0; i < nameStrings.length; i += 2) {
            if (listWorkers.containsKey(nameStrings[i])) {
                listWorkers.replace(nameStrings[i], listWorkers.get(nameStrings[i]) + 1);
            } else {
                listWorkers.put(nameStrings[i], 1);
            }
        }
        System.out.println("\nСписок имен:" + "\n" + listWorkers);

        System.out.println("\nСписок имен по популярности:");
        listWorkers.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

}