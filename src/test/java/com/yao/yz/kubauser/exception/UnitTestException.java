package com.yao.yz.kubauser.exception;
	public class UnitTestException extends Exception {
	private static final long serialVersionUID = -6233799140764822106L;
	private String context;
	public UnitTestException(String context, Exception ex) {
		super(ex);
		this.context = context;
	}
	public UnitTestException(String context, String message) {
		super(message);
		this.context = context;
	}
	public String toString() {
		return context + " - " + super.toString();
	}
}
	