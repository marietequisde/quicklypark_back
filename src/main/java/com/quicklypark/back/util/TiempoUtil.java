package com.quicklypark.back.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class TiempoUtil {

	public static Timestamp ahora() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
}
