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
 * @author JotaWind
 */
class EnderecoDAO {

    private String insertEndereco = "INSERT INTO ENDERECO (rua, cidade, bairro, numero, complemento) VALUES (?,?,?,?,?)";
    private String selectEndereco = "SELECT * FROM endereco WHERE idendereco=? ";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirEndereco(Endereco endereco) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertEndereco, Statement.RETURN_GENERATED_KEYS);
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
    public Endereco buscaEndereco(int id){
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(selectEndereco);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                String rua = rs.getString("rua");
                String cidade = rs.getString("cidade");
                String bairro = rs.getString("bairro");
                String numero = rs.getString("numero");
                String complemento = rs.getString("complemento");
                Endereco endereco = new Endereco(rua,cidade,bairro,numero,complemento);
                endereco.setId(id);
                return endereco;
            }
        } catch (SQLException ex) {
            System.out.println("Erro");
        }
        return null;
    }
}
