/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

import DataAccesObject.VeiculoDAO;
import DataAccesObject.AutomovelDAO;
import DataAccesObject.ClienteDAO;
import DataAccesObject.VanDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
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
        System.out.println("1-Listar clientes\n"
                + "2-Atualizar dados de cliente\n"
                + "3-Excluir cliente\n"
                + "4-Incluir cliente\n"
                + "5-Incluir veículo\n"
                + "6-Locar veiculo\n"
                + "7-Devolver veiculo\n"
                + "8-Vender Veiculo\n");
        Scanner scn = new Scanner(System.in);
        int opc = scn.nextInt();
        switch (opc) {
            case 1:
                listaClientes();
                break;
            case 2:
                atualizarCliente();
                break;
            case 3:
                excluirCliente();
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
                devolverVeiculo();
                break;
            case 8:
                venderVeiculo();
                break;
        }
    }
    
    public static void listaClientes(){
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> lista = clienteDao.listaClientes();
        for (Cliente cliente : lista) {
            int index = lista.indexOf(cliente) + 1;
            Endereco endereco = cliente.getEndereco();
            System.out.println("Cliente " +index+ " = Nome: " +cliente.getNome() + " " + cliente.getSobrenome() +" RG: "
                    + cliente.getRg() + " CPF: " + cliente.getCpf() + " Rua: " + endereco.getRua() + " Numero: "
                    + endereco.getNumero() + " Complemento: " + endereco.getComplemento() + " Bairro: " + endereco.getBairro()
                    + " Cidade: " + endereco.getCidade());
        }
    }

    public static void atualizarCliente(){
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> lista = clienteDao.listaClientes();
        for (Cliente cliente : lista) {
            int index = lista.indexOf(cliente) + 1;
            Endereco endereco = cliente.getEndereco();
            System.out.println("Cliente " +index+ " = Nome: " +cliente.getNome() + " " + cliente.getSobrenome() +" RG: "
                    + cliente.getRg() + " CPF: " + cliente.getCpf() + " Rua: " + endereco.getRua() + " Numero: "
                    + endereco.getNumero() + " Complemento: " + endereco.getComplemento() + " Bairro: " + endereco.getBairro()
                    + " Cidade: " + endereco.getCidade());
        }
        System.out.println("Qual cliente atualizar?");
        Scanner scn = new Scanner(System.in);
        int indiceCliente = scn.nextInt() - 1;
        int idCliente = lista.get(indiceCliente).getId();
        int idEndereco = lista.get(indiceCliente).getEndereco().getId();
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
        endereco.setId(idEndereco);
        Cliente cliente = new Cliente(nome, sobrenome, cpf, rg, endereco);
        cliente.setId(idCliente);
        clienteDao.atualizarCliente(cliente.getId(), cliente);
    }
    
    public static void excluirCliente(){
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> lista = clienteDao.listaClientes();
        for (Cliente cliente : lista) {
            int index = lista.indexOf(cliente) + 1;
            Endereco endereco = cliente.getEndereco();
            System.out.println("Cliente " +index+ " = Nome: " +cliente.getNome() + " " + cliente.getSobrenome() +" RG: "
                    + cliente.getRg() + " CPF: " + cliente.getCpf() + " Rua: " + endereco.getRua() + " Numero: "
                    + endereco.getNumero() + " Complemento: " + endereco.getComplemento() + " Bairro: " + endereco.getBairro()
                    + " Cidade: " + endereco.getCidade());
        }
        System.out.println("Qual cliente deletar?");
        Scanner scn = new Scanner(System.in);
        int indexCliente = scn.nextInt() - 1;
        clienteDao.excluirCliente(lista.get(indexCliente).getId());
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
        System.out.println("Inserir Automovel:");
        Scanner scn = new Scanner(System.in);
        System.out.println("valor compra");
        double valorCompra = scn.nextDouble();
        System.out.println("placa");
        String placa = scn.next();
        System.out.println("ano");
        int ano = scn.nextInt();
        Veiculo veiculo = new Automovel(ModeloAutomovel.AMGGT, valorCompra, placa, ano, Marca.HYUNDAI, Estado.DISPONIVEL, Categoria.LUXO);
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
        veiculo = new Van(ModeloVan.Ducato, valorCompra, placa, ano, Marca.FIAT, Estado.DISPONIVEL, Categoria.INTERMEDIARIO);
        VanDAO vanDao = new VanDAO();
        vanDao.inserirVan((Van) veiculo);
    }

    public static void locarVeiculo() {
        VeiculoDAO veiculoDao = new VeiculoDAO();
        List<Veiculo> lista = veiculoDao.listaVeiculosDisponiveis("van", null, null, 4);
        for (Veiculo veiculo : lista) {
            int index = lista.indexOf(veiculo) + 1;
            System.out.println("Veiculo " + index + " = " + veiculo.getPlaca() + " " + veiculo.getMarca().toString());
        }
        System.out.println("Qual veículo locar? ");
        Scanner scn = new Scanner(System.in);
        int indiceVeiculo = scn.nextInt() - 1;
        System.out.println("Quantidade de dias? ");
        int dias = scn.nextInt();
        Veiculo veiculoLocar = lista.get(indiceVeiculo);
        Calendar data = Calendar.getInstance();
        data.set(2016, 11, 29);
        ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = cDAO.buscaCliente(3);
        veiculoLocar.locar(dias, data, cliente);
    }
    
    public static void devolverVeiculo(){
        VeiculoDAO veiculoDao = new VeiculoDAO();
        List<Veiculo> lista = veiculoDao.listaVeiculoLocados();
        for (Veiculo veiculo : lista) {
            int index = lista.indexOf(veiculo) + 1;
            System.out.println("Veiculo " + index + " = Cliente: " + veiculo.getLocacao().getCliente().getNome() + " Placa: "
                    + veiculo.getPlaca() + " Marca: " + veiculo.getMarca().toString() + " Modelo: Não sei botá Ano: " 
                    + veiculo.getAno() + " Data Locação: " + veiculo.getLocacao().getData().getCalendarType() + " Preço Diária: "
                    + veiculo.getValorDiariaLocacao() + " Quantidade de dias locado: " + veiculo.getLocacao().getDias() +
                    " Valor Locação: " + veiculo.getLocacao().getValor());
        }
        System.out.println("Qual veículo devolver? ");
        Scanner scn = new Scanner(System.in);
        int indiceVeiculo = scn.nextInt() - 1;
        Veiculo veiculoDevolver = lista.get(indiceVeiculo);
        veiculoDevolver.devolver();
    }
    
    public static void venderVeiculo(){ 
        VeiculoDAO veiculoDao = new VeiculoDAO();
        List<Veiculo> lista = veiculoDao.listaVeiculosDisponiveis("automovel", Marca.HONDA.toString(), Categoria.POPULAR.toString(), 3);
        for (Veiculo veiculo : lista) {
            int index = lista.indexOf(veiculo) + 1;
            Automovel auto = (Automovel) veiculo;
            auto.getModelo();
            System.out.println("Veiculo " + index + " = " + veiculo.getPlaca() + " " + veiculo.getMarca().toString());
        }
        System.out.println("Qual veículo vender? ");
        Scanner scn = new Scanner(System.in);
        int indiceVeiculo = scn.nextInt() - 1;
        Veiculo veiculoVender = lista.get(indiceVeiculo);
        veiculoVender.vender();
    }
    
}
