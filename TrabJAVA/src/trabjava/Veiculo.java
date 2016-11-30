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
public abstract class Veiculo implements VeiculoI {

    private Double valorDeCompra;
    private String placa;
    private int ano;
    private Marca marca;
    private Estado estado;
    private Categoria categoria;
    private Locacao locacao;
    private int id;

    public Veiculo(Double valorDeCompra, String placa, int ano, Marca marca, Estado estado, Categoria categoria) {
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.locacao = null;
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        double valor = this.getValorDiariaLocacao()*dias;
        Locacao locacao = new Locacao(dias, valor, data, cliente);
        this.locacao=locacao;
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        locacaoDAO.inserirLocacao(locacao, this);
        this.estado=Estado.LOCADO;
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.atualizaEstado("LOCADO", this.id);
    }
    
    @Override
    public void vender() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.atualizaEstado("VENDIDO", this.id);
        this.estado=Estado.VENDIDO;
    }


    public void devolver() {
        LocacaoDAO locDAO = new LocacaoDAO();
        locDAO.deletaLocacao(this.id);
        VeiculoDAO vecDAO = new VeiculoDAO();
        vecDAO.atualizaEstado("DISPONIVEL", this.id);
        this.estado=Estado.DISPONIVEL;
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public Marca getMarca() {
        return this.marca;
    }

    @Override
    public Categoria getCategoria() {
        return this.categoria;
    }

    @Override
    public Locacao getLocacao() {
        return this.locacao;
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }

    @Override
    public int getAno() {
        return this.ano;
    }
    
    public void setLocacao(Locacao locacao){
        this.locacao=locacao;
    }

    public Double getValorDeCompra() {
        return valorDeCompra;
    }

    @Override
    public double getValorParaVenda() {
        Calendar c = Calendar.getInstance();
        int idade = c.get(Calendar.YEAR) - this.ano;
        Double valorVenda = this.valorDeCompra - (idade * 0.15 * this.valorDeCompra);
        if (valorVenda < (this.valorDeCompra * 0.1)) {
            return this.valorDeCompra * 0.1;
        }
        return valorVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
