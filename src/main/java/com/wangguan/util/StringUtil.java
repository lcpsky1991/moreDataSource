package com.wangguan.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

/**
 * 字符串处理工具类
 * 
 * @author zhangtb
 * @date 2016-7-2 15:17:14
 * @since 1.0.0
 */
public class StringUtil {

	public static boolean isBlank(String s) {
		if (s == null || "".equals(s.trim())) {
			return true;
		}
		return false;
	}

	public static String loop(String s, int count, String split) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < count; i++) {
			sb.append(s);
			int last_index = count - 1;
			if (i < last_index) {
				sb.append(split);
			}
		}
		return sb.toString();
	}

	public static String listToString(List<String> list, String split) {
		StringBuffer sb = new StringBuffer();
		if (list != null) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				String s = list.get(i);
				sb.append(s);
				int last_index = size - 1;
				if (i < last_index) {
					sb.append(split);
				}
			}
		}
		return sb.toString();
	}

	public static List<String> stringToList(String s, String split) {
		if (s == null || s.trim().equals("")) {
			return new ArrayList<String>();
		} else {

			String[] arr = s.split(split);
			List<String> list = Arrays.asList(arr);
			return list;
		}
	}

	public static List<Integer> stringToIntList(String s, String split) {
		if (s == null || s.trim().equals("")) {
			return new ArrayList<Integer>();
		} else {

			String[] arr = s.split(split);
			List<Integer> list = new ArrayList<Integer>();
			for (String str : arr) {
				int t = toInt(str);
				list.add(t);
			}
			return list;
		}
	}

	public static String toString(Object obj) {
		if (obj != null && !obj.toString().trim().equals("")) {
			return obj.toString();
		} else {
			return "";
		}
	}

	public static String toString(Object obj, String init) {
		if (obj != null && !obj.toString().trim().equals("")) {
			return obj.toString();
		} else {
			return init;
		}
	}

	public static int toInt(Object obj) {
		if (obj == null) {
			return 0;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("\\d+")) {
				return Integer.parseInt(s);
			}
		}
		return 0;
	}

	public static int toInt(Object obj, int i) {
		if (obj == null) {
			return i;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("-?\\d+")) {
				return Integer.parseInt(s);
			}
		}
		return i;
	}

	public static long toLong(Object obj, long i) {
		if (obj == null) {
			return i;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("\\d+")) {
				return Long.parseLong(s);
			}
		}
		return i;
	}

	public static float toFloat(Object obj) {
		if (obj == null) {
			return 0.0f;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("\\d+(\\.\\d+)?")) {
				return Float.parseFloat(s);
			}
		}
		return 0.0f;
	}

	/**
	 * @param list
	 * @param word
	 * @param show_count
	 * @return
	 */
	public static List<String> like(List<String> list, String word, int show_count) {
		List<String> result = new ArrayList<String>();
		for (String s : list) {
			if (result.size() > (show_count - 1)) {
				break;
			}
			if (s.indexOf(word) > -1) {
				result.add(s);
			}
		}
		return result;
	}

	public static Map<String, String> likePair(Map<String, String> map, String word, int show_count) {
		Map<String, String> result = new HashMap<String, String>();

		for (Entry<String, String> entry : map.entrySet()) {
			String k = entry.getKey();
			String v = entry.getValue();
			if (result.size() > (show_count - 1)) {
				break;
			}
			if (v.indexOf(word) > -1) {
				result.put(k, v);
			}
		}
		//		Set<String> keys = map.keySet();
		//		for (String s : keys) {
		//			if (result.size()>(show_count-1)) {
		//				break;
		//			}
		//			if (s.indexOf(word)>-1) {
		//				String id = map.get(s);
		//				result.put(s, id);
		//			}
		//		}
		return result;
	}

	/**
	 * String类型数据转换成队列
	 * @Date: 2014-1-10上午09:54:36
	 * @Author hualei
	 * @Description: List<String>
	 * @param s String数据
	 * @param split 分隔符
	 * @return
	 */
	public static List<String> StringtoList(String s, String split) {
		List<String> list = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(s, split);
		while (tokenizer.hasMoreElements()) {
			String str = (String) tokenizer.nextElement();
			list.add(str);
		}
		return list;
	}

	/**
	 * String类型数据转换成数组	
	 * @Date: 2014-1-10上午09:54:36
	 * @Author liujh
	 * @Description: String[]
	 * @param s String数据
	 * @param split 分隔符
	 * @return
	 */
	public static String[] toStringArray(String s, String split) {
		String[] sArray = new String[] {};
		if (!isBlank(s))
			sArray = s.split(split);
		return sArray;
	}

	/**
	 * 倒序排列
	 * @param list
	 * @return
	 */
	public static List<Map<String, Object>> sortDesc(List<Map<String, Object>> list) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if (list != null && list.size() > 0) {
			for (int i = list.size() - 1; i > -1; i--) {
				result.add(list.get(i));
			}
		}
		return result;
	}

	/**
	 * 按照key对应value对List<Map<String, Object>>进行排序
	* @Title: sortDescByTime
	* @param list
	* @param sort 排序的key值
	* @return
	* @return List<Map<String,Object>>
	* @throws
	 */
	public static List<Map<String, Object>> sortDescByTime(List<Map<String, Object>> list, final String sort) {
		//		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if (list != null && list.size() > 0) {
			final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Collections.sort(list, new Comparator<Map<String, Object>>() {

				public int compare(Map<String, Object> o1, Map<String, Object> o2) {
					//取出操作时间  
					int ret = 0;
					try {
						ret = df.parse(o1.get(sort).toString()).compareTo(df.parse(o2.get(sort).toString()));
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
					return ret;
				}

			});

		}
		return list;
	}

	public static Timestamp stringToTimestamp(String dateStr) {
		if (StringUtil.isBlank(dateStr))
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		try {
			Date date = sdf.parse(dateStr);
			date.getTime();
			cal.setTime(date);
			return new Timestamp(cal.getTimeInMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}

		cal.setTime(new Date());
		return new Timestamp(cal.getTimeInMillis());
	}

	public static String keepSecret(String str) {
		if (isBlank(str) || str.length() < 3)
			return "";
		List<String> list = new ArrayList<String>();
		list.add(str.substring(0, 1));
		list.add(str.substring(str.length() - 1, str.length()));
		String tmpStr = "";
		for (int i = 0; i < str.length() - 2; i++)
			tmpStr += "*";

		return list.get(0) + tmpStr + list.get(1);
	}

	public static void main(String[] args) {
		/*	Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("operationTime", "2010-01-10 12:20:00");

			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("operationTime", "2010-01-10 12:40:00");

			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("operationTime", "2010-01-10 12:30:00");

			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list.add(map1);
			list.add(map2);
			list.add(map3);

			System.out.println("排序前的list：");
			System.out.println(list);

			list = sortDescByTime(list, "operationTime");

			System.out.println("排序后的list：");
			System.out.println(list);
		*/
		//		List<String> t = new ArrayList<String>();
		//		t.add("1");
		//		t.add("2");
		//		t.add("4");
		//		t.add("5");
		//		System.out.println(listToString(t, ","));
		//		
		//		System.out.println(loop("?", 3, ","));

		//		List<Integer> t = stringToIntList("", ",");
		//		System.out.println(t.toString());
		String keepSecret = keepSecret("abc");
		System.out.println(keepSecret);
	}
		
}
