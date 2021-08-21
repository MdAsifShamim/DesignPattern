package com.spring.beans;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	private String eid;
	private String ename;
	private double esal;
	private String eaddr;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsal() {
		return esal;
	}

	public void setEsal(double esal) {
		this.esal = esal;
	}

	public String getEaddr() {
		return eaddr;
	}

	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}


}
