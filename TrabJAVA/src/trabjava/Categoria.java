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
public enum Categoria {
    POPULAR("POPULAR"),
    INTERMEDIARIO("INTERMEDIARIO"),
    LUXO("LUXO");
  
    private final String name;
    
    private Categoria(String n){
        name = n;
    }
    
    public String toString() {
        return this.name;
    };
}

