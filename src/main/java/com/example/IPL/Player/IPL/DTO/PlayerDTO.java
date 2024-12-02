package com.example.IPL.Player.IPL.DTO;

import jakarta.validation.constraints.NotNull;

public class PlayerDTO {

    private int  Id;
   @NotNull(message="Name is not blank")
    private  String name;
    private String role;
    private  String team;

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
