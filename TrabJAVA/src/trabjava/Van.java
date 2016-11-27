/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

import java.util.Calendar;

/**
 *
 * @author JotaWind
 */
public class Van extends Veiculo {

    private ModeloVan modelo;

    public Van(ModeloVan modelo, Double valorDeCompra, String placa, int ano, Marca marca, Estado estado, Categoria categoria) {
        super(valorDeCompra, placa, ano, marca, estado, categoria);
        this.modelo = modelo;
    }

    public ModeloVan getModelo() {
        return modelo;
    }
    
    @Override
    public double getValorDiariaLocacao() {String categoria = super.getCategoria().toString();
       switch (categoria){
           case "POPULAR":
               return 200;
           case "INTERMEDIARIO":
               return 400;
           case "LUXO":
               return 600;
           default:
               return 0;
       }
    }

}
