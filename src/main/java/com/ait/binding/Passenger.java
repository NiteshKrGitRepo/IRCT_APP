package com.ait.binding;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Passenger {
	private String fname;
	private String lname;
	private String from;
	private String to;
	private String doj;
	private Long mob;
	private Long trainNo;

}
