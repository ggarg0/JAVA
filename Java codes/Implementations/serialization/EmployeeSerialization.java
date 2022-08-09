package com.serialization;

import java.io.Serializable;

public class EmployeeSerialization extends superEmployee {
  public String firstName;
  private static final long serialVersionUID = 5462223600l;
  public EmployeeSerialization(String firstName, String lastName)
  {
	 this.firstName=firstName;
	 this.lastName=lastName;
  }
}
class superEmployee implements Serializable{
  public String lastName;
  static  String companyName = "TATA";
  static String email;
  final transient  String address = "INDIA";
  static transient String companyCEO;
  transient  String code = "AA";
}