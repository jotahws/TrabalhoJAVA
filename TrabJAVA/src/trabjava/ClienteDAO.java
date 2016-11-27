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
public class ClienteDAO {

    private String insertCliente = "INSERT INTO CLIENTE (nome, sobrenome, cpf, rg, endereco) VALUES (?,?,?,?,?)";
    private String selectCliente = "SELECT * FROM cliente WHERE idcliente=?";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirCliente(Cliente cliente) {
        Endereco endereco = cliente.getEndereco();
        EnderecoDAO enderecodao = new EnderecoDAO();
        enderecodao.inserirEndereco(endereco);
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertCliente, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setInt(5, endereco.getId());
            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int clienteID = rs.getInt(1);
                cliente.setId(clienteID);
            }
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
    
    public Cliente buscaCliente(int id){
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(selectCliente);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                int enderecoID = rs.getInt("endereco");
                EnderecoDAO eDAO = new EnderecoDAO();
                Endereco endereco = eDAO.buscaEndereco(enderecoID);
                Cliente cliente = new Cliente(nome, sobrenome, rg, cpf, endereco);
                cliente.setId(id);
                return cliente;
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return null;
    }
}
