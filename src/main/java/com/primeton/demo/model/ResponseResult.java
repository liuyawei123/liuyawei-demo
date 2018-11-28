package com.primeton.demo.model;

import io.swagger.annotations.ApiModel;

/**
 * 用户状态信息 即用户登陆成功返回的状态信息和用户信息 失败后的异常信息
 * 
 * @author liuya
 *
 * @param <T>泛型数据对象
 */
@ApiModel(value = "ResponseResult", description = "用户状态信息管理")
public class ResponseResult<T> {
	/** 没有异常 **/
	public static final int SUCCESS_MESSAGE = 1;// 没有异常
	/** 有异常 **/
	public static final int STATE_ERR = 0;// 有异常
	/** 用户名已经存在 **/
	public static final int ERROR_USERNAME = 1000;// 用户名已经存在
	/** 用户名格式错误 **/
	public static final int ERROR_USERNAME_FORMAT = 1001;// 用户名格式错误
	/** 密码格式错误 **/
	public static final int ERROR_PASSWORD = 1002;// 密码错误
	/** 密码错误 **/
	public static final int ERROR_PASSWORD_FORMAT = 1003;// 密码格式错误
	/** 删除失败 **/
	public static final int ERROR_DELETE = 1004;// 删除失败
	/** 部门名名字错误 **/
	public static final int ERROR_DEPTNAME = 1005;// 部门名名字错误
	/** 更新失败 **/
	public static final int ERROR_UPDATE = 1006;// 更新失败

	private Integer state;// 用户状态吗
	private String message;// 用户异常信息记录
	private T data;// 用于封装对象信息

	public ResponseResult() {
		super();
	}

	public ResponseResult(Integer state) {
		super();
		setState(state);
	}

	public ResponseResult(Integer state, String message) {
		super();
		setState(state);
		setMessage(message);
	}

	public ResponseResult(Exception e) {
		super();
		setState(STATE_ERR);
		setMessage(e.getMessage());
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
}