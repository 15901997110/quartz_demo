import org.apache.commons.lang3.time.DateUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/12/4 10:47
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        //创建一个JobDetail,绑定一个Job(JobDetail能够扩展很多Job的属性)
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("jobName", "jobGroup")
                .usingJobData("message", "我是JobDetail中传过来的")
                .build();

        //创建一个Trigger实例,定义该Job立即执行,并且每隔2秒执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger1", "triggerGroup1")
                .startNow()
//                .withSchedule(cronScheduleBuilder)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(2))
                .build();
        //创建Scheduler实例
        SchedulerFactory sFactory = new StdSchedulerFactory();
        Scheduler scheduler = sFactory.getScheduler();
        Date date = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println(dateFormat.format(date));
        scheduler.start();
    }
}
