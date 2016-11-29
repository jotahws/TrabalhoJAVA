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
public enum ModeloVan {

    KombiI("Kombi"),
    Sprinter("Sprinter"),
    Transit("Transit"),
    Ducato("Ducato");
    
    private final String name;

    private ModeloVan(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
