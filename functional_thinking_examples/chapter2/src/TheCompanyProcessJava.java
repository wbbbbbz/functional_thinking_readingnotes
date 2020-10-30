import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheCompanyProcessJava {

    // 假设我们有一个名字列表，其中一些条目由单个字符构成。
    // 现在的任务是，将除去单字符条目之外的列表内容，放在一个逗号分隔的字符串里返回，且每个名字的首字母都要大写。
    public static String cleanNames(List<String> listOfNames) {
        StringBuilder sb = new StringBuilder();
        // 命令式编程鼓励程序员将操作安排在循环内部去执行。
        // 本例中做了三件事：filter，筛选列表，去除单字符条目；
        // transform，变换列表，使名字的首字母变成大写；
        // 接着是convert，转换列表，得到单个字符串。
        // 这三种操作可以说是我们在列表上施展的“三板斧”。
        // 在命令式语言里，这三种操作都必须依赖于相同的低层次机制（对列表进行迭代）。
        // 而函数式语言为这些操作提供了针对性的辅助手段。
        for (String str : listOfNames) {
            if (str.length() > 1){
                sb.append((char)(str.charAt(0) + ('A' - 'a')));
                sb.append(str.substring(1));
                sb.append(",");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String cleanNamesLambda(List<String> listOfNames){
        return listOfNames.stream().filter(s -> s.length() > 1)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                // .collect(Collectors.joining(","));
                .reduce((a, b) -> a + "," + b).get();
    }


    public static void main(String[] args) {
        List<String> employees = Arrays.asList("neal", "s", "stu", "j", "rich", "bob", "aiden", "j", "ethan",
                "liam", "mason", "noah", "lucas", "jacob", "jayden", "jack");

        System.out.println(cleanNames(employees));
        System.out.println(cleanNamesLambda(employees));
        System.out.println(cleanNames(employees).equals(cleanNamesLambda(employees)));
    }
}
