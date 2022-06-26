package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Factory.PokemonFactory;

public class FirePokemon extends Pokemon{

	private Integer fireAttack;
	
	public FirePokemon(Integer pokemonId, String pokemonName, Integer pokemonHealth, Integer pokemonPrice,
			Integer fireAttack) {
		super(pokemonId, pokemonName, pokemonHealth, pokemonPrice);
		this.fireAttack = fireAttack;
	}

	public Integer getFireAttack() {
		return fireAttack;
	}

	public void setFireAttack(Integer fireAttack) {
		this.fireAttack = fireAttack;
	}

	@Override
	public void printBasedOnType() {
		// TODO Auto-generated method stub
		System.out.println("PokemonId : " + super.getPokemonId());
		System.out.println("PokemonName : " + super.getPokemonName());
		System.out.println("PokemonHealth : " + super.getPokemonHealth());
		System.out.println("Type : Fire");
		System.out.println("Price : " + super.getPokemonPrice());
		System.out.println("Special Attack : " + this.getFireAttack());
	}
	
	
	public static Vector<FirePokemon> getAllFirePokemon(){
		Connect con = Connect.getConnection();
		
		Vector<FirePokemon> firePokemons = new Vector<>();
		String query = "SELECT * FROM `pokemon` WHERE pokemonTypeId = 1";
		
		ResultSet rs = con.executeQuery(query);
		try {
			while(rs.next()) {
				Integer pokemonId = rs.getInt(1);
				String pokemonName = rs.getString(3);
				Integer pokemonHealth = rs.getInt(4);
				Integer pokemonPrice = rs.getInt(5);
				Integer fireAttack = rs.getInt(6);
				FirePokemon fp = (FirePokemon)PokemonFactory.createPokemon("FirePokemon", pokemonId, pokemonName, pokemonHealth, pokemonPrice, fireAttack);
				firePokemons.add(fp);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}

		
		return firePokemons;
	}


	
	
}
