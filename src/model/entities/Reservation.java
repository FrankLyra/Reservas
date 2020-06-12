package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checking;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checking, Date checkout) {
		this.roomNumber = roomNumber;
		this.checking = checking;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChecking() {
		return checking;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checking.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if (checking.before(now) || checkout.before(now)) {
			return "Error in reservation: Reservations Date to update most be future";
		}
		if (!checkout.after(checking)) {
			return "Error in reservation: Caheck-out Date must be after check-in date.";
		}
		this.checking = checkin;
		this.checkout = checkout;
		return null;
	}

	@Override
	public String toString() {
		return "Room =" + roomNumber + ", checking=" + sdf.format(checking) + ", checkout=" + sdf.format(checkout) + ","
				+ duration() + " nights";
	}

}