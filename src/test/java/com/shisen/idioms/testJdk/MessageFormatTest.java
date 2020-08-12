package com.shisen.idioms.testJdk;

import java.text.MessageFormat;
import java.util.Date;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/28 11:24
 * </pre>
 */
public class MessageFormatTest {
    public static void main(String[] args) {
        String message = "尊敬的{0}，您有一个{1}考核单{2}已审核，扣罚金额{3}元。查看详情请登录ctms.56pingtai.net，谢谢您的合作！";

        String messageContent = MessageFormat.format(message, "天地汇", "时效", "KHD123456", 100);
        System.out.println("messageContent = " + messageContent);

        int planet = 7;
        String event = "a disturbance in the Force";

        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
                planet, new Date(), event);

        System.out.println("result = " + result);

        String[] strs = {"DC", "CC", "EE"};

        System.out.println(String.join(",", strs));




    }



}
