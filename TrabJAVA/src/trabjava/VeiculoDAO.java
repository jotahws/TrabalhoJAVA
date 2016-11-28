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
            + "marca, estado, categoria) VALUES (?,?,?,?,?,?)";
    private final String selectVeiculoID = "SELECT * FROM VEICULO WHERE IDVEICULO=?";
    private final String selectDisponivel = "SELECT * FROM veiculo, ? WHERE veiculo.idveiculo=?.veiculo"
            + "and veiculo.estado = 'DISPONIVEL'";
    private final String selectPorMarca = "SELECT * FROM veiculo, ? WHERE veiculo.idveiculo=?.veiculo"
            + "and veiculo.marca=? ";
    private final String selectPorCategoria = "SELECT * FROM veiculo, ? WHERE veiculo.idveiculo=?.veiculo "
            + "and veiculo.categoria=? ";
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

    public List<Veiculo> listaVeiculosDisponiveis(String tipoB, String marcaB, String categoriaB) {
        try {
            con = new ConnectionFactory().getConnection();
            int opt = 0;
            String sql;
            switch(opt){
                case 1:
                    sql = selectDisponivel + " INTERSECT " + selectPorMarca + " INTERSECT " + selectPorCategoria;
                    stmt = con.prepareStatement(sql);
                    stmt.setString(3, tipoB);
                    stmt.setString(4, tipoB);
                    stmt.setString(5, marcaB);
                    stmt.setString(6, tipoB);
                    stmt.setString(7, tipoB);
                    stmt.setString(8, categoriaB);
                break;
                case 2:
                    sql = selectDisponivel + " INTERSECT " + selectPorMarca;
                    stmt = con.prepareStatement(sql);
                    stmt.setString(3, tipoB);
                    stmt.setString(4, tipoB);
                    stmt.setString(5, marcaB);
                break;
                case 3:
                    sql = selectDisponivel + " INTERSECT " + selectPorCategoria;
                    stmt = con.prepareStatement(sql);
                    stmt.setString(3, tipoB);
                    stmt.setString(4, tipoB);
                    stmt.setString(5, categoriaB);
                break;
                case 4:
                    sql = selectDisponivel;
                    stmt = con.prepareStatement(sql);
                break;
            }
            stmt.setString(1, tipoB);
            stmt.setString(2, tipoB);
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
                    case "Automovel":
                        Veiculo auto = new Automovel(idFilho,ModeloAutomovel.valueOf(modelo),valorCompra,placa,ano,Marca.valueOf(marcaV),Estado.valueOf(estado),Categoria.valueOf(categoriaV));
                        auto.setId(idVeiculo);
                        lista.add(auto);
                    break;
                    case "Motocicleta":
                        Veiculo moto = new Motocicleta(idFilho,ModeloMotocicleta.valueOf(modelo),valorCompra,placa,ano,Marca.valueOf(marcaV),Estado.valueOf(estado),Categoria.valueOf(categoriaV));
                        moto.setId(idVeiculo);
                        lista.add(moto);
                    break;
                    case "Van":
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
