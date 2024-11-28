package com.example.demo.myfolder;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class MyController {

    MyDatabase myDatabase = new MyDatabase();
    @GetMapping("/allNames")
    public List<String> getAll() {
        List<String> names = new ArrayList<>();

        for (int i = 0; i < myDatabase.getAnimals().size(); i++) {
            names.add(myDatabase.getAnimals().get(i).getName());
        }
        return names;
    }
    @GetMapping("/names/{name}")
    public Zwierze getAnimalByName(@PathVariable String name) {
        if (name == null) {
            throw new RuntimeException("Zwierze nie moze byc nullem");
        }
        for (Zwierze dupa : myDatabase.getAnimals()) {
            if (dupa.getName().equalsIgnoreCase(name)){
                return dupa;
            }
        }
        throw new RuntimeException(String.format("Zwierze o nazwie \"%s\" nie nalezy do bazy danych", name));
    }
    @PostMapping("/addNew")
    public void addAnimal(@RequestBody Zwierze input) {
        myDatabase.getAnimals().add(input);
    }

    @PatchMapping("/updateColor/{name}")
    public void updateColor(@PathVariable String name, @RequestBody String color) {
        for (Zwierze dupa : myDatabase.getAnimals()) {
            if (dupa.getName().equalsIgnoreCase(name)) {
                dupa.setColor(color);
                return;
            }
        }
        throw new RuntimeException(String.format("Zwierze o nazwie \"%s\" nie nalezy do bazy danych", name));
    }

    @DeleteMapping("/deleteZwierze/{name}")
    public void deleteZwierze(@PathVariable String name) {
        for(Zwierze dupa : myDatabase.getAnimals()) {
            if (dupa.getName().equalsIgnoreCase(name)) {
                myDatabase.getAnimals().remove(dupa);
                return;
            }
        }
        throw new RuntimeException(String.format("Zwierze o nazwie \"%s\" nie nalezy do bazy danych", name));
    }
}
