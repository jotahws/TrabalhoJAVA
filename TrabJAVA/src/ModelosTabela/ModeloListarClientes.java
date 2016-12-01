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
import trabjava.Cliente;

public class ModeloListarClientes extends AbstractTableModel {

    private String[] colunas = new String[]{"Nome", "Sobrenome", "RG", "CPF", "Endereço"};
    private List<Cliente> lista = new ArrayList();

    public ModeloListarClientes(List<Cliente> lista) {
        this.lista = lista;
    }

    public ModeloListarClientes() {
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

    public Cliente getSelecionado(int row) {
        return lista.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cliente.getNome();//if column 1 (name)
            case 1:
                return cliente.getSobrenome();//if column 2 (birthday)
            case 2:
                return cliente.getRg();
            case 3:
                return cliente.getCpf();
            case 4:
                return cliente.getEndereco().getCidade() + cliente.getEndereco().getBairro() + cliente.getEndereco().getRua() + cliente.getEndereco().getNumero();
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

    public void setListaClientes(List<Cliente> cliente) {
        this.lista = cliente;
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

    public Cliente getVeiculo(int linha) {
        return lista.get(linha);
    }

}
