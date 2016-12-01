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
public enum Marca {
    VOLKSWAGEN("VOLKSWAGEN"),
    CHEVROLET("CHEVROLET"),
    FIAT("FIAT"),
    HONDA("HONDA"),
    HYUNDAI("HYUNDAI"),
    RENAULT("RENAULT");

    private final String name;

    private Marca(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
