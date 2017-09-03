package com.gaurav.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gaurav.cabImpl.CabOperations;

public class BookACab {

	public static void main(String[] args) {

		List<Integer> bookedCab = new ArrayList<Integer>();
		List<Integer> availableCab = new ArrayList<Integer>();
		Set cabInfo = new HashSet();
		CabOperations cabbie = new CabOperations();

		cabInfo = cabbie.getCabInformation();

		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
	
		availableCab = cabbie.getAvailableCabDetails(cabInfo);
		
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);

		availableCab = cabbie.getAvailableCabDetails(cabInfo);

		bookedCab = cabbie.cancelCabBooking(10005, cabInfo, bookedCab);

		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);
		bookedCab = cabbie.confirmCabBooking(cabInfo, bookedCab);

		bookedCab = cabbie.cancelCabBooking(10004, cabInfo, bookedCab);

		availableCab = cabbie.getAvailableCabDetails(cabInfo);

	}
}
