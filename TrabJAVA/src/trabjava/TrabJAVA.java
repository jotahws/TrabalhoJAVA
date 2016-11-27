/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabjava;

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
                + "7-devolver veiculo\n");
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
                try{
                inserirVeiculo();
                } catch(NullPointerException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case 6:
                break;
            case 7:
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
        Scanner scn = new Scanner(System.in);
        System.out.println("valor compra");
        double valorCompra = scn.nextDouble();
        System.out.println("placa");
        String placa = scn.next();
        System.out.println("ano");
        int ano = scn.nextInt();
        
        Veiculo veiculo = new Automovel(ModeloAutomovel.celta, valorCompra, placa, ano, Marca.honda, Estado.LOCADO, Categoria.POPULAR);
        AutomovelDAO autoDao = new AutomovelDAO();
        autoDao.inserirAutomovel((Automovel)veiculo);
        
        scn = new Scanner(System.in);
        System.out.println("valor compra");
        valorCompra = scn.nextDouble();
        System.out.println("placa");
        placa = scn.next();
        System.out.println("ano");
        ano = scn.nextInt();
        
        veiculo = new Van(ModeloVan.kombi, valorCompra, placa, ano, Marca.honda, Estado.LOCADO, Categoria.POPULAR);
        VanDAO vanDao = new VanDAO();
        vanDao.inserirVan((Van)veiculo);
    }

}