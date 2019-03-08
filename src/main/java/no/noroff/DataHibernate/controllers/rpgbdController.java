package no.noroff.DataHibernate.controllers;


import no.noroff.DataHibernate.DataHibernateApplication;
import no.noroff.DataHibernate.models.Characters;
import no.noroff.DataHibernate.models.Classes;
import no.noroff.DataHibernate.models.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static no.noroff.DataHibernate.DataHibernateApplication.*;

@RestController
public class rpgbdController {

    /*_____ GET _____________________________________________________________*/

    @GetMapping("/users")
    public List<Users> userGet(){
        System.out.println("Returning default search of ALL users");
        //return getUsers();
        return getUserNameEmail();
    }

    @GetMapping("/user/{ID}")
    public Users userGet(@PathVariable int ID){
        System.out.println("Returning default search of user with ID "+ID);
          return getUser(ID);
    }


    @GetMapping("/characters")
    public List<Characters> charactersGet(){
        System.out.println("Returning default search of ALL characters");
        return getCharacters();
    }

    @GetMapping("/character/{ID}")
    public Characters characterGet(@PathVariable int ID) {
        System.out.println("Returning default search of character with ID "+ID);
        return getCharacter(ID);
    }


    @GetMapping("/classes")
    public List<Classes> classesGet() {
        System.out.println("Returning default search of ALL classes");
        return getClasses();
        //return getAbilities();
    }

    @GetMapping("/class/{className}")
    public Classes getCharClass (@PathVariable String className) {
        System.out.println("Returning default search of class with ID "+className);
        return DataHibernateApplication.getClass(className);
    }


    /*_____ POST _____________________________________________________________*/

    @PostMapping("/user")
    public void createUser(@RequestBody Users newUser){
        System.out.println("Adding new user:\n"+newUser);
        addUser(newUser);
    }

    @PostMapping("/character")
    public void createCharacter(@RequestBody Map<String, String> newChar){
        System.out.println("Adding new character:");

        for(String key:newChar.keySet()){
            System.out.println(key + " : " + newChar.get(key));
        }

        addCharacter(newChar);
    }

}
