package no.noroff.DataHibernate.models;


public enum ClassEnums {
    Druid ("Druid", "Entangling Roots", "Shapeshifting"),
    Hunter("Hunter", "Disengage", "Multi-Shot"),
    Mage("Mage", "Polymorph", "Fireball"),
    Paladin("Paladin", "BladeOfJustice", "Judgement"),
    Warlock("Warlock", "Felbolt", "Summon Imp"),
    Rogue("Rogue", "Blind", "Pick Pocket")
    ;

    ClassEnums (String name, String skill_1, String skill_2){
        this.name = name;
        this.skill1 = skill_1;
        this.skill2 = skill_2;

    }

    public String name;
    public String skill1;
    public String skill2;

}
