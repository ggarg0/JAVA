package com.gaurav.cab;

public class CabDetails {

	int CabId;
	String CabType;
	String CabAvailable;
	
	public CabDetails(int cabId, String cabType, String cabAvailable) {
		CabId = cabId;
		CabType = cabType;
		CabAvailable = cabAvailable;
	}
	
	public int getCabId() {
		return CabId;
	}

	public void setCabId(int cabId) {
		CabId = cabId;
	}

	public String getCabType() {
		return CabType;
	}

	public void setCabType(String cabType) {
		CabType = cabType;
	}

	public String getCabAvailable() {
		return CabAvailable;
	}

	public void setCabAvailable(String cabAvailable) {
		CabAvailable = cabAvailable;
	}

	
	
}
