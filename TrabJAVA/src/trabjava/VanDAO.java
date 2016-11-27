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
 * @author Gabriel
 */
public class VanDAO {

    private String insertVan = "INSERT INTO van (veiculo, modelo) VALUES (?,?)";
    private Connection con = null;
    private PreparedStatement stmt = null;

    void inserirVan(Van veiculo) {
        try {
            VeiculoDAO veiculoDao = new VeiculoDAO();
            veiculoDao.inserirVeiculo(veiculo);
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertVan, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, veiculo.getId());
            stmt.setString(2, veiculo.getModelo().toString());
            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
//            if (rs.next()) {
//                final int enderecoID = rs.getInt(1);
//                veiculo.setId(enderecoID);
//            }
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

    
}
