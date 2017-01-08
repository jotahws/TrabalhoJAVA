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
import trabjava.Motocicleta;
import trabjava.Van;
import trabjava.Categoria;
import trabjava.Marca;
import trabjava.Veiculo;
import DataAccesObject.VeiculoDAO;
import java.text.SimpleDateFormat;
import InterfacesGraficas.LocarVeiculo;

public class ModeloLocarTabela extends AbstractTableModel {

    private String[] colunas = new String[]{"Placa", "Marca", "Modelo", "Ano", "Preço Diária"};
    private List<Veiculo> lista = new ArrayList();

    public ModeloLocarTabela(List<Veiculo> lista) {
        this.lista = lista;
    }

    public ModeloLocarTabela() {
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

    public Veiculo getSelecionado(int row) {
        return lista.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = lista.get(rowIndex);
        LocarVeiculo locarInterf = new LocarVeiculo();
        String stringModelo;
        if (locarInterf.getComboTipo() == "automovel") {
            Automovel auto = (Automovel) veiculo;
            stringModelo = auto.getModelo().toString();
        } else if (locarInterf.getComboTipo() == "motocicleta") {
            Motocicleta moto = (Motocicleta) veiculo;
            stringModelo = moto.getModelo().toString();
        } else {
            Van van = (Van) veiculo;
            stringModelo = van.getModelo().toString();
        }
        switch (columnIndex) {
            case 0:
                return veiculo.getPlaca();//if column 1 (name)
            case 1:
                return veiculo.getMarca().toString();//if column 2 (birthday)
            case 2:
                return stringModelo;
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
    //        try {
    //            Veiculo veiculo = lista.get(row);
    //            switch (col) {
    //                case 0:
    //                    veiculo.setId((Long) value); //if column 0 (code)
    //                    break;
    //                case 1:
    //                    veiculo.setNome((String) value);
    //                    break;
    //                case 2:
    //                    customer.setEmail((String) value);
    //                    break;
    //                case 3:
    //                    Calendar cal = Calendar.getInstance();
    //                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    //                    Date data = format.parse((String) value);
    //                    cal.setTime(data);
    //                    customer.setDataNascimento(cal);
    //                    break;
    //                case 4:
    //                    customer.setEndereco((String) value);
    //                    break;
    //                default:
    //            }
    //            this.fireTableCellUpdated(row, col);
    //        } catch (ParseException ex) {
    //            ex.printStackTrace();
    //        }
    //    }
    //    public boolean removeContato(Contato customer) {
    //        int linha = this.lista.indexOf(customer);
    //        boolean result = this.lista.remove(customer);
    //        this.fireTableRowsDeleted(linha,linha);//update JTable
    //        return result;
    //    }
    //    public void adicionaContato(Contato customer) {
    //        this.lista.add(customer);
    //        //this.fireTableDataChanged();
    //        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    //    }

    public void setListaVeiculos(List<Veiculo> veiculos) {
        this.lista = veiculos;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
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
