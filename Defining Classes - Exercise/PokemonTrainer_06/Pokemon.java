package PokemonTrainer_06;

public class Pokemon {
    private String pokemonName;
    private String pokemonElement;
    private int pokemonHealth;

    public Pokemon(String pokemonName,String pokemonElement,int pokemonHealth){
        this.pokemonName=pokemonName;
        this.pokemonElement=pokemonElement;
        this.pokemonHealth=pokemonHealth;
    }

    public String getPokemonElement() {
        return pokemonElement;
    }

    public String getPokemonName() {
        return pokemonName;
    }


    public int getPokemonHealth() {
        return pokemonHealth;
    }
}
