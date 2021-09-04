package PokemonTrainer_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = "";
        while (!"Tournament".equals(input = bufferedReader.readLine())) {
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);
        }

        input = "";
        while (!"End".equals(input = bufferedReader.readLine())) {
            String element = input;

            for (Map.Entry<String, Trainer> currentTrainer : trainers.entrySet()) {

                if (currentTrainer.getValue().getPokemons().size() > 0) {
                    boolean havePokemons = false;
                    for (Pokemon currentPokemon : currentTrainer.getValue().getPokemons()) {
                        if (currentPokemon.getPokemonElement().equals(element)) {
                            havePokemons = true;
                            currentTrainer.getValue().increaseNumberOfBadges();
                            break;
                        }
                    }
                    if (!havePokemons) {
                        currentTrainer.getValue().missingPokemonPenalty();
                    }

                }
            }


        }
        trainers.entrySet()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges()))
                .forEach(trainer -> {
                    System.out.printf("%s %d %s%n", trainer.getKey(), trainer.getValue().getNumberOfBadges(), trainer.getValue().getPokemons().size());
                });

    }
}
