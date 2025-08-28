package com.ait.binding;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class Ticket {
	private Integer ticketId;
	private String fname;
	private String lname;
	private String from;
	private String to;
	private String doj;
	private Long mob;
	private String ticketPrice;
	private Long trainNo;
	private String status;

}
