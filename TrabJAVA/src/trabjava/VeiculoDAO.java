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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Connection con = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public void inserirVeiculo(Veiculo veiculo) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(insertVeiculo, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, calculaValorDeCompra(veiculo.getValorParaVenda(), veiculo.getAno()));
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

    private double calculaValorDeCompra(double valorVenda, int ano) {
        Calendar c = Calendar.getInstance();
        int idade = c.get(Calendar.YEAR) - ano;
        double valorCompra = (1 - 0.15 * idade) / valorVenda;
        if (valorCompra < 0) {
            valorCompra = (valorVenda / 0.1);
            return valorCompra;
        }
        return valorCompra;
    }

    public List<Veiculo> listaVeiculosDisponiveis(String tipoB, String marcaB, String categoriaB, int opt) {
        try {
            con = new ConnectionFactory().getConnection();
            String sql;
            switch(opt){
                case 1:
                    sql = selectGenerico+tipoB+whereDisponivel+  " AND EXISTS (" +selectGenerico+tipoB+wherePorMarca+ ") AND EXISTS (" +selectGenerico+tipoB+wherePorCategoria+ ")";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, marcaB);
                    stmt.setString(2, categoriaB);
                break;
                case 2:
                    sql =selectGenerico+tipoB+whereDisponivel+ " AND EXISTS (" +selectGenerico+tipoB+wherePorMarca +")";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, marcaB);
                break;
                case 3:
                    sql =selectGenerico+tipoB+whereDisponivel+ " AND EXISTS (" +selectGenerico+tipoB+wherePorCategoria +")";
                    stmt = con.prepareStatement(sql);
                    stmt.setString(1, categoriaB);
                break;
                case 4:
                    sql = whereDisponivel;
                    stmt = con.prepareStatement(sql);
                break;
            }
            rs = stmt.executeQuery();
            List<Veiculo> lista = new ArrayList();
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
                switch(tipoB){
                    case "automovel":
                        Veiculo auto = new Automovel(idFilho,ModeloAutomovel.valueOf(modelo),valorCompra,placa,ano,Marca.valueOf(marcaV),Estado.valueOf(estado),Categoria.valueOf(categoriaV));
                        auto.setId(idVeiculo);
                        lista.add(auto);
                    break;
                    case "motocicleta":
                        Veiculo moto = new Motocicleta(idFilho,ModeloMotocicleta.valueOf(modelo),valorCompra,placa,ano,Marca.valueOf(marcaV),Estado.valueOf(estado),Categoria.valueOf(categoriaV));
                        moto.setId(idVeiculo);
                        lista.add(moto);
                    break;
                    case "van":
                        Veiculo van = new Van(idFilho,ModeloVan.valueOf(modelo),valorCompra,placa,ano,Marca.valueOf(marcaV),Estado.valueOf(estado),Categoria.valueOf(categoriaV));
                        van.setId(idVeiculo);
                        lista.add(van);
                    break;
                }
            }
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro no banco de dados" + ex.getMessage());
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("erro ao fechar Statment ou fechar conexão");
            }
        }
    }
    
    public void atualizaEstado(String Estado, int id){
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(updateEstado);
            stmt.setString(1, Estado);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Errou! " + ex.getMessage());
        } finally{
            try {
                con.close();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar parametros: " + ex.getMessage());
            }
        }
    }
}
