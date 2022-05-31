package com.example.demo.model;

import lombok.*;

@Data
public class PlayerDto {

    public Integer id;
    public String name;
    public Integer age;
    public String icon;
    public String national;
    public Integer winners;
    public Integer games;
    public String club;

    public PlayerDto(){
    }

    public PlayerDto(Integer id, String name, Integer age, String icon, String national, Integer winners, Integer games, String club) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.icon = icon;
        this.national = national;
        this.winners = winners;
        this.games = games;
        this.club = club;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getIcon() {
        return icon;
    }

    public String getNational() {
        return national;
    }

    public Integer getWinners() {
        return winners;
    }

    public Integer getGames() {
        return games;
    }

    public String getClub() {
        return club;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public void setWinners(Integer winners) {
        this.winners = winners;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
