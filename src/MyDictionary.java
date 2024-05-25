
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;
import  java.io.IOException;
import java.util.logging.Formatter;


public class MyDictionary {
        Map<String, String> engRus = new HashMap<String, String>();
    private static final Logger logger = Logger.getLogger(MyDictionary.class.getName());//создали логгер
    MyFormatter formatter = new MyFormatter();
    FileHandler fh ;
    public void Log(String info){//метод для передачи сообщений о том что происходит в программе

    try{
        fh = new FileHandler("MyLogFile.txt");//место сохранения логов
        logger.addHandler(fh);
        fh.setFormatter(formatter);//определили формат
        logger.setUseParentHandlers(false);// отключили вывод в консоль
        logger.log(Level.INFO,info);
}catch (SecurityException | IOException e) {
        logger.log(Level.SEVERE, "Произошла ошибка при работе с FileHandler.", e);
    }

}
    public void Add() {//метод добавления слов в словарь
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово по английски " + "\n");
        String key = in.nextLine();
        System.out.print("Введите перевод этого слова на русский язык  " + "\n");
        String value = in.nextLine();
        Log("Пользователь добавил новые слова в словарь");
        engRus.put(key, value);
        System.out.print("Слово успешно добавлено!");

    }
    public void Search(){//метод поиска слова по ключу
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово по английски чтобы узнать его перевод " + "\n");
        String key = in.nextLine();
        System.out.println(engRus.get(key));
        Log("Пользователь искал слово "+key);
    }

    public void Show(){
        Map<String, String>  sorted = new TreeMap<String, String>(engRus);
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        Log("Пользователь посмотрел содержимое всего словаря");
    }


    public void Run(){
        Log("Пользователь вошел в меню программы");
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
                    Log("Пользователь вышел из меню");
                    break;
                default:
                    break;
            }
        }
    }

}

