/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trabjava.Automovel;
import trabjava.Veiculo;
import DataAccesObject.VeiculoDAO;

public class ModeloLocarTabela extends AbstractTableModel {

    private String[] colunas = new String[]{"Placa", "Marca", "Modelo", "Ano", "Preço Diária"};
    private List<Veiculo> listaVeiculos = new ArrayList();

    public ModeloLocarTabela() throws Exception {
        VeiculoDAO veiculoDao = new VeiculoDAO();
        String tipo = new String();
        String marca = new String();
        String categoria = new String();
        int opc = 0;
        this.listaVeiculos = veiculoDao.listaVeiculosDisponiveis(tipo, marca, categoria, opc);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.listaVeiculos.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = listaVeiculos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return veiculo.getPlaca();//if column 0 (code)
            case 1:
                return veiculo.getMarca().toString();//if column 1 (name)
            case 2:
                return "olá";
            case 3:
                return veiculo.getAno();
            case 4:
                return veiculo.getValorDiariaLocacao();
            default:
                return null;
        }
    }

//    @Override
//    public void setValueAt(Object value, int row, int col) {
////        Autor autor = listaAutor.get(row);
//        Veiculo veiculo = listaVeiculos.get(row);
//        switch (col) {
//            case 0:
////                autor.setId((int) value); //if column 0 (code)
//                veiculo.setPlaca();
//                break;
//            case 1:
//                autor.setNome((String) value);
//                break;
//            default:
//        }
//        this.fireTableCellUpdated(row, col);
//    }
    @Override
    public boolean isCellEditable(int row, int column) {
//        return column == 2;
        //if(column==0)
        return false;
        //return true;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class clazz = String.class;
        switch (columnIndex) {
            case 0:
                clazz = Integer.class;
                break;
            case 1:
                clazz = String.class;
                break;
            case 2:
                clazz = Boolean.class;
                break;
        }
        return clazz;
    }

}
