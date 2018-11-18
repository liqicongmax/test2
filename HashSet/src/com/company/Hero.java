package com.company;

public class Hero {
    private String name;
    private Integer hp;
    public Hero(String name,Integer hp){
        this.name=name;
        this.hp=hp;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public boolean equals(Object object) {
        Hero hero=(Hero)object;
        if(this.hp!=hero.hp||!(this.name).equals(hero.name)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
