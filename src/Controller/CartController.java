package Controller;

import java.util.Vector;

import Model.Cart;

public class CartController {

	public CartController() {
		// TODO Auto-generated constructor stub
	}
	
	public static Vector<Cart> getAllCart(int userId){
		Vector<Cart> carts = Cart.getAllCart(userId);
		return carts;
	}
	
	
	public static void addToCart(int userId, int pokemonId, int quantity) {
		int cartId = Cart.pokemonExistsInCart(userId, pokemonId);
		if( cartId == -1) {
			Cart.insertToCart(userId, pokemonId, quantity);

		} else {
			Cart.updateCartQuantity(cartId, quantity);
		}
	}
}
