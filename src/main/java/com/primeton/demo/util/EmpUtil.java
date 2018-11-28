package com.primeton.demo.util;

/**
 * 用户工具类用于检验用户数据的合理性 例如 用户密码 用户名等
 * 
 * @author liuyawei
 *
 */
public class EmpUtil {
	
	/**
	 * 用户格式：2到8个字的汉字,或者2到16个字的英文
	 */
	private static final String USERNAME_CHECK = "^(([\\u4e00-\\u9fa5]{2,8})|([a-zA-Z]{2,16}))$";
	
	/**
	 * 密码格式：字母和数字构成，不能超过16位；
	 */
	private static final String PASSWORD_CHECK = "[0-9]{1,16}";

	/**
	 * 验证用户名
	 * @param username 需要被验证的用户名
	 * @return 如果满足格式则正确返回true；否则错误返回false
	 */
	public static boolean checkEmpName(String empName) {

		return empName.matches(USERNAME_CHECK);
	}

	/**
	 * 验证密码
	 * @param password 需要被验证的的密码
	 * @return 如果满足格式则正确返回true，否则返回false
	 */
	public static boolean checkPassword(String password) {
		return password.matches(PASSWORD_CHECK);
	}
}
