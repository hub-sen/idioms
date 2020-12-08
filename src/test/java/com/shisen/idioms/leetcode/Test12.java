package com.shisen.idioms.leetcode;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Description  整数转罗马数字
 * @author shishi
 * 2020/8/31 16:41
 * </pre>
 */
public class Test12 {

    @Test
    public void app() throws InterruptedException {
        LocalDateTime endDay = LocalDateTime.of(2020, 9, 30, 18, 30, 0);

        LocalDateTime now;
        Duration duration;
        do {
            now = LocalDateTime.now();
            duration = Duration.between(now, endDay);
            int secondsPart = duration.toSecondsPart();
            int minutesPart = duration.toMinutesPart();
            int hoursPart = duration.toHoursPart();
            long daysPart = duration.toDaysPart();

            System.out.println("距离 2020 年 9 月 19 日 30 时 30 分 00 秒, 还有: " + daysPart + " 天 " + hoursPart + " 时 " + minutesPart + " 分 " + secondsPart + " 秒");
            TimeUnit.SECONDS.sleep(1);

        } while (!duration.isNegative());

        System.out.println("下班! 下班! 下班!");

    }


    private static int[] res = {0};

    @Test
    public void add() {
        int sum = sum(3);
        System.out.println("sum = " + sum);
    }

