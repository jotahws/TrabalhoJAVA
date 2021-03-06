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
public class Motocicleta extends Veiculo {

    private ModeloMotocicleta modelo;
    private int idMotocicleta;

    public Motocicleta(ModeloMotocicleta modelo, Double valorDeCompra, String placa, int ano, Marca marca, Estado estado, Categoria categoria) {
        super(valorDeCompra, placa, ano, marca, estado, categoria);
        this.modelo = modelo;
    }

    public Motocicleta(int idMotocicleta, ModeloMotocicleta modelo, Double valorDeCompra, String placa, int ano, Marca marca, Estado estado, Categoria categoria) {
        super(valorDeCompra, placa, ano, marca, estado, categoria);
        this.modelo = modelo;
        this.idMotocicleta=idMotocicleta;
    }
    public ModeloMotocicleta getModelo() {
        return modelo;
    }

    public void setIdMotocicleta(int idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    public int getIdMotocicleta() {
        return idMotocicleta;
    }

    @Override
    public double getValorDiariaLocacao() {String categoria = super.getCategoria().toString();
       switch (categoria){
           case "POPULAR":
               return 70;
           case "INTERMEDIARIO":
               return 200;
           case "LUXO":
               return 350;
           default:
               return 0;
       }
    }

}
