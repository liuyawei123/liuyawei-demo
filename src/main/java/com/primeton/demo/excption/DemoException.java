package com.primeton.demo.excption;

/**
 * 自定义异常
 * @author liuya
 *
 */
public class DemoException extends RuntimeException {

	private static final long serialVersionUID = -2879099986352308425L;
	/** 异常信息 **/
	private String message;
	/** 异常编码 **/
	private Integer errCode;

	public DemoException(String message, Integer errCode) {
		super();
		this.message = message;
		this.errCode = errCode;
	}

	@Override
	public String toString() {
		return "DemoException [message=" + message + ", errCode=" + errCode + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public DemoException() {
		super();
	}

	public DemoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DemoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DemoException(String message) {
		super(message);
	}

	public DemoException(Throwable cause) {
		super(cause);
	}

}
