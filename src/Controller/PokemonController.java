package Controller;

import java.util.Vector;

import Model.Cart;
import Model.FirePokemon;
import Model.Pokemon;
import Model.WaterPokemon;

public class PokemonController {

	public PokemonController() {
		// TODO Auto-generated constructor stub
	}
	
	public static Vector<Pokemon> getAllPokemon() {
		
		Vector<FirePokemon> fps = FirePokemon.getAllFirePokemon();
		Vector<WaterPokemon> wps = WaterPokemon.getAllWaterPokemon();
		
		Vector<Pokemon> pokemons = new Vector<>();
		pokemons.addAll(fps);
		pokemons.addAll(wps);
		
		return pokemons;
	}
	

	

}
