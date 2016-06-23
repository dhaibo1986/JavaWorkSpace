package com.dhb.sp3demo.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class User implements Serializable {
	
	private  int userid;
	private String userName;
	private String password;
	private int credits;
	private String lasip;
	private Date lastVisit;
	
	
}
