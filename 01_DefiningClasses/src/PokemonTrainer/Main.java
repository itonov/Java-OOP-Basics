package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!"tournament".equalsIgnoreCase(input)) {
            String[] inputParams = input.split("\\s+");
            String trainerName = inputParams[0];
            String pokemonName = inputParams[1];
            String pokemonElement = inputParams[2];
            int pokemonHealth = Integer.parseInt(inputParams[3]);
            Pokemon newPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>()));
            trainers.get(trainerName).addPokemon(newPokemon);

            input = reader.readLine();
        }
        String inputElement = reader.readLine();

        while (!"end".equalsIgnoreCase(inputElement)) {
            for (Map.Entry<String, Trainer> kvp : trainers.entrySet()) {
                Trainer currentTrainer = kvp.getValue();
                List<Pokemon> currentPokemons = currentTrainer.getPokemons();
                boolean hasPokemonWithElement = false;
                for (Pokemon pokemon : currentPokemons) {
                    if (pokemon.getElement().equals(inputElement)) {
                        hasPokemonWithElement = true;
                        break;
                    }
                }

                if (!hasPokemonWithElement) {
                    for (int i = 0; i < currentPokemons.size(); i++) {
                        currentPokemons.get(i).setHealth(currentPokemons.get(i).getHealth() - 10);
                        if (currentPokemons.get(i).getHealth() <= 0) {
                            currentPokemons.remove(i);
                        }
                    }
                } else {
                    currentTrainer.setBadges(currentTrainer.getBadges() + 1);
                }
            }
            inputElement = reader.readLine();
        }

        trainers = trainers.entrySet()
                .stream()
                .sorted(Comparator.comparingInt((Map.Entry<String, Trainer> x) -> x.getValue().getBadges())
                        .reversed())
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, Trainer> kvp : trainers.entrySet()) {
            System.out.println(kvp.getKey() + " " + kvp.getValue().getBadges() + " " + kvp.getValue().getPokemons().size());
        }
    }
}
