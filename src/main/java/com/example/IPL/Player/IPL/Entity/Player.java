package com.example.IPL.Player.IPL.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="IPL_Player")
public class Player {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  Id;
    private  String name;
    private String role;
    private  String team;

    public int getId() {
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
