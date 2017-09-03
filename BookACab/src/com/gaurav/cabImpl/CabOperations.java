package com.gaurav.cabImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.gaurav.cab.CabDetails;

public class CabOperations {

	public Set getCabInformation() {
		Set cabInfo = new HashSet();
		cabInfo.add(new CabDetails(10001, "DZIRE", "Y"));
		cabInfo.add(new CabDetails(10002, "SWIFT", "Y"));
		cabInfo.add(new CabDetails(10003, "INDICA", "Y"));
		cabInfo.add(new CabDetails(10004, "CITY", "Y"));
		cabInfo.add(new CabDetails(10005, "ETIOS", "Y"));
		cabInfo.add(new CabDetails(10006, "DUSTER", "Y"));
		cabInfo.add(new CabDetails(10007, "INNOVA", "Y"));
		cabInfo.add(new CabDetails(10008, "VERNA", "Y"));
		cabInfo.add(new CabDetails(10009, "CIAZ", "Y"));
		cabInfo.add(new CabDetails(10010, "AMAZE", "Y"));

		return cabInfo;
	}

	public List<Integer> confirmCabBooking(Set cabInfo, List<Integer> bookedCab) {
		boolean validateBooking = validateCabAvailabiliy(cabInfo);
		System.out.println("************* Booking Cab ***************");
		Iterator iterator = cabInfo.iterator();
		if (validateBooking) {
			while (iterator.hasNext()) {
				CabDetails cab = (CabDetails) iterator.next();
				if (cab.getCabAvailable().equalsIgnoreCase("Y")) {

					bookedCab.add(cab.getCabId());
					System.out.println("Cab " + cab.getCabType()
							+ " booked with cab Id : " + cab.getCabId());
					cab.setCabAvailable("N");
					break;
				}
			}
		} else {
			System.out.println("No Cabs available for booking.");
		}
		System.out.println("Booked Cabs : " + bookedCab);
		System.out.println("*****************************************");
		System.out.println();
		return bookedCab;
	}

	public List<Integer> cancelCabBooking(int cabId, Set cabInfo,
			List<Integer> bookedCab) {
		System.out.println("************* Cancelling Cab ***************");
		if (bookedCab.contains(cabId)) {
			Iterator iterator = cabInfo.iterator();
			while (iterator.hasNext()) {
				CabDetails cab = (CabDetails) iterator.next();
				if (cab.getCabId() == cabId) {
					bookedCab.remove(new Integer(cab.getCabId()));
					System.out.println("Cab " + cab.getCabType()
							+ " cancelled with cab Id : " + cab.getCabId());
					cab.setCabAvailable("Y");
					break;
				}
			}
			System.out.println("Booked Cabs : " + bookedCab);
			System.out.println();
		} else {
			System.out.println("Invalid Cab Id : " + cabId);
		}
		System.out.println("*****************************************");
		System.out.println();
		return bookedCab;
	}

	public List<Integer> getAvailableCabDetails(Set cabInfo) {
		List<Integer> availableCab = new ArrayList<Integer>();

		Iterator iterator = cabInfo.iterator();
		while (iterator.hasNext()) {
			CabDetails cab = (CabDetails) iterator.next();
			if (cab.getCabAvailable().equalsIgnoreCase("Y")) {
				availableCab.add(cab.getCabId());
				continue;
			}
		}
		System.out.println("Available Cab pool : " + availableCab);
		System.out.println();
		return availableCab;
	}

	public boolean validateCabAvailabiliy(Set cabInfo) {

		boolean validateFlag = false;
		Iterator iterator = cabInfo.iterator();
		while (iterator.hasNext()) {
			CabDetails cab = (CabDetails) iterator.next();
			if (cab.getCabAvailable().equalsIgnoreCase("Y")) {
				validateFlag = true;
				break;
			}
		}
		return validateFlag;
	}
}
