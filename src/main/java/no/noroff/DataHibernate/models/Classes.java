package no.noroff.DataHibernate.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Classes {

    // INSTANCE VARIABLES
    @Id
    @Column(name = "classID", unique = true)
    private int classID;

    @Column(name = "className", nullable = false)
    private String className;

    @Column(name = "abilities", nullable = false)
    private String abilities;


    // CONSTRUCTORS
    public Classes(){
    }

    public Classes(String className){
        this.className = className;
    }


    // GETTERS & SETTERS

    public int getClassID() {
        return classID;
    }
    public void setClassID(int classID) {
        this.classID = classID;
    }


    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }


    public String getAbilities() {
        return abilities;
    }
    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }


    // OVERRIDE METHOD

    @Override
    public String toString() {

        String abilityText ="";
        if (className.length() >= 5){
            abilityText = "\tAbilities: ";
        } else {
            abilityText = "\t\tAbilities: ";
        }

        return "classname: " + className + abilityText+ abilities;
    }



}
