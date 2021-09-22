package PokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getPokemonName(), pokemon.getPokemonElement(), pokemon.getPokemonHealth() - 10);

    public void missingPokemonPenalty() {
        this.pokemons = this.pokemons
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getPokemonHealth()>0)
                .collect(Collectors.toList());
    }

    public Trainer() {
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void increaseNumberOfBadges() {
        this.numberOfBadges = numberOfBadges + 1;
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(this.pokemons);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }
}