    @Test
    public void test1221() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.MONTH, 2);
        instance.set(Calendar.DAY_OF_MONTH,31);


        Date date = instance.getTime();

        System.out.println("date = " + date);

        Date begin = DateUtil.beginOfMonth(date).toJdkDate();
        Date end = DateUtil.endOfMonth(date).toJdkDate();

        Date date1 = DateUtil.offsetMonth(date, -1).toJdkDate();
        System.out.println(date1);

        Date begin2 = DateUtil.beginOfMonth(date1).toJdkDate();
        Date end2 = DateUtil.endOfMonth(date1).toJdkDate();

        System.out.println("begin = " + begin);
        System.out.println("end = " + end);
        System.out.println("begin2 = " + begin2);
        System.out.println("end2 = " + end2);


    }


    public static Date getBeginTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = yearMonth.atDay(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static Date getEndTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }


    private int sum(int n) {
        try {
            return res[n];
        } catch (Exception e) {
            return n + sum(n - 1);
        }
    }


    @Test
    public void jsonTest() {
        //Object message = "{\"taskOrderNo\":\"GXC62459547709427\",\"orderId\":null,\"orderNo\":\"61042845899122\",\"business\":\"KH\",\"businessId\":\"10768\",\"driverId\":215286,\"taskOrderStatus\":\"A\",\"taskTransportStatus\":\"ST\",\"loadingTimes\":1,\"unloadingTimes\":1,\"shipperId\":209122,\"shipperName\":\"卡航3.0测试公司不要删\",\"shipperMobile\":\"15900000011\",\"departCode\":510600,\"departAddress\":\"衡水市阜城县阜城县政府\",\"arriveCode\":610600,\"arriveAddress\":\"上海市闵行区虹桥总部1号\",\"goodsName\":\"sunny家吊瓜\",\"goodsWeight\":0.004,\"goodsVolume\":5.00,\"remark\":null,\"planDepartTime\":1599708495000,\"planArriveTime\":1599751695000,\"basePrice\":null,\"totalPrice\":null,\"trailerPlate\":\"黑A0010挂\",\"truckPlate\":\"沪B00005\",\"createTime\":null,\"updateTime\":1599720451000,\"updateBy\":209418,\"driverMobile\":\"15111509003\",\"driverName\":\"桂四四\",\"departLng\":116.18219000,\"departLat\":37.86900300,\"arriveLng\":121.38832400,\"arriveLat\":31.18589900,\"mileage\":null,\"estimateMileage\":1043.3,\"operatorId\":null,\"operator\":null,\"scheduleType\":\"PLATFORM\"}";

        String message = "[{\"deliverEnded\":false,\"city\":null,\"latitude\":null,\"stateType\":0,\"innerDesc\":null,\"customerDelivery\":false,\"startTime\":\"2020-09-24 11:14:32\",\"abnormalItemType\":null,\"subjectId\":55374,\"finFlag\":null,\"cityCt\":null,\"newTrailerPlateNo\":null,\"locationId\":null,\"trafficJamState\":null,\"departId\":10783,\"newTruckPlateNo\":null,\"startTime\":null,\"longitude\":null,\"exterDesc\":null,\"subjectName\":\"大李子-会员名称\",\"departNo\":null,\"comments\":null,\"address\":null,\"abnormalType\":null,\"operaInfo\":null,\"operaIp\":null,\"navigationDataDto\":null,\"profileId\":209427,\"stateCd\":\"INVA\",\"sourceProdCd\":\"SG3-WEB\",\"endTime\":null}]";

        Object parse = JSONArray.parse(message);
        List<DepartOrderStateUpdateDto> arrayLists = JSONArray.parseArray(message, DepartOrderStateUpdateDto.class);

        System.out.println("parse = " + parse);

        // 零散
        ArrayList<PreferentialRange> ls = new ArrayList<>();

        PreferentialRange preferentialRange2 = new PreferentialRange(2, 3, BigDecimal.valueOf(80), 1,"多发多送优惠券",30);
        PreferentialRange preferentialRange3 = new PreferentialRange(3, 4, BigDecimal.valueOf(100), 1,"多发多送优惠券",30);
        PreferentialRange preferentialRange5 = new PreferentialRange(5, 6, BigDecimal.valueOf(200), 1,"多发多送优惠券",30);
        PreferentialRange preferentialRange10 = new PreferentialRange(10, 11, BigDecimal.valueOf(600), 1,"多发多送优惠券",30);
        PreferentialRange preferentialRange20 = new PreferentialRange(20, 21, BigDecimal.valueOf(1000), 1,"多发多送优惠券",30);
        ls.add(preferentialRange2);
        ls.add(preferentialRange3);
        ls.add(preferentialRange5);
        ls.add(preferentialRange10);
        ls.add(preferentialRange20);


        // 常发

        ArrayList<PreferentialRange> cf = new ArrayList<>();

        PreferentialRange cf10 = new PreferentialRange(10, 11, BigDecimal.valueOf(600), 1,"多发多送优惠券",30);
        PreferentialRange cf20 = new PreferentialRange(20, 21, BigDecimal.valueOf(1000), 1,"多发多送优惠券",30);
        cf.add(cf10);
        cf.add(cf20);


        HashMap<String, List<PreferentialRange>> stringPreferentialRangeHashMap = new HashMap<>();

        stringPreferentialRangeHashMap.put("LS", ls);
        stringPreferentialRangeHashMap.put("CF", cf);

        String s1 = JSONArray.toJSONString(stringPreferentialRangeHashMap);
        System.out.println("s1 = " + s1);


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HashMap<String, List<PreferentialRange>> preferentialRangeMap = objectMapper.readValue(s1, new TypeReference<>() {
            });
            System.out.println("preferentialRangeMap = " + preferentialRangeMap);


            // 已完成的订单数量
            int count = 100;
            String memberType = "CF";


            PreferentialRange preferentialRange = preferentialRangeMap.get(memberType)
                    .stream()
                    .filter(x -> x.inRange(count))
                    .findFirst()
                    .orElse(null);


            if (Objects.isNull(preferentialRange)) {
                System.out.println("未找到对应的优惠活动");
            } else {
                System.out.println("优惠价格 = " + preferentialRange.getPreferentialPrice());
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testReverseList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = listNode1;

        while (null != listNode) {
            System.out.println("listNode = " + listNode);
            listNode = listNode.next;
        }

/*
        ListNode reverseNode = reverseNode(listNode1);

        while (null != reverseNode) {
            System.out.println("reverseNode = " + reverseNode);
            reverseNode = reverseNode.next;
        }*/

        ListNode reverseNode2 = reverseNode_2(listNode1);

        while (null != reverseNode2) {
            System.out.println("reverseNode2 = " + reverseNode2);
            reverseNode2 = reverseNode2.next;
        }

    }

    private ListNode reverseNode(ListNode listNode){
        if (null == listNode || null == listNode.next) {
            return listNode;
        }

        ListNode newListNode = reverseNode(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;

        return newListNode;
    }

    private ListNode reverseNode_2(ListNode listNode) {
        ListNode preNode = null;
        ListNode cur = listNode;

        while (null != cur) {
            ListNode next = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = next;
        }

        return preNode;
    }


}
