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
public abstract class Veiculo implements VeiculoI {

    private Double valorDeCompra;
    private String placa;
    private int ano;
    private Marca marca;
    private Estado estado;
    private Categoria categoria;
    private Locacao locacao;

    public Veiculo(Double valorDeCompra, String placa, int ano, Marca marca, Estado estado, Categoria categoria) {
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.locacao = null;
    }

}
