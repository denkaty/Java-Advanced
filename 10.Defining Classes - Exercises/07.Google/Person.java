package Google_07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemons> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;

    public Person(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemons> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemons> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Parents> getParentsList() {
        return this.parentsList;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

}
