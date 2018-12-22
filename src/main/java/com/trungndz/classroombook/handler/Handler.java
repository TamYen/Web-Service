package com.trungndz.classroombook.handler;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Handler {
	
	public Date parseStringToDateSql(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dateUtil;
		dateUtil = sdf.parse(date);
		Date dateSql = new Date(dateUtil.getTime());
		return dateSql;
	}

}
