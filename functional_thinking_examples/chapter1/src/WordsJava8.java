import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class WordsJava8 {
    private static Set<String> NON_WORDS = new HashSet<String>() {{
        add("the");
        add("and");
        add("of");
        add("to");
        add("a");
        add("i");
        add("it");
        add("in");
        add("or");
        add("is");
        add("d");
        add("s");
        add("as");
        add("so");
        add("but");
        add("be");
    }};

    // BEGIN java_wordfreq8
    private static List<String> regexToList(String words, String regex) {
        List wordList = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(words);
        while (m.find())
            wordList.add(m.group());
        return wordList;
    }

    public static Map wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        regexToList(words, "\\b[a-zA-Z]+\\b").stream()
                .map(w -> w.toLowerCase())
                .filter(w -> !NON_WORDS.contains(w))
                .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));
        return wordMap;
    }

    // 以某一个文本文件作为测试
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("resources\\pride-and-prejudice.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            long startTime = System.nanoTime();
            Map<String, Integer> map = wordFreq(sb.toString());
            long endTime = System.nanoTime();
            // 143.8ms
            System.out.println((endTime - startTime) / Math.pow(10, 6) + "ms");
        } catch (Exception ex) {

        }

    }
// END java_wordfreq8

}
