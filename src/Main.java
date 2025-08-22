
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "hello world qwerty world";
        int n = 2;

        List<String> result = findWordsByFrequency(str, n);

        if (result.isEmpty()) {
            System.out.println("Нет слов, встречающихся " + n + " раз(а)");
        } else {
            System.out.println("Слова, встречающиеся " + n + " раз(а): " + result);
        }
    }

    /**
     * Метод возвращает список слов, которые встречаются ровно n раз
     */
    public static List<String> findWordsByFrequency(String str, int n) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyList();
        }

        String[] words = str.split("\\s+"); // разбиваем строку по пробелам
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Подсчёт слов
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Фильтруем слова с частотой n
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == n) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
