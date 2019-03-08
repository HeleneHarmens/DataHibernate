package no.noroff.DataHibernate.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "characters")
public class Characters implements Serializable {

    // INSTANCE VARIABLES

    @Id
    //@GeneratedValue(generator = "incrementer")
    //@GenericGenerator(name = "incrementer", strategy = "increment")
    @Column(name = "characterID", nullable = false)
    private int characterID;

    @Column(name = "userID", nullable = false)
    private int userID;

    @Column(name = "characterName", nullable = false)
    private String characterName;

    @Column(name = "className", nullable = false)
    private String className;

    @Column(name = "characterLvl", nullable = false)
    private int characterLvl;




    // CONSTRUCTORS

    public Characters(){

    }



    // GETTERS & SETTERS

    public int getCharacterID() {
        return characterID;
    }
    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int user_userID) {
        this.userID = userID;
    }

    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }


    public int getCharacterLvl() {
        return characterLvl;
    }
    public void setCharacterLvl(int characterLvl) {
        this.characterLvl = characterLvl;
    }


    // OVERRIDE METHOD
    @Override
    public String toString() {

        String nameText ="";
        if (className.length() > 5){
            nameText = "\tName: ";
        } else {
            nameText = "\t\tName: ";
        }

        return "Owned by userID: " + userID +
                "\tcharID: " + characterID +
                "\tClass:"+ className +
                nameText+ characterName +
                " (lvl:" + characterLvl+")";
    }

    public String returnUserID (int ID) {
        String string = getUserID() + "";
        return string;

    }


}

