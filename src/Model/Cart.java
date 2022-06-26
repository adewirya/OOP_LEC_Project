package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Cart {

	private Integer cartId;
	private Integer userId;
	private Integer pokemonId;
	private Integer quantity;
	
	public Cart(Integer cartId, Integer userId, Integer pokemonId, Integer quantity) {
		this.cartId = cartId;
		this.userId = userId;
		this.pokemonId = pokemonId;
		this.quantity = quantity;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	public static int pokemonExistsInCart(int userId, int pokemonId) {
		Connect con = Connect.getConnection();
		String query = "SELECT * FROM cart WHERE UserId = " + userId + " AND PokemonId = " + pokemonId;
		ResultSet rs = con.executeQuery(query);
		int cartId = 0;

		try {
			if (rs.next()) {
				return rs.getInt(1);
			}
			else {
				cartId = -1;
				return cartId;
			}

	
	
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return cartId;
	}
	
	public static void updateCartQuantity(int cartId, int quantity) {
		Connect con = Connect.getConnection();
		String query = "UPDATE `cart` SET Quantity = Quantity + ? WHERE CartId = ?";
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setInt(1, quantity);
			ps.setInt(2, cartId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void insertToCart(int userId, int pokemonId, int quantity) {
		Connect con = Connect.getConnection();
		String query = "INSERT INTO cart VALUES (null,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ps.setInt(1, userId);
			ps.setInt(2, pokemonId);
			ps.setInt(3, quantity);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Vector<Cart> getAllCart(int userId){
		Vector<Cart> carts = new Vector<>();
		Connect con = Connect.getConnection();
		
		String query = "SELECT * FROM cart WHERE UserId = " + userId;
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				Integer cartId = rs.getInt(1);
				Integer pokemonId = rs.getInt(3);
				Integer quantity = rs.getInt(4);
				Cart c = new Cart(cartId, userId, pokemonId, quantity);
				carts.add(c);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return carts;
	}
	
	public static void clearCarts(int userId) {
		Connect con = Connect.getConnection();
		
		String query = "DELETE FROM cart WHERE UserId = ? ";
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
