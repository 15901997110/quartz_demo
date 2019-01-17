import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/4 10:22
 */
public class App {
    public static void main(String[] args) {
        System.out.println("hello world!");
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(LocalDateTime.now()));
    }
}
