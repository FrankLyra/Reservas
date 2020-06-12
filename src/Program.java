import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room Number");
		int number = sc.nextInt();
		System.out.println("Checking Date (dd/mm/yyyy): ");
		Date checking = sdf.parse(sc.next());
		System.out.println("Checkout Date (dd/mm/yyyy): ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checking)) {
			System.out.println("Error in reservation: Caheck-out Date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checking, checkout);
			System.out.println("Rreservation " + reservation);

			System.out.println();
			System.out.println("Enter Data to update reservation:");
			System.out.println("Checking Date (dd/mm/yyyy): ");
			checking = sdf.parse(sc.next());
			System.out.println("Checkout Date (dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());

			String error = reservation.updateDates(checking, checkout);
			
			if (error != null) {
				System.out.println("Error in reservation " + error);
			} else {
				System.out.println("Rreservation " + reservation);
			}
		}

		sc.close();
	}

}
