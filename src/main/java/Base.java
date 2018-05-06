import java.io.File;
import java.util.*;

public class Base {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("src/main/java/Phrase.txt"));
        Map<String, Integer> statistics = new TreeMap<>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+").next();
            Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);
        }

        System.out.println("Слова и количество их повторений: ");
        statistics.forEach((a1, a2) -> System.out.println(a1 + " = " + a2));

        String wordMax = null;
        Integer quantityMax = null;

        for (Map.Entry<String, Integer> pair : statistics.entrySet()) {
            if (wordMax == null) {
                wordMax = pair.getKey();
                quantityMax = statistics.get(wordMax);
            }
            String key = pair.getKey();
            Integer value = pair.getValue();

            if (value > quantityMax) {
                wordMax = key;
                quantityMax = value;
            }
        }
        System.out.println();
        System.out.println("Слово " + '"' + wordMax +'"' + " использовалось " + quantityMax + " раз");

    }
    }

