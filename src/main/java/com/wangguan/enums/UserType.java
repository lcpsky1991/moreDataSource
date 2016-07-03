package com.wangguan.enums;

/**
 * 用户类型枚举类
 * 
 * @author zhangtb
 * @date 2016-7-3 14:29:18
 * @since 1.0.0
 */
public enum UserType {

	FRONT("前台用户", 0),
	
	BACK("后台用户", 1);

	// 成员变量
	private String name;
	private int index;

	private UserType(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * enum lookup map
	 
	public static final Map<Integer, String> lookup = new HashMap<Integer, String>();

	static {
		for (UserType s : EnumSet.allOf(UserType.class)) {
			lookup.put(s.getIndex(), s.getName());
		}
	}*/

}
