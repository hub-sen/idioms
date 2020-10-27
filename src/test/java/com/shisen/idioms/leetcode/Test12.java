package com.shisen.idioms.leetcode;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
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



















    private static int[]  res = {0};

    @Test
    public void add() {
        int sum = sum(3);
        System.out.println("sum = " + sum);
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

    }


}
