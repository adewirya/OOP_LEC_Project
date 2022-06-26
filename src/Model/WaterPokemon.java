package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Factory.PokemonFactory;

public class WaterPokemon extends Pokemon {

	private Integer waterAttack;

	public WaterPokemon(Integer pokemonId, String pokemonName, Integer pokemonHealth, Integer pokemonPrice,
			Integer waterAttack) {
		super(pokemonId, pokemonName, pokemonHealth, pokemonPrice);
		this.waterAttack = waterAttack;
	}

	public Integer getWaterAttack() {
		return waterAttack;
	}

	public void setWaterAttack(Integer waterAttack) {
		this.waterAttack = waterAttack;
	}

	@Override
	public void printBasedOnType() {
		// TODO Auto-generated method stub
		System.out.println("PokemonId : " + super.getPokemonId());
		System.out.println("PokemonName : " + super.getPokemonName());
		System.out.println("PokemonHealth : " + super.getPokemonHealth());
		System.out.println("Type : Water");
		System.out.println("Price : " + super.getPokemonPrice());
		System.out.println("Special Attack : " + this.getWaterAttack());
	}
	
	public static Vector<WaterPokemon> getAllWaterPokemon(){
		Connect con = Connect.getConnection();
		
		Vector<WaterPokemon> waterPokemons = new Vector<>();
		String query = "SELECT * FROM `pokemon` WHERE pokemonTypeId = 2";
		
		ResultSet rs = con.executeQuery(query);
		try {
			while(rs.next()) {
				Integer pokemonId = rs.getInt(1);
				String pokemonName = rs.getString(3);
				Integer pokemonHealth = rs.getInt(4);
				Integer pokemonPrice = rs.getInt(5);
				Integer waterAttack = rs.getInt(6);
				WaterPokemon wp = (WaterPokemon)PokemonFactory.createPokemon("WaterPokemon", pokemonId, pokemonName, pokemonHealth, pokemonPrice, waterAttack);
				waterPokemons.add(wp);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}

		
		return waterPokemons;
	}
	

}
