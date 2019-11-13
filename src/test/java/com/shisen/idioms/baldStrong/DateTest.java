package com.shisen.idioms.baldStrong;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;

/**
 * <pre>
 * Description  LocalDate,LocalTime.Instant,Duration,以及Period
 * </pre>
 */
public class DateTest {

	@Test
	public void test1() {
		LocalDate now = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("CTT")));

		System.out.println("now = " + now);
		System.out.println("年份: " + now.getYear());
		System.out.println("月份(单词): " + now.getMonth());
		System.out.println("月份(数字): " + now.getMonthValue());
		System.out.println("号: " + now.getDayOfMonth());
		System.out.println("now.lengthOfMonth() = " + now.lengthOfMonth());
		System.out.println("now.lengthOfYear() = " + now.lengthOfYear());
		System.out.println("now.getDayOfWeek() = " + now.getDayOfWeek());
		System.out.println("now.getDayOfWeek().getValue() = " + now.getDayOfWeek().getValue());
		System.out.println("now.isLeapYear() = " + now.isLeapYear());
		System.out.println("now.getDayOfYear() = " + now.getDayOfYear());

		LocalDate date = LocalDate.of(2019, 6, 17);
		System.out.println("now.isAfter(date) = " + now.isAfter(date));
		System.out.println("now.isBefore(date) = " + now.isBefore(date));
		System.out.println("now.isEqual(date) = " + now.isEqual(date));

		LocalDate date1 = now.plusDays(20);
		System.out.println("date1 = " + date1);

	}

	@Test
	public void test2() {
		LocalDateTime commit = LocalDateTime.of(2012, 6, 18, 0, 0, 0);
		LocalDateTime now = LocalDateTime.of(2019, 6, 20, 0, 59, 59);

		Duration duration = Duration.between(commit, now);
		Period period = Period.between(commit.toLocalDate(), now.toLocalDate());

		int years = period.getYears();
		int days = period.getDays();
		int hoursPart = duration.toHoursPart();
		int minutesPart = duration.toMinutesPart();
		int secondsPart = duration.toSecondsPart();

		StringBuilder result = new StringBuilder();
		if (0 != years) {
			result.append(years).append("年");
		}
		if (0 != days) {
			result.append(days).append("天");
		}
		if (0 != hoursPart) {
			result.append(hoursPart).append("小时");
		}
		if (0 != minutesPart) {
			result.append(minutesPart).append("分钟");
		}
		if (0 != secondsPart) {
			result.append(secondsPart).append("秒");
		}
		System.out.println("result = " + result);
	}

	@Test
	public void test3() {
		LocalDate now = LocalDate.of(2019, 6, 18);
		LocalDate before = LocalDate.of(2019, 6, 1);

		// Duration between = Duration.between(before, now);

		Period period = Period.between(before, now);
		System.out.println("period = " + period.getDays());
		System.out.println("period = " + period.getMonths());
	}

}
