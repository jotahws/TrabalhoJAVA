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
public enum ModeloMotocicleta {
    
    F("F 800"),
    cg("CG 150"),
    cbr("CBR 500"),
    biz("Biz");
    
    private final String name;

    private ModeloMotocicleta(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
