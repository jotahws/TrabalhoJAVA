/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

/**
 *
 * @author JotaWind
 */
public enum ModeloAutomovel {

    Gol("Gol"),
    Celta("Celta"),
    Palio("Palio"),
    Sandero("Sandero"),
    Clio("Clio"),
    Uno("Uno"),
    Up("Up"),
    Onix("Onix"),
    Hb("HB20"),
    AMG("AMG-GT");
    
    private final String name;

    private ModeloAutomovel(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
