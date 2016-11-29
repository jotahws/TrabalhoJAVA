/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JotaWind
 */
public class TrabJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("1-listar clientes\n"
                + "2-atualizar dados de cliente\n"
                + "3-Excluir clientes\n"
                + "4-incluir cliente\n"
                + "5-incluir veículo\n"
                + "6-Locar veiculo\n"
                + "7-devolver veiculo\n"
                + "8-Listar Veiculos\n");
        Scanner scn = new Scanner(System.in);
        int opc = scn.nextInt();
        switch (opc) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                inserirCliente();
                break;
            case 5:
                inserirVeiculo();
                break;
            case 6:
                locarVeiculo();
                break;
            case 7:
                break;
            case 8:
                ListarVeiculos();
                break;
        }
    }

    private static void inserirCliente() {
        Scanner scn = new Scanner(System.in);
        System.out.println("nome");
        String nome = scn.next();
        System.out.println("sobrenome");
        String sobrenome = scn.next();
        System.out.println("cpf");
        String cpf = scn.next();
        System.out.println("rg");
        String rg = scn.next();
        System.out.println("rua");
        String rua = scn.next();
        System.out.println("cidade");
        String cidade = scn.next();
        System.out.println("bairro");
        String bairro = scn.next();
        System.out.println("numero");
        String numero = scn.next();
        System.out.println("complemento");
        String complemento = scn.next();

        Endereco endereco = new Endereco(rua, cidade, bairro, numero, complemento);
        Cliente cliente = new Cliente(nome, sobrenome, cpf, rg, endereco);
        ClienteDAO clientedao = new ClienteDAO();
        clientedao.inserirCliente(cliente);
    }

    private static void inserirVeiculo() {
        System.out.println("Inserir Automovel");
        Scanner scn = new Scanner(System.in);
        System.out.println("valor compra");
        double valorCompra = scn.nextDouble();
        System.out.println("placa");
        String placa = scn.next();
        System.out.println("ano");
        int ano = scn.nextInt();
        Veiculo veiculo = new Automovel(ModeloAutomovel.AMG, valorCompra, placa, ano, Marca.HYUNDAI, Estado.DISPONIVEL, Categoria.LUXO);
        AutomovelDAO autoDao = new AutomovelDAO();
        autoDao.inserirAutomovel((Automovel) veiculo);
        
        System.out.println("Inserir Van:");
        scn = new Scanner(System.in);
        System.out.println("valor compra");
        valorCompra = scn.nextDouble();
        System.out.println("placa");
        placa = scn.next();
        System.out.println("ano");
        ano = scn.nextInt();
        veiculo = new Van(ModeloVan.DUCATO, valorCompra, placa, ano, Marca.FIAT, Estado.DISPONIVEL, Categoria.INTERMEDIARIO);
        VanDAO vanDao = new VanDAO();
        vanDao.inserirVan((Van) veiculo);
    }

    public static void locarVeiculo() {
        Veiculo veiculo; //= new Automovel(ModeloAutomovel.gol, Double.NaN, placa, 0, Marca.honda, Estado.LOCADO, Categoria.popular);
        Calendar c = Calendar.getInstance();
        c.set(2016, 11, 27);
        ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = cDAO.buscaCliente(1);
    }

    public static void ListarVeiculos() {
        VeiculoDAO veiculoDao = new VeiculoDAO();
        List<Veiculo> lista = veiculoDao.listaVeiculosDisponiveis("automovel", Marca.HONDA.toString(), Categoria.POPULAR.toString(), 1);
        for (Veiculo veiculo : lista) {
            int index = lista.indexOf(veiculo)+1;
            System.out.println("Veiculo " +index+ " = " + veiculo.getPlaca() + " " + veiculo.getMarca().toString() );
        }
        System.out.println("Qual veículo locar? ");
        Scanner scn = new Scanner(System.in);
        int indiceVeiculo = scn.nextInt()-1;
        System.out.println("Quantidade de dias? ");
        int dias = scn.nextInt();
        Veiculo veiculoLocar = lista.get(indiceVeiculo);
        Calendar data = Calendar.getInstance();
        data.set(2016, 11, 29);
        ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = cDAO.buscaCliente(3);
        veiculoLocar.locar(dias, data, cliente);
    }

}
