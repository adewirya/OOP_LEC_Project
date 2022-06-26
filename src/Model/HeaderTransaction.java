package Model;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class HeaderTransaction {

	private Integer transactionId;
	private Integer userId;
	private Date transactionDate;
	
	public HeaderTransaction(Integer transactionId, Integer userId, Date transactionDate) {
		this.transactionId = transactionId;
		this.userId = userId;
		this.transactionDate = transactionDate;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public HeaderTransaction createHeader(Integer transactionId, Integer userId, Date transactionDate) {
		return new HeaderTransaction(transactionId, userId, transactionDate);
	}
	
	public static void insertHeader(int userId, Date date) {
		String query = "INSERT INTO headertransaction values (null, ?, ?)";
		Connect con = Connect.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setInt(1, userId);
			ps.setDate(2, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// buat dapetin tr id nya
	public static int getTrId() {
		Connect con = Connect.getConnection();
		String query = "SELECT COUNT(*) FROM headertransaction";
		ResultSet rs = con.executeQuery(query);
		int id = 0;
		try {
			while(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return id;
	}
	
	public static Vector<HeaderTransaction> getAllHeader(int userId){
		Connect con = Connect.getConnection();
		Vector<HeaderTransaction> hts = new Vector<>();
		String query = "SELECT * FROM headertransaction WHERE UserId = " + userId;
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Integer trId = rs.getInt(1);
				Date date = rs.getDate(3);
				hts.add(new HeaderTransaction(trId, userId, date));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return hts;
	}
	
}
