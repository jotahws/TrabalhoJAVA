/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

import DataAccesObject.VeiculoDAO;
import DataAccesObject.AutomovelDAO;
import DataAccesObject.MotocicletaDAO;
import DataAccesObject.ClienteDAO;
import DataAccesObject.VanDAO;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

/**
 *
 * @author JotaWind
 */
public class TrabJAVA {

    /**
     * @param args the command line arguments
     */
    static int opc;
    
    public static void main(String[] args) {
        do{
            try {
                System.out.println("1-Listar clientes\n"
                        + "2-Atualizar dados de cliente\n"
                        + "3-Excluir cliente\n"
                        + "4-Incluir cliente\n"
                        + "5-Incluir veículo\n"
                        + "6-Locar veiculo\n"
                        + "7-Devolver veiculo\n"
                        + "8-Vender Veiculo\n"
                        + "9-Sair");
                Scanner scn = new Scanner(System.in);
                opc = scn.nextInt();
                switch (opc) {
                    case 1:
                        listaClientes();
                        System.in.read();
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
                transicao();
            } catch (IOException ex) {
                Logger.getLogger(TrabJAVA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(opc<9);
    }
    
    public static void listaClientes(){
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> lista = clienteDao.listaClientes();
        for (Cliente cliente : lista) {
            int index = lista.indexOf(cliente) + 1;
            Endereco endereco = cliente.getEndereco();
            System.out.println("Cliente " +index+ " = Nome: " +cliente.getNome() + " " + cliente.getSobrenome() + " RG: "
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
        System.out.println("Inserir Veículo:");
        Scanner scn = new Scanner(System.in);
        System.out.println("Tipo: ");
        System.out.println("1 - Automóvel");
        System.out.println("2 - Motocicleta");
        System.out.println("3 - Van");
        int tipo = scn.nextInt();
        System.out.println("valor compra");
        double valorCompra = scn.nextDouble();
        System.out.println("placa");
        String placa = scn.next();
        System.out.println("ano");
        int ano = scn.nextInt();
        System.out.println("Marca: ");
        System.out.println("1 - "+Marca.values()[0]);
        System.out.println("2 - "+Marca.values()[1]);
        System.out.println("3 - "+Marca.values()[2]);
        System.out.println("4 - "+Marca.values()[3]);
        System.out.println("5 - "+Marca.values()[4]);
        System.out.println("6 - "+Marca.values()[5]);
        String marca = Marca.values()[scn.nextInt()-1].toString();
        System.out.println("Categoria: ");
        System.out.println("1 - "+Categoria.values()[0]);
        System.out.println("2 - "+Categoria.values()[1]);
        System.out.println("3 - "+Categoria.values()[2]);
        String categoria = Categoria.values()[scn.nextInt()-1].toString();
        System.out.println("Modelo: ");
        switch(tipo){
            case 1:
                System.out.println("1 - "+ModeloAutomovel.values()[0]);
                System.out.println("2 - "+ModeloAutomovel.values()[1]);
                System.out.println("3 - "+ModeloAutomovel.values()[2]);
                System.out.println("4 - "+ModeloAutomovel.values()[3]);
                System.out.println("5 - "+ModeloAutomovel.values()[4]);
                System.out.println("6 - "+ModeloAutomovel.values()[5]);
                System.out.println("7 - "+ModeloAutomovel.values()[6]);
                System.out.println("8 - "+ModeloAutomovel.values()[7]);
                System.out.println("9 - "+ModeloAutomovel.values()[8]);
                System.out.println("10 - "+ModeloAutomovel.values()[9]);
                String modeloA = ModeloAutomovel.values()[scn.nextInt()-1].toString();
                Veiculo veiculoA = new Automovel(ModeloAutomovel.valueOf(modeloA), valorCompra, placa, ano, Marca.valueOf(marca), Estado.DISPONIVEL, Categoria.valueOf(categoria));
                AutomovelDAO autoDao = new AutomovelDAO();
                autoDao.inserirAutomovel((Automovel) veiculoA);
            break;
            case 2:
                System.out.println("1 - "+ModeloMotocicleta.values()[0]);
                System.out.println("2 - "+ModeloMotocicleta.values()[1]);
                System.out.println("3 - "+ModeloMotocicleta.values()[2]);
                System.out.println("4 - "+ModeloMotocicleta.values()[3]);
                String modeloM = ModeloMotocicleta.values()[scn.nextInt()-1].toString();
                Veiculo veiculoM = new Motocicleta(ModeloMotocicleta.valueOf(modeloM), valorCompra, placa, ano, Marca.valueOf(marca), Estado.DISPONIVEL, Categoria.valueOf(categoria));
                MotocicletaDAO motoDao = new MotocicletaDAO();
                motoDao.inserirMotocicleta((Motocicleta) veiculoM);
            break;
            case 3:
                System.out.println("1 - "+ModeloVan.values()[0]);
                System.out.println("2 - "+ModeloVan.values()[1]);
                System.out.println("3 - "+ModeloVan.values()[2]);
                System.out.println("4 - "+ModeloVan.values()[3]);
                String modeloV = ModeloVan.values()[scn.nextInt()-1].toString();
                Veiculo veiculoV = new Van(ModeloVan.valueOf(modeloV), valorCompra, placa, ano, Marca.valueOf(marca), Estado.DISPONIVEL, Categoria.valueOf(categoria));
                VanDAO vanDao = new VanDAO();
                vanDao.inserirVan((Van) veiculoV);
            break;
        }
    }

    public static void locarVeiculo() {
        String nome = "";
        String sobrenome = "";
        String cpf = "";
        System.out.println("Escolha um cliente: ");
        System.out.println("1 - Por nome");
        System.out.println("2 - Por sobrenome");
        System.out.println("3 - Por cpf");
        Scanner scn = new Scanner(System.in);
        int busc = scn.nextInt();
        switch (busc){
            case 1:
                System.out.println("Digite um nome: ");
                nome = scn.next();
            break;
            case 2:
                System.out.println("Digite um sobrenome: ");
                sobrenome = scn.next();
            break;
            case 3:
                System.out.println("Digite um cpf: ");
                cpf = scn.next();
            break;
        }
        ClienteDAO cDAO = new ClienteDAO();
        List<Cliente> listaC = cDAO.buscaClientePorNome(nome, sobrenome, cpf);
        for (Cliente cliente : listaC){
            int index = listaC.indexOf(cliente)+1;
            System.out.println("Cliente " + index + " = " + cliente.getNome() + cliente.getSobrenome() + " CPF: "
                    + cliente.getCpf());
        }
        System.out.println("Qual cliente irá locar o veículo?");
        int indiceCliente = scn.nextInt()-1;
        Cliente cliente = listaC.get(indiceCliente);
        VeiculoDAO veiculoDao = new VeiculoDAO();
        List<Veiculo> listaV = veiculoDao.listaVeiculosDisponiveis("automovel", "CHEVROLET", null, 2);
        for (Veiculo veiculo : listaV) {
            int index = listaV.indexOf(veiculo) + 1;
            int tipo = veiculoDao.descobreTipo(veiculo.getId());
            String modelo = "";
            switch (tipo){
                case 1:
                    Automovel auto = (Automovel) veiculo;
                    modelo = auto.getModelo().toString();
                break;
                case 2:
                    Motocicleta moto = (Motocicleta) veiculo;
                    modelo = moto.getModelo().toString();
                break;
                case 3:
                    Van van = (Van) veiculo;
                    modelo = van.getModelo().toString();
            }
            System.out.println("Veiculo " + index + " = " + veiculo.getPlaca() + " " + veiculo.getMarca().toString() + " "
                    + modelo + " " + veiculo.getAno() + " " + veiculo.getValorDiariaLocacao());
        }
        System.out.println("Qual veículo locar? ");
        int indiceVeiculo = scn.nextInt() - 1;
        System.out.println("Quantidade de dias? ");
        int dias = scn.nextInt();
        Veiculo veiculoLocar = listaV.get(indiceVeiculo);
        Calendar data = Calendar.getInstance();
        data.set(2016, 12, 01);
        veiculoLocar.locar(dias, data, cliente);
    }
    
    public static void devolverVeiculo(){
        VeiculoDAO veiculoDao = new VeiculoDAO();
        List<Veiculo> lista = veiculoDao.listaVeiculoLocados();
        for (Veiculo veiculo : lista) {
            int index = lista.indexOf(veiculo) + 1;
            int tipo = veiculoDao.descobreTipo(veiculo.getId());
            String modelo = "";
            switch (tipo){
                case 1:
                    Automovel auto = (Automovel) veiculo;
                    modelo = auto.getModelo().toString();
                break;
                case 2:
                    Motocicleta moto = (Motocicleta) veiculo;
                    modelo = moto.getModelo().toString();
                break;
                case 3:
                    Van van = (Van) veiculo;
                    modelo = van.getModelo().toString();
            }
            System.out.println("Veiculo " + index + " = Cliente: " + veiculo.getLocacao().getCliente().getNome() + " Placa: "
                    + veiculo.getPlaca() + " Marca: " + veiculo.getMarca().toString() + " Modelo: " + modelo+ " Ano: " 
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
            int tipo = veiculoDao.descobreTipo(veiculo.getId());
            String modelo = "";
            switch (tipo){
                case 1:
                    Automovel auto = (Automovel) veiculo;
                    modelo = auto.getModelo().toString();
                break;
                case 2:
                    Motocicleta moto = (Motocicleta) veiculo;
                    modelo = moto.getModelo().toString();
                break;
                case 3:
                    Van van = (Van) veiculo;
                    modelo = van.getModelo().toString();
            }
            System.out.println("Veiculo " + index + " = " + veiculo.getPlaca() + " " + veiculo.getMarca().toString() + " "
                    + modelo + " " + veiculo.getAno() + " " + veiculo.getValorParaVenda());
        }
        System.out.println("Qual veículo vender? ");
        Scanner scn = new Scanner(System.in);
        int indiceVeiculo = scn.nextInt() - 1;
        Veiculo veiculoVender = lista.get(indiceVeiculo);
        veiculoVender.vender();
    }
    
    public static void transicao(){
        try {
            sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TrabJAVA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
