/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author JotaWind
 */
public class VeiculoDAO {

    private final String insertVeiculo = "INSERT INTO VEICULO (valor_compra, placa, ano, "
            + "marca, estado, categoria) VALUES (?,?,?,?,?,?)";
    private final String selectVeiculoID = "SELECT * FROM VEICULO WHERE IDVEICULO=?";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirVeiculo(Veiculo veiculo) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertVeiculo, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, calculaValorDeCompra(veiculo.getValorParaVenda(), veiculo.getAno()));
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getAno());
            stmt.setString(4, veiculo.getMarca().toString());
            stmt.setString(5, veiculo.getEstado().toString());
            stmt.setString(6, veiculo.getCategoria().toString());
            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int veiculoID = rs.getInt(1);
                veiculo.setId(veiculoID);
            }
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

    private double calculaValorDeCompra(double valorVenda, int ano) {
        Calendar c = Calendar.getInstance();
        int idade = c.get(Calendar.YEAR) - ano;
        double valorCompra = (1 - 0.15 * idade) / valorVenda;
        if (valorCompra < 0) {
            valorCompra = (valorVenda / 0.1);
            return valorCompra;
        }
        return valorCompra;
    }

    public Veiculo buscaVeiculo(int id, String modelo) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(selectVeiculoID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Double valorCompra = rs.getDouble("valor_compra");
                String placa = rs.getString("placa");
                int ano = rs.get("ano");
                String marca = rs.getString("marca");
                String estado = rs.getString("estado");
                String categoria = rs.getString("categoria");
                Veiculo veiculo = new Automovel(ModeloAutomovel.gol, valorCompra, placa, ano, marca, estado, categoria);
                veiculo.setId(id);
                return veiculo;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro no banco de dados" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("erro ao fechar Statment ou fechar conexão");
            }
        }
        return null;
    }
}
