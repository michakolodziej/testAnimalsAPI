package com.example.demo.myfolder;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MyDatabase {
    private List<Zwierze> animals;

    public MyDatabase() {
         animals = new ArrayList<>();
         animals.add(new Zwierze("Kot", 12, "Szary"));
         animals.add(new Zwierze("Pies", 13, "Czarny"));
         animals.add(new Zwierze("Krowa", 14, "Zielony"));
         animals.add(new Zwierze("Kapibara", 15, "Czerwony"));
         animals.add(new Zwierze("Wombat", 16, "Niebieski"));
         animals.add(new Zwierze("Stefan", 7, "Szary"));
    }
}
