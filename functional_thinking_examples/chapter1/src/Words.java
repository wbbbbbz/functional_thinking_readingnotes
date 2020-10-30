import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// BEGIN java_word_freq
public class Words {
    // 定义虚词
    private static Set<String> NON_WORDS = new HashSet<String>() {
        {
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
        }
    };

    // 未经过优化。有一部分词语无法划分，比如youwould作为一个单词
    public static Map wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
        Matcher m = Pattern.compile("\\b[a-zA-Z]+\\b").matcher(words);
        while (m.find()) {
            String word = m.group().toLowerCase();
            if (!NON_WORDS.contains(word)) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordMap;
    }

    // 以某一个文本文件作为测试
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("resources\\pride-and-prejudice.txt"))){
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            long startTime = System.nanoTime();
            Map<String, Integer> map = wordFreq(sb.toString());
            long endTime = System.nanoTime();
            // 136.3ms
            System.out.println((endTime - startTime) / Math.pow(10, 6) + "ms");
            System.out.println(map);
        } catch (Exception ex){

        }
        
    }
}
// END java_word_freq
