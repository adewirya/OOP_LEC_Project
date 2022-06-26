package Model;

public abstract class Pokemon {

	private Integer pokemonId;
	private String pokemonName;
	private Integer pokemonHealth;
	private Integer pokemonPrice;
	
	public Pokemon(Integer pokemonId, String pokemonName, Integer pokemonHealth, Integer pokemonPrice) {
		this.pokemonId = pokemonId;
		this.pokemonName = pokemonName;
		this.pokemonHealth = pokemonHealth;
		this.pokemonPrice = pokemonPrice;
	}

	public Integer getPokemonId() {
		return pokemonId;
	}
	public void setPokemonId(Integer pokemonId) {
		this.pokemonId = pokemonId;
	}
	public String getPokemonName() {
		return pokemonName;
	}
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	public Integer getPokemonHealth() {
		return pokemonHealth;
	}
	public void setPokemonHealth(Integer pokemonHealth) {
		this.pokemonHealth = pokemonHealth;
	}
	public Integer getPokemonPrice() {
		return pokemonPrice;
	}
	public void setPokemonPrice(Integer pokemonPrice) {
		this.pokemonPrice = pokemonPrice;
	}
	
	public abstract void printBasedOnType();
	
}
