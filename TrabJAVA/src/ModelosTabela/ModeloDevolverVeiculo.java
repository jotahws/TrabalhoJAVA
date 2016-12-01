/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTabela;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trabjava.Veiculo;

/**
 *
 * @author JotaWind
 */
public class ModeloDevolverVeiculo extends AbstractTableModel {

    private String[] colunas = new String[]{"Cliente", "Placa", "Marca", "Modelo", "Ano", "Data Locação", "Preço Diária", "Dias", "Valor"};
    private List<Veiculo> lista = new ArrayList();

    public ModeloDevolverVeiculo(List<Veiculo> lista) {
        this.lista = lista;
    }

    public ModeloDevolverVeiculo() {
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        //if(column==0)
        //return false;
        //return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return veiculo.getLocacao().getCliente().getNome();//if column 0 (code)
            case 1:
                return veiculo.getPlaca();//if column 1 (name)
            case 2:
                return veiculo.getMarca().toString();//if column 2 (birthday)
            case 3:
                return new SimpleDateFormat("dd/MM/YYYY").format(veiculo.getLocacao().getData().getTime());
            case 4:
                return veiculo.getAno();
            case 5:
                return veiculo.getLocacao().getData();
            case 6:
                return veiculo.getValorDiariaLocacao();
            case 7:
                return veiculo.getLocacao().getDias();
            case 8:
                return veiculo.getLocacao().getValor();
            default:
                return null;
        }
    }

    public void setListaVeiculos(List<Veiculo> veiculos) {
        this.lista = veiculos;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size() - 1;
        if (indice < 0) {
            indice = 0;
        }
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    public Veiculo getVeiculo(int linha) {
        return lista.get(linha);
    }
}
