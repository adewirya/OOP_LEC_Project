package Facade;

import java.util.Scanner;


import java.util.Vector;

import Controller.CartController;
import Controller.PokemonController;
import Controller.TransactionController;
import Controller.UserController;
import Model.Cart;
import Model.DetailTransaction;
import Model.HeaderTransaction;
import Model.Pokemon;
import java.sql.Date;
import java.time.LocalDate;

public class MainMenu {
	
	static Scanner scan = new Scanner(System.in);

	public MainMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public static int Login() {
		System.out.println("Welcome to Pokemart!!");
		System.out.println("============================");
		System.out.print("Input Username : ");
		String username = scan.nextLine();
		System.out.print("Input Password : ");
		String password = scan.nextLine();
		int userId = UserController.Login(username, password);
		cls();
		
		return userId;
	}

	public static void addPokemonToCart(int userId) {
		viewPokemons();
		Vector<Pokemon> ps = PokemonController.getAllPokemon();
		if(ps.isEmpty()) {
			System.out.println("There is no pokemon!");
			return;
		}
				int pokemonId;
		int quantity;
		boolean check = true;
		do {
			System.out.print("Insert Pokemon ID: ");
			pokemonId = scan.nextInt();
			scan.nextLine();
			
			for (Pokemon pokemon : ps) {
				if(pokemon.getPokemonId() == pokemonId) {
					check = false;
					break;
				}
			}
		} while (check);
			
		do {
			System.out.print("Insert Quantity: ");
			quantity = scan.nextInt(); 
			scan.nextLine();
		} while (quantity <= 0);
		
		CartController.addToCart(userId, pokemonId, quantity);
	}
	
	public static void viewPokemons() {
		// print all
		Vector<Pokemon> ps = PokemonController.getAllPokemon();
		for (Pokemon pokemon : ps) {
			pokemon.printBasedOnType();
			System.out.println("================");
		}
	}
	
	public static void viewCarts(int userId) {
		//try
		Vector<Cart> cs = CartController.getAllCart(userId);
		for (Cart cart : cs) {
			System.out.println("Cart Id : " + cart.getCartId());
			System.out.println("Pokemon ID: "+cart.getPokemonId());
			System.out.println("Qty: "+cart.getQuantity());
			System.out.println("================");
		}
		scan.nextLine();
	}
	
	public static void viewTransactions(int userId) {
		Vector<HeaderTransaction> hts = TransactionController.getAllTransaction(userId);
		for (HeaderTransaction ht : hts) {
			System.out.println("Transaction Id : " + ht.getTransactionId());
			System.out.println("Date : " + ht.getTransactionDate());
			System.out.println("====================");
		}
		int transId = TransactionController.getHeaderByRange(userId);
		cls();
		
		Vector<DetailTransaction> dts = TransactionController.getDetails(transId);
		for (DetailTransaction dt : dts) {
			System.out.println("Pokemon Id : " + dt.getPokemonId());
			System.out.println("Quantity : " + dt.getQuantity());
			System.out.println("===================");
		}
		System.out.println("Press enter to continue....");
		scan.nextLine();
	}
	
	private static void cls() {
		for(int i = 0; i<30; i++)
			System.out.println("");
	}
	
	public static int getUserChoice() {
		System.out.println("Welcome to PokemonMart");
		System.out.println("1. View Pokemon");
		System.out.println("2. Buy Pokemon");
		System.out.println("3. View Carts");
		System.out.println("4. Checkout Carts");
		System.out.println("5. View Transactions");
		System.out.println("6. Exit");
		System.out.print(">> ");
		int ch = 0;
		while(ch < 1 || ch > 6) {
			ch = scan.nextInt();
			scan.nextLine();
		}
		
		return ch;
	}
	
	public static void checkOutCarts(int userId) {
		
		// ambil cart si user
		Vector<Cart> carts = CartController.getAllCart(userId);
		TransactionController.insertHeaderDetail(userId, carts);
		System.out.println("Cart checkout sucessfully....");
		scan.nextLine();
	}
	
}
