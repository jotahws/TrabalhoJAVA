/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccesObject;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabjava.Automovel;

/**
 *
 * @author Gabriel
 */
public class AutomovelDAO {

    private final String insertAutomovel = "INSERT INTO automovel (veiculo, modelo) VALUES (?,?)";
    private final String searchAutomovel = "SELECT * FROM automovel WHERE veiculo=?";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirAutomovel(Automovel veiculo) {
        try {
            VeiculoDAO veiculoDao = new VeiculoDAO();
            veiculoDao.inserirVeiculo(veiculo);
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertAutomovel, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, veiculo.getId());
            stmt.setString(2, veiculo.getModelo().toString());
            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
//            if (rs.next()) {
//                final int enderecoID = rs.getInt(1);
//                veiculo.setId(enderecoID);
//            }
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Automóvel: " + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar parâmetros: " + ex.getMessage());
            }
        }
    }

    public boolean isAuto(int idveiculo) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(searchAutomovel);
            stmt.setInt(1, idveiculo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao identificar veiculo: " + ex.getMessage());
        } finally {
            try {
                con.close();
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar parâmetros: " + ex.getMessage());
            }
        }
        return false;
    }

//    public void buscaAutomovel(int id) {
//        try {
//            con = new ConnectionFactory().getConnection();
//            stmt = con.prepareStatement(selectAutomovelID);
//            stmt.setInt(1, id);
//            rs = stmt.executeQuery();
//            if (rs.next()) {
//                int veiculo = rs.getInt("veiculo");
//                String modelo = rs.getString("modelo");
//                VeiculoDAO veiculoDao = new VeiculoDAO();
////                Veiculo veiculo = new Automovel();
////                endereco.setId(id);
////                return endereco;
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException("Erro ao buscar um Automóvel: \n" + ex.getMessage());
//        } finally {
//            try {
//                stmt.close();
//                con.close();
//            } catch (SQLException ex) {
//                throw new RuntimeException("Erro ao fechar Statment ou fechar conexão\n " + ex.getMessage());
//            }
//        }
//    }
}
