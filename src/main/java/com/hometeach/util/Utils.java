package com.hometeach.util;

import com.hometeach.dto.BaseUser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
/*
    工具类
 */
public class Utils {

    public static final String EQUAL_SQL = " %s = %s ";
    public static final String AND_SQL = " and %s ";
    public static final String AND = " and ";
    public static final String OR = " or ";
    public static final String[] WEEKS = new String[]{"Sun", "Mon", "Tue","Wed", "Thu", "Fri", "Sat"};
    public static final String LIKE = "'%s%s'";

    // 字符串连接
    public static String join(String[] array, String joinChar){
        /*if(array == null || array.length == 0) return "";
        StringBuilder builder = new StringBuilder();
        for(int index = 0; index < array.length - 1; index++){
            builder.append(array[index]).append(joinChar);
        }
        return builder.append(array[array.length - 1]).toString();*/
        return StringUtils.join(array, joinChar);
    }

    public static String join(List<String>list, String joinChar){
        String[] array = new String[list.size()];
        array = list.toArray(array);
        return join(array, joinChar);
    }

    // 对前端传入的值进行处理，判断是否需要加引号
    public static String fillColumn(String column){
        return column.length() > 0 && StringUtils.isNumeric(column) ? column : String.format("'%s'", column);
    }

    // Excel处理
    public static String convertCell2StringValue(Cell cell){
        switch(cell.getCellTypeEnum()) {
            case NUMERIC: return String.valueOf(cell.getNumericCellValue());
            case STRING:  return cell.getStringCellValue();
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA: return String.valueOf(cell.getCellFormula());
            case BLANK: return "";
            case ERROR: return "error";
            default: return "undefined";
        }
    }

    // 对象通用比较方法
    public static <U,V>  boolean isEquals(U u, V v){
        if(u == null || v == null) return u == v ? true : false;
        return u.equals(v);
    }

    // 对象通用哈希方法
    public static <T> int hash(T t){
        return t == null ? 0 : t.hashCode();
    }

    // 写文件
    public static void writeByteArrayToFile(String fileName, byte[] data){
        try{
            File file = new File(fileName);
            FileUtils.writeByteArrayToFile(file, data);
        }catch(IOException e){
            throw new RuntimeException(e.getCause());
        }
    }
    
    public static String date2WeekString(Date date){
    	Calendar cl = Calendar.getInstance();
    	cl.setTime(date);
    	int index = cl.get(Calendar.DAY_OF_WEEK) - 1;
    	return String.format(LIKE, WEEKS[index], "%");
    }
    
    public static String getCurrentWeekDay(){
    	return date2WeekString(new Date());
    }
    
    public static String dateString2Week(String dateString){
    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	try{
    		Date date = format.parse(dateString);
    		return date2WeekString(date);
    	}catch(Exception e){
    		throw new RuntimeException("Time format is error", e);
    	}
    }
    
    public static String date2String(Date date, String formatString){
    	DateFormat format = new SimpleDateFormat(formatString == null ? "yyyy-MM-dd" : formatString);
    	return format.format(date);
    }

    public static String getJoinClassName(int classId){
    	return String.format("PB%s%04d", date2String(new Date(),"yyyy"), classId);
    }
    
    public static String emoji2Utf8(String emoji){
    	try{
    		return URLEncoder.encode(emoji, "utf-8");
    	}catch(UnsupportedEncodingException e){
    		e.printStackTrace();
    		return "";
    	}
    }
    
    public static String utf2Emoji(String utf8){
    	try {
			return URLDecoder.decode(utf8, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
    }
    
    public static BaseUser refreshNickName(BaseUser baseUser){
    	baseUser.setNickName(emoji2Utf8(baseUser.getNickName()));
    	return baseUser;
    }
    
    public static List<LinkedHashMap> refreshNickName(List<LinkedHashMap> list){
    	try{
    		for(LinkedHashMap map : list){
    			map.put("nickName", utf2Emoji(map.get("nickName").toString()));
    		}
    			
    	}catch(Exception e){
    		
    	}
    	return list;
    }
    
    
    public static Calendar getCalendarByString(SimpleDateFormat df, String dateString){
    	try {
			Calendar calendar = Calendar.getInstance();
			Date date = df.parse(dateString);
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
    }
    
    public static String getAnyDayInMonth(SimpleDateFormat df, String dateString, int day){
		Calendar calendar = getCalendarByString(df, dateString);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.add(Calendar.MONTH, 0);
		return df.format(calendar.getTime());

    }
    
    public static String getFirstDayByDateInMonth(String dateString){
    	return getAnyDayInMonth(new SimpleDateFormat("yyyy-MM-dd"), dateString, 1);
    }
    
    public static String getLastDayByDateInMonth(String dateString){
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar calendar = getCalendarByString(sf, dateString);
    	int lastDay = calendar.getActualMaximum(Calendar.DATE);
    	return getAnyDayInMonth(sf, dateString, lastDay);
    }
    
    public static String todayString() {  
        Date currentTime = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        String dateString = formatter.format(currentTime);  
        return dateString;  
    }  

}
