package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.xml.soap.Detail;

public class DetailTransaction {

	private Integer transactionId;
	private Integer pokemonId;
	private Integer quantity;
	
	
	
	public DetailTransaction(Integer transactionId, Integer pokemonId, Integer quantity) {
		this.transactionId = transactionId;
		this.pokemonId = pokemonId;
		this.quantity = quantity;
	}

	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getPokemonId() {
		return pokemonId;
	}
	public void setPokemonId(Integer pokemonId) {
		this.pokemonId = pokemonId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static void insertDetail(Vector<Cart> carts, int trId) {
		Connect con = Connect.getConnection();
		for (Cart cart : carts) {
			String query = "INSERT INTO detailtransaction VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			try {
				ps.setInt(1, trId);
				ps.setInt(2, cart.getPokemonId());
				ps.setInt(3, cart.getQuantity());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static Vector<DetailTransaction> getDetailById(int transId) {
		Vector<DetailTransaction> dts = new Vector<>();
		Connect con = Connect.getConnection();
		String query = "SELECT * FROM detailtransaction WHERE TransactionId = " + transId;
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				int trId = rs.getInt(1);
				int pokemonId = rs.getInt(2);
				int quantity = rs.getInt(3);
				DetailTransaction dt = new DetailTransaction(trId, pokemonId, quantity);
				dts.add(dt);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return dts;
	}
	
	
}
