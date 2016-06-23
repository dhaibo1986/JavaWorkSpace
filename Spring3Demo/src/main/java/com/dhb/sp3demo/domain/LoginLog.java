package com.dhb.sp3demo.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class LoginLog implements Serializable {
	
	private int loginLogid;
	private int userId;
	private String ip;
	private Date LoginDate;
}
