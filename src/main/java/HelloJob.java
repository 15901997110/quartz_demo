import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/4 10:28
 */
public class HelloJob implements Job {
    public HelloJob() {
        System.out.println("job实例无参构造函数执行...");
        System.out.println(this.hashCode());
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(LocalDateTime.now()));
        Object message = context.getJobDetail().getJobDataMap().getString("message");
        System.out.println("传递的message:" + message);
        System.out.println("-------------------------------------");
    }
}
