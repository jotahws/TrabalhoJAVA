/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author JotaWind
 */
public class VeiculoDAO {

    private String insertVeiculo = "INSERT INTO VEICULO (valor_compra, placa, ano, "
            + "marca, estado, categoria) VALUES (?,?,?,?,?,?)";
    private Connection con = null;
    private PreparedStatement stmt = null;

    public void inserirVeiculo(Veiculo veiculo) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertVeiculo);
            stmt.setDouble(1, calculaValorDeCompra(veiculo.getValorParaVenda(),veiculo.getAno()));
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getAno());
            stmt.setString(4, veiculo.getMarca().toString());
            stmt.setString(5, veiculo.getEstado().toString());
            stmt.setString(6, veiculo.getCategoria().toString());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir veículo: \n" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar Statment ou fechar conexão");
            }
        }
    }
    
    private double calculaValorDeCompra(double valorVenda, int ano){
        Calendar c = Calendar.getInstance();
        int idade = c.get(Calendar.YEAR) - ano;
        double valorCompra = valorVenda/(1-0.15*idade);
        if (valorVenda < (valorCompra*0.1)){
            return valorVenda/0.1;
        }
        return valorCompra;
    }
}
