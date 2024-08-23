package com.bannershallmark.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;

public class StringToDateConverter {
	public static Date StringToDate(String dateString) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// Parse the String to a java.util.Date
		java.util.Date utilDate = dateFormat.parse(dateString);

		// Convert java.util.Date to java.sql.Date
		java.sql.Date sqlDate = new Date(utilDate.getTime());
		return sqlDate;
	}

	public static Date StartDate(String StartDate) {

		// Parse start date
		YearMonth startYearMonth = YearMonth.parse(StartDate);
		LocalDate startDate = startYearMonth.atDay(1);
		return Date.valueOf(startDate);
	}

	public static Date EndDate(String endDateStr) {
		// Parse end date
		YearMonth endYearMonth = YearMonth.parse(endDateStr);
		LocalDate endDate = endYearMonth.atEndOfMonth();
		return Date.valueOf(endDate);

	}
}
