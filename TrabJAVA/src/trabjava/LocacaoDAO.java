/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author Gabriel
 */
public class LocacaoDAO {

    private String insertLocacao = "INSERT INTO locacao (dias, valor, data, cliente, veiculo) VALUES (?,?,?,?,?)";
    private Connection con = null;
    private PreparedStatement stmt = null;

    void inserirLocacao(Locacao locacao, Veiculo veiculo) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertLocacao, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, locacao.getDias());
            stmt.setDouble(2, locacao.getValor());
            stmt.setDate(3, new Date(locacao.getData().getTimeInMillis()));
            stmt.setInt(4, locacao.getCliente().getId());
            stmt.setInt(5, veiculo.getId());
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
