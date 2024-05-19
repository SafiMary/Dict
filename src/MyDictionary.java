
import java.util.*;

public class MyDictionary {
    Map<String, String> engRus = new HashMap<String, String>();

    public void Add() {//метод добавления слов в словарь
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово по английски " + "\n");
        String key = in.nextLine();
        System.out.print("Введите перевод этого слова на русский язык  " + "\n");
        String value = in.nextLine();
        engRus.put(key, value);
        System.out.print("Слово успешно добавлено!");
    }
    public void Search(){//метод поиска слова по ключу
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово по английски чтобы узнать его перевод " + "\n");
        String key = in.nextLine();
        System.out.println(engRus.get(key));
    }

    public void Show(){
        Map<String, String>  sorted = new TreeMap<String, String>(engRus);
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }


    public void Run(){
        Scanner in = new Scanner(System.in);
        System.out.print("Для добавления слова в словарь наберите 1"+"\n"+ "Для поиска слова наберите 2 "+"\n"+
                "Для вывода отсортированного словаря наберите 3"+"\n"+ "Для выхода из меню наберите &"+"\n");
        boolean cheaker = true;
        while (cheaker) {
            String str = in.nextLine();
            switch (str) {
                case "1":
                    Add();
                    break;
                case "2":
                    Search();
                    break;
                case "3":
                    Show();
                    break;
                case "&":
                    cheaker = false; // выход из меню
                    System.out.println("Вы вышли из меню");
                    break;
                default:
                    break;
            }
        }
    }

}
