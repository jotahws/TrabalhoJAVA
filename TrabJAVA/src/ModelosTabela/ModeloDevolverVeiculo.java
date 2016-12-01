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
