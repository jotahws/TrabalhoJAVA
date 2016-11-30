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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class LocacaoDAO {

    private String insertLocacao = "INSERT INTO locacao (dias, valor, data, cliente, veiculo) VALUES (?,?,?,?,?)";
    private String selectLocacao = "SELECT * FROM locacao";
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirLocacao(Locacao locacao, Veiculo veiculo) {
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
            if (rs.next()) {
                final int locacaoID = rs.getInt(1);
                locacao.setId(locacaoID);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao criar locação: \n" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar Statment ou Conexão: \n" + ex.getMessage());
            }
        }
    }

//    public List<Locacao> listaLocacao() {
//        try {
//            List<Locacao> lista = new ArrayList();
//            con = new ConnectionFactory().getConnection();
//            stmt = con.prepareStatement(selectLocacao);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int locacaoID = rs.getInt("idlocacao");
//                int dias = rs.getInt("dias");
//                double valor = rs.getDouble("valor");
//                Calendar data = Calendar.getInstance();
//                data.setTime(rs.getDate("data"));
//                int idCliente = rs.getInt("cliente");
//                ClienteDAO clienteDao = new ClienteDAO();
//                Cliente cliente = clienteDao.buscaCliente(idCliente);
//                Locacao locacao = new Locacao(dias, valor, data, cliente);
//                locacao.setId(locacaoID);
//                lista.add(locacao);
//            }
//            return lista;
//        } catch (SQLException ex) {
//            throw new RuntimeException("Erro ao listar locações: \n" + ex.getMessage());
//        } finally {
//            try {
//                stmt.close();
//                con.close();
//            } catch (SQLException ex) {
//                throw new RuntimeException("Erro ao fechar Statment ou Conexão: \n" + ex.getMessage());
//            }
//        }
//    }

}
