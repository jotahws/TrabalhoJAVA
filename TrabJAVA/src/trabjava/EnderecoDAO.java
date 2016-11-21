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

/**
 *
 * @author JotaWind
 */
class EnderecoDAO {

    private String insertCliente = "INSERT INTO ENDERECO (rua, cidade, bairro, numero, complemento) VALUES (?,?,?,?,?)";
    private String selectID = "SELECT idendereco ";
    private Connection con = null;
    private PreparedStatement stmt = null;

    public void inserirEndereco(Endereco endereco) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertCliente, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getNumero());
            stmt.setString(5, endereco.getComplemento());
            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int enderecoID = rs.getInt(1);
                endereco.setId(enderecoID);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar endereco: \n" + ex.getMessage());
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
