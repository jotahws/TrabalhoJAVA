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
public enum Estado {
    NOVO("NOVO"),
    LOCADO("LOCADO"),
    DISPONIVEL("DISPONÍVEL"),
    VENDIDO("VENDIDO");
    
    private final String name;

    private Estado(String n) {
        name = n;
    }

    public String toString() {
        return this.name;
    }
;
};
