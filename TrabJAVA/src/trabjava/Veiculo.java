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

    public Veiculo(Double valorDeCompra, String placa, int ano, Marca marca, Estado estado, Categoria categoria) {
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
    }

    public Double getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(Double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
