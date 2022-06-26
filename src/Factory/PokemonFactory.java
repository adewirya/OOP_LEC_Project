package Factory;

import Model.FirePokemon;
import Model.Pokemon;
import Model.WaterPokemon;

public class PokemonFactory {

	public static Pokemon createPokemon(String type,Integer pokemonId, String pokemonName, Integer pokemonHealth,
			Integer pokemonPrice, Integer specialAttack) {
		// TODO Auto-generated constructor stub
	
		if (type.equals("FirePokemon")) {
			return new FirePokemon(pokemonId, pokemonName, pokemonHealth, pokemonPrice, specialAttack);	
		}
		return new WaterPokemon(pokemonId, pokemonName, pokemonHealth, pokemonPrice, specialAttack);
	}

}
