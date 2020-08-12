package cron;

import org.junit.Test;
import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/6 16:35
 * </pre>
 */
public class CronTest {
    public static void main(String[] args) {
        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        try {
            cronTrigger.setCronExpression("0 5 10,16 ? * *");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Date> dates = TriggerUtils.computeFireTimes(cronTrigger, null, 20);

        dates.stream()
                .map(date -> String.format("%tF %tT", date, date))
                .forEach(System.out::println);
    }


    @Test
    public void test1() {
        String[] args = {"ADMIN,7", "USER,8"};

        Map<String, String> collect = Arrays.stream(args)
                .map(x -> x.split(","))
                .filter(x -> x.length == 2)
                .collect(Collectors.toMap(x -> x[0], x -> x[1]));

        System.out.println("collect = " + collect);

    }
}
