import java.util.Scanner;

import Facade.MainMenu;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	
	void loginMenu() {
		int userId = -1;
		while(userId < 0) {
			userId = MainMenu.Login();
		}
		
		mainMenu(userId);
		// dari sini tinggal koding klo dia udah masuk main menu
	}
	
	void cls() {
		for(int i =0; i<30; i++)
			System.out.println("");
	}
	
	void mainMenu(int userId) {
		boolean isRunning = true;
		while(isRunning) {
			cls();
			int ch = MainMenu.getUserChoice();
			cls();
			switch(ch) {
				case 1:
					MainMenu.viewPokemons();
					break;
				case 2:
					MainMenu.addPokemonToCart(userId);
					break;
				case 3:
					MainMenu.viewCarts(userId);
					break;
				case 4:
					MainMenu.checkOutCarts(userId);
					break;
				case 5:
					MainMenu.viewTransactions(userId);
					break;
				case 6:
					isRunning = false;
					break;
			}
		}
	}

	public Main() {
		// TODO Auto-generated constructor stub
		loginMenu();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
