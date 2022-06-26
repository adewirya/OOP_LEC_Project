package Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

import Model.Cart;
import Model.DetailTransaction;
import Model.HeaderTransaction;

public class TransactionController {
	
	static Scanner scan = new Scanner(System.in);

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}
	
	public static void insertHeaderDetail(int userId, Vector<Cart> carts) {
		LocalDate dateInp = LocalDate.now();
		HeaderTransaction.insertHeader(userId, Date.valueOf(dateInp));
		
//		int tes = HeaderTransaction.getTrId();
		DetailTransaction.insertDetail(carts, HeaderTransaction.getTrId());
		Cart.clearCarts(userId);
	}
	
	
	public static Vector<HeaderTransaction> getAllTransaction(int userId){
		Vector<HeaderTransaction> hts = HeaderTransaction.getAllHeader(userId);
		
		return hts;
	}
	
	public static int getHeaderByRange(int userId) {
		Vector<HeaderTransaction> hts = getAllTransaction(userId);
		
		int ch = 0;
		while(ch < 1 || ch > hts.size()) {
			System.out.print("Which Transaction do you want to see? : ");
			ch = scan.nextInt();
			scan.nextLine();
		}
		
		int transId = hts.get(ch-1).getTransactionId();
		
		return transId;
	}
	
	public static Vector<DetailTransaction> getDetails(int transId){
		Vector<DetailTransaction> dts = DetailTransaction.getDetailById(transId);
		return dts;
	}
}
