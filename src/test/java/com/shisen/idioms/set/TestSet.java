package com.shisen.idioms.set;

import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/3/11 9:59
 * </pre>
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> plateNos = new HashSet<>();

        String str1 = new String("津C30362");
        String str2 = new String("津C30362");
        String str3 = new String("津C30362");

        plateNos.add(str1);
        plateNos.add(str2);
        plateNos.add(str3);

        System.out.println("plateNos = " + plateNos);
        System.out.println("StringUtils.join(plateNos) = " + StringUtils.join(plateNos));
    }

    @Test
    public void testTime() {
        String timeRegex = "([0-1]?[0-9]|2[0-3]):(0?[0-9]|[1-5][0-9]):(0?[0-9]|[1-5][0-9])";

        String dateRegex = "(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)";

        String dateTimeRegex = dateRegex +"\\s+"+ timeRegex;

        String time = "3:59:59";
        boolean timeMatches = time.matches(timeRegex);
        System.out.println("timeMatches = " + timeMatches);

        String date = "2020-2-29";
        boolean dateMatches = date.matches(dateRegex);
        System.out.println("dateMatches = " + dateMatches);

        String dateTime = "2020-13a-30 3:59:60";
        boolean dateTimeMatches = dateTime.matches(dateTimeRegex);
        System.out.println("dateTimeMatches = " + dateTimeMatches);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("parse = " + parse);


    }
}
