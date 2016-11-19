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

    gol("Gol"),
    celta("Celta"),
    palio("Palio"),
    sandero("Sandero"),
    clio("Clio"),
    uno("Uno"),
    up("Up"),
    onix("Onix"),
    hb("HB20"),
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
