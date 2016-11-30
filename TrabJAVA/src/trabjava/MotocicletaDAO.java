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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class MotocicletaDAO {

    private final String insertMotocicleta = "INSERT INTO MOTOCICLETA (VEICULO, MODELO) VALUES (?,?)";
    private final String searchMotocicleta = "SELECT * FROM motocicleta WHERE veiculo=?";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirMotocicleta(Motocicleta veiculo) {
        try {
            VeiculoDAO veiculoDao = new VeiculoDAO();
            veiculoDao.inserirVeiculo(veiculo);
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertMotocicleta, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, veiculo.getId());
            stmt.setString(2, veiculo.getModelo().toString());
            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
//            if (rs.next()) {
//                final int enderecoID = rs.getInt(1);
//                veiculo.setId(enderecoID);
//            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir Motocicleta: \n" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar Statment ou Conexão: \n" + ex.getMessage());
            }
        }
    }
    
    public boolean isMoto(int idveiculo){
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(searchMotocicleta);
            stmt.setInt(1, idveiculo);
            rs = stmt.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            try {
                Logger.getLogger(VanDAO.class.getName()).log(Level.SEVERE, null, ex);
                con.close();
                stmt.close();
                rs.close();
            } catch (SQLException ex1) {
                Logger.getLogger(AutomovelDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

}
