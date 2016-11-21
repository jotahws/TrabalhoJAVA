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

/**
 *
 * @author JotaWind
 */
public class VeiculoDAO {

    private String insertCliente = "INSERT INTO CLIENTE (nome, sobrenome, cpf, rg, endereco) VALUES (?,?,?,?,?)";
    private Connection con = null;
    private PreparedStatement stmt = null;

    public void inserirVeiculo(Veiculo veiculo) {
        Endereco endereco = veiculo.getEndereco();
        EnderecoDAO enderecodao = new EnderecoDAO();
        enderecodao.inserirEndereco(endereco);
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertCliente);
            stmt.setString(1, veiculo.getNome());
            stmt.setString(2, veiculo.getSobrenome());
            stmt.setString(3, veiculo.getCpf());
            stmt.setString(4, veiculo.getRg());
            stmt.setInt(5, endereco.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar cliente: \n" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar Statment ou fechar conexão");
            }
        }
    }
}
