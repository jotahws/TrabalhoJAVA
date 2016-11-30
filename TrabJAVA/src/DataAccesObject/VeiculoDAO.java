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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabjava.Automovel;
import trabjava.Categoria;
import trabjava.Estado;
import trabjava.Locacao;
import trabjava.Marca;
import trabjava.ModeloAutomovel;
import trabjava.ModeloMotocicleta;
import trabjava.ModeloVan;
import trabjava.Motocicleta;
import trabjava.Van;
import trabjava.Veiculo;

/**
 *
 * @author JotaWind
 */
public class VeiculoDAO {

    private final String insertVeiculo = "INSERT INTO VEICULO (valor_compra, placa, ano, "
            + " marca, estado, categoria) VALUES (?,?,?,?,?,?)";
    private final String whereDisponivel = " B WHERE V.idveiculo=B.veiculo"
            + " and v.estado = 'DISPONIVEL' ";
    private final String wherePorMarca = " B WHERE V.idveiculo=B.veiculo"
            + " and v.marca=? ";
    private final String wherePorCategoria = " B WHERE V.idveiculo=B.veiculo "
            + " and v.categoria=? ";
    private final String selectGenerico = "SELECT * FROM veiculo V, ";
    private final String updateEstado = "UPDATE veiculo SET estado=? WHERE idveiculo=?";
    private final String selectLocadoAuto = "SELECT * FROM veiculo V, automovel A WHERE estado='LOCADO' AND V.idveiculo=A.veiculo";
    private final String selectLocadoVan = "SELECT * FROM veiculo V, van K WHERE estado='LOCADO' AND V.idveiculo=K.veiculo";
    private final String selectLocadoMoto = "SELECT * FROM veiculo V, motocicleta M WHERE estado='LOCADO' AND V.idveiculo=M.veiculo";
    
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirVeiculo(Veiculo veiculo) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertVeiculo, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, veiculo.getValorDeCompra());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getAno());
            stmt.setString(4, veiculo.getMarca().toString());
            stmt.setString(5, veiculo.getEstado().toString());
            stmt.setString(6, veiculo.getCategoria().toString());
            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int veiculoID = rs.getInt(1);
                veiculo.setId(veiculoID);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir Veículo: \n" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar Statment ou Conexão: \n" + ex.getMessage());
            }
        }
    }
    
    public List<Veiculo> listaVeiculoLocados(){
        try {
            List<Veiculo> lista = new ArrayList();
            LocacaoDAO locDAO = new LocacaoDAO();
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(selectLocadoAuto);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idVeiculo = rs.getInt("idveiculo");
                double valorCompra = rs.getDouble("valor_compra");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                String marcaV = rs.getString("marca");
                String estado = rs.getString("estado");
                String categoriaV = rs.getString("categoria");
                int idFilho = rs.getInt(8);
                String modelo = rs.getString("modelo");
                Veiculo auto = new Automovel(idFilho, ModeloAutomovel.valueOf(modelo), valorCompra, placa, ano, Marca.valueOf(marcaV), Estado.valueOf(estado), Categoria.valueOf(categoriaV));
                Locacao locacao = locDAO.buscaLocacao(idVeiculo);
                auto.setLocacao(locacao);
                auto.setId(idVeiculo);
                lista.add(auto);
            }
            stmt = con.prepareStatement(selectLocadoMoto);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idVeiculo = rs.getInt("idveiculo");
                double valorCompra = rs.getDouble("valor_compra");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                String marcaV = rs.getString("marca");
                String estado = rs.getString("estado");
                String categoriaV = rs.getString("categoria");
                int idFilho = rs.getInt(8);
                String modelo = rs.getString("modelo");
                Veiculo moto = new Motocicleta(idFilho, ModeloMotocicleta.valueOf(modelo), valorCompra, placa, ano, Marca.valueOf(marcaV), Estado.valueOf(estado), Categoria.valueOf(categoriaV));
                Locacao locacao = locDAO.buscaLocacao(idVeiculo);
                moto.setLocacao(locacao);
                moto.setId(idVeiculo);
                lista.add(moto);
            }
            stmt = con.prepareStatement(selectLocadoVan);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idVeiculo = rs.getInt("idveiculo");
                double valorCompra = rs.getDouble("valor_compra");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                String marcaV = rs.getString("marca");
                String estado = rs.getString("estado");
                String categoriaV = rs.getString("categoria");
                int idFilho = rs.getInt(8);
                String modelo = rs.getString("modelo");Veiculo van = new Van(idFilho, ModeloVan.valueOf(modelo), valorCompra, placa, ano, Marca.valueOf(marcaV), Estado.valueOf(estado), Categoria.valueOf(categoriaV));
                Locacao locacao = locDAO.buscaLocacao(idVeiculo);
                van.setLocacao(locacao);
                van.setId(idVeiculo);
                lista.add(van);
            }
            return lista;
        } catch (SQLException ex) {
            try {
                System.out.println("Erro: " + ex.getMessage());
                stmt.close();
                con.close();
                rs.close();
            } catch (SQLException ex1) {
                System.out.println("Erro no encerramento dos parâmetros: " + ex1.getMessage());
            }
        }
        return null;
    }
    
    public List<Veiculo> listaVeiculosDisponiveis(String tipoB, String marcaB, String categoriaB, int opt) {
        try {
            con = new ConnectionFactory().getConnection();
            String sql;
            switch (opt) {
                case 1:
                    sql = selectGenerico + tipoB + whereDisponivel + " AND EXISTS (" + selectGenerico + tipoB + wherePorMarca + ") AND EXISTS (" + selectGenerico + tipoB + wherePorCategoria + ")";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, marcaB);
                    stmt.setString(2, categoriaB);
                    break;
                case 2:
                    sql = selectGenerico + tipoB + whereDisponivel + " AND EXISTS (" + selectGenerico + tipoB + wherePorMarca + ")";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, marcaB);
                    break;
                case 3:
                    sql = selectGenerico + tipoB + whereDisponivel + " AND EXISTS (" + selectGenerico + tipoB + wherePorCategoria + ")";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, categoriaB);
                    break;
                case 4:
                    sql = selectGenerico+tipoB+whereDisponivel;
                    stmt = con.prepareStatement(sql);
                    break;
            }
            rs = stmt.executeQuery();
            List<Veiculo> lista = new ArrayList();
            while (rs.next()) {
                int idVeiculo = rs.getInt("idveiculo");
                double valorCompra = rs.getDouble("valor_compra");
                String placa = rs.getString("placa");
                int ano = rs.getInt("ano");
                String marcaV = rs.getString("marca");
                String estado = rs.getString("estado");
                String categoriaV = rs.getString("categoria");
                int idFilho = rs.getInt(8);
                String modelo = rs.getString("modelo");
                switch (tipoB) {
                    case "automovel":
                        Veiculo auto = new Automovel(idFilho, ModeloAutomovel.valueOf(modelo), valorCompra, placa, ano, Marca.valueOf(marcaV), Estado.valueOf(estado), Categoria.valueOf(categoriaV));
                        auto.setId(idVeiculo);
                        lista.add(auto);
                        break;
                    case "motocicleta":
                        Veiculo moto = new Motocicleta(idFilho, ModeloMotocicleta.valueOf(modelo), valorCompra, placa, ano, Marca.valueOf(marcaV), Estado.valueOf(estado), Categoria.valueOf(categoriaV));
                        moto.setId(idVeiculo);
                        lista.add(moto);
                        break;
                    case "van":
                        Veiculo van = new Van(idFilho, ModeloVan.valueOf(modelo), valorCompra, placa, ano, Marca.valueOf(marcaV), Estado.valueOf(estado), Categoria.valueOf(categoriaV));
                        van.setId(idVeiculo);
                        lista.add(van);
                        break;
                }
            }
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao lista veículos Disponíveis \n" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar Statment ou Conexão: \n" + ex.getMessage());
            }
        }
    }

    public void atualizaEstado(String Estado, int id) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(updateEstado);
            stmt.setString(1, Estado);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar estado do Veículo \n" + ex.getMessage());
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar Statment ou Conexão: \n" + ex.getMessage());
            }
        }
    }
    
    public int descobreTipo(int idveiculo){
        AutomovelDAO autoDAO = new AutomovelDAO();
        MotocicletaDAO motoDAO = new MotocicletaDAO();
        VanDAO vanDAO = new VanDAO();
        if (autoDAO.isAuto(idveiculo))
            return 1;
        else if (motoDAO.isMoto(idveiculo))
            return 2;
        else if (vanDAO.isVan(idveiculo))
            return 3;
        else
            return 0;
    }
}
