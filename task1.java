import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task1 {
    private static Object phone;

    public static void main(String[] args) {
        Map<String, List<String>> book = new HashMap<>();
        book.put("Olga", List.of("8 981 142 25 24"));
        book.put("Sistr", List.of("8 921 165 22 23", "8 964 326 58 95"));
        book.put("Ivan", List.of("8 981 143 27 23", "8 812 576 25 56"));

        menu(book);
    }

    public static String scan() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static void search(Map<String, List<String>> phoneBook) {
        System.out.print("3 Найти контакт. Введите имя:");
        String name = scan();
        System.out.print("Имя: " + name + " Телефон: " + phoneBook.get(name));

    }

    public static Map<String, List<String>> add(Map<String, List<String>> book) {
        System.out.print("1 Добавить контакт. Введите имя абонента: ");
        String name = scan();
        List<String> phone = new ArrayList<>();
        while (true) {
            System.out.print("Введите номер: ");
            String nomer = scan();
            phone.add(nomer);
            System.out.print("Для добавления номера нажмите + ");
            String nomer2 = scan();
            if (nomer2.equals("+")) {
                phone.add(nomer);
            } else {
                break;
            }
        }
        book.put(name, phone);
        return book;

    }

    public static void del(Map<String, List<String>> phoneBook) {
        System.out.print("4 Удалить контакт. Введите имя:");
        String name = scan();
        phoneBook.remove(name);
        System.out.print("Контакт удален");

    }

    public static Map<String, List<String>> rem(Map<String, List<String>> books) {
        System.out.print("2 Изменить контакт. Введите имя:");
        String name = scan();
        books.remove(name);
        List<String> phonenumber = new ArrayList<>();
        while (true) {
            System.out.print("Введите номер: ");
            String nomer = scan();
            phonenumber.add(nomer);
            System.out.print("Для добавления номера нажмите + ");
            String nomer2 = scan();
            if (nomer2.equals("+")) {
                phonenumber.add(nomer);
            } else {
                break;
            }
        }
        books.put(name, phonenumber);
        return books;
    }

    public static void allBook(Map<String, List<String>> AllBook)

    {
        for (var item : AllBook.entrySet()) {
            System.out.println("Имя: " + item.getKey() + "\nНомер" + item.getValue());
        }
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> book) {
        // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
        // человек может иметь несколько телефонов.
        while (true) {
            System.out.println("\n-------------------------\n Телефонный справочник \n-------------------------");
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить контакт");
            System.out.println("2 - Отредактировать контакт");
            System.out.println("3 - Найти контакт");
            System.out.println("4 - Удалить");
            System.out.println("5 - Вывести весь список контактов");
            System.out.println("6 - Выход");
            String comands = scan();
            if (comands.equals("6")) {
                break;
            } else {
                switch (comands) {
                    case "1":
                        add(book);
                        break;
                    case "2":
                        rem(book);
                        break;
                    case "3":
                        search(book);
                        ;
                        break;
                    case "4":
                        del(book);
                        break;
                    case "5":
                        allBook(book);
                        break;

                }

            }
        }
        return book;
    }
}