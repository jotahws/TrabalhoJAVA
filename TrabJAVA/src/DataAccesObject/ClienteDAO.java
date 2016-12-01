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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabjava.Cliente;
import trabjava.Endereco;

/**
 *
 * @author JotaWind
 */
public class ClienteDAO {

    private final String insertCliente = "INSERT INTO CLIENTE (nome, sobrenome, cpf, rg, endereco) VALUES (?,?,?,?,?)";
    private final String searchCliente = "SELECT * FROM cliente WHERE idcliente=?";
    private final String listCliente = "SELECT * FROM cliente";
    private final String deleteCliente = "DELETE FROM cliente WHERE idcliente=?";
    private final String updateCliente = "UPDATE cliente SET nome=?, sobrenome=?, cpf=?, rg=? WHERE idcliente=?";
    private final String searchCliente2 = "SELECT * FROM cliente WHERE nome=? OR sobrenome=? OR cpf=?;";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirCliente(Cliente cliente){
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
                throw new RuntimeException("Erro ao fechar Statment ou Conexão: \n" + ex.getMessage());
            }
        }
    }

    public void atualizarCliente(int id, Cliente cliente){
        try {
            Endereco endereco = cliente.getEndereco();
            EnderecoDAO enderecodao = new EnderecoDAO();
            enderecodao.atualizarEndereco(endereco.getId(), endereco);
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(updateCliente);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public Cliente buscaCliente(int id){
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(searchCliente);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
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
            throw new RuntimeException("Erro ao buscar um cliente: \n" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar Statment ou Conexão: \n" + ex.getMessage());
            }
        }
        return null;
    }
    
    public List<Cliente> listaClientes(){
        try {
            List<Cliente> lista = new ArrayList();
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(listCliente);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idcliente");
                String nome = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String cpf = rs.getString("cpf");
                String rg = rs.getString("rg");
                int enderecoID = rs.getInt("endereco");
                EnderecoDAO eDAO = new EnderecoDAO();
                Endereco endereco = eDAO.buscaEndereco(enderecoID);
                Cliente cliente = new Cliente(nome, sobrenome, rg, cpf, endereco);
                cliente.setId(id);
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException ex) {
            try {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                con.close();
                stmt.close();
                rs.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }
    
    public void excluirCliente(int id){
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(deleteCliente);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally{
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
            System.out.println("Erro ao fechar parâmetros: " + ex.getMessage());
            }
        }
    }
    
    public List<Cliente> buscaClientePorNome(String nome, String sobrenome, String cpf){
        try {
            List<Cliente> lista = new ArrayList();
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(searchCliente2);
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, cpf);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idcliente");
                String nomeC = rs.getString("nome");
                String sobrenomeC = rs.getString("sobrenome");
                String cpfC = rs.getString("cpf");
                String rgC = rs.getString("rg");
                int enderecoID = rs.getInt("endereco");
                EnderecoDAO eDAO = new EnderecoDAO();
                Endereco endereco = eDAO.buscaEndereco(enderecoID);
                Cliente cliente = new Cliente(nomeC, sobrenomeC, rgC, cpfC, endereco);
                cliente.setId(id);
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
//            try {
//                con.close();
//                stmt.close();
//                rs.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        return null;
    }
}
