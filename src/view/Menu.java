package view;

import java.io.IOException;
import java.util.ArrayList;

import Controller.GerenciadorAdvogados;
import Controller.GerenciadorCasos;
import Controller.GerenciadorCliente;
import Controller.GerenciadorSecretarias;
import Controller.ListaAdvogado;
import Controller.ListaCases;
import Controller.ListaClientes;
import Controller.ListaSecretarias;
import model.Case;
import model.Client;
import model.Lawyer;
import model.Secretary;

public class Menu {
	
	static ArrayList<Lawyer> listaAdvogados = ListaAdvogado.getListaAdvogados();
	static ArrayList<Client> listaClientes = ListaClientes.getListaClientes();
	static ArrayList<Case> listaCasos = ListaCases.getListaCases();
	static ArrayList<Secretary> listaSecr = ListaSecretarias.getListaSecretarias();
	
	public static void executarSistema() throws IOException {
		
		while (true) {
		
			exibirMenu();
			int op = Console.lerInt("Informe uma opção: ");
			verificarOpção(op);
			
		}	
		
	}
	
   
    private static void exibirMenu() {
    	   
    	  System.out.println("""
                             Sistema Basico advocacia - Menu
                             1) Menu de Cadastros
                             2) Menu de Listagens
                             3) Menu de buscas
                             4) Menu de atualiza\u00e7\u00e3o de dados
                             0) Sair""");
    
     }
    	   
    	   
      private static void verificarOpção(int op) {
    	  
    	  switch (op) {
	          case 1 -> menuCadastro();
	          case 2 -> menuListagens();
	          case 3 -> menuBuscas();
	          case 4 -> menuAtualizarDados();
	          case 5 -> buscarAdvogado();
	          case 0 -> {
                      System.out.println("\nO Sistema foi finalizado...\n");
                      System.exit(0);
                }
	              
	          default -> System.out.println("Opção inválida!");
	              
    	  }
    	  
      }
      
      private static void menuCadastro() {
  		
  		System.out.println("""
                                   CADASTROS - Menu
                                   1) Cadastrar advogado
                                   2) Cadastrar cliente
                                   3) Cadastrar caso
                                   4) Cadastrar secret\u00e1ria
                                   0) voltar""");
  		
  		int opCadastro = Console.lerInt("Informe sua opção: ");
  		
  		 switch (opCadastro) {
	         case 1:
	             cadastrarAdvogado();
	             break;
	         case 2:
	             cadastrarCliente();
	             break;
	         case 3:
	       	  	 cadastrarCaso();
	             break;
	         case 4:
	        	 cadastrarSecretaria();
	             break;
	         case 0:
	        	 System.out.println("\nVoltando ao menu principal...");
	        	 break;
	         default:
	        	 System.out.println("Opção inválida!");
	              break;
  		 } 
  		 
  	}
      
    private static void menuListagens() {
    		
    		System.out.println("\nListas - Menu"
    							+ "\n1) Listar advogados"
    					        + "\n2) Listar clientes"
    							+ "\n3) Listar casos"
    				    	    + "\n4) Listar secretárias"
    				    	    + "\n0) voltar");
    		
    		int opCadastro = Console.lerInt("Informe sua opção: ");
    		
    		 switch (opCadastro) {
  	         case 1:
  	             listarAdvogados();
  	             break;
  	         case 2:
  	        	 listarClientes();
  	             break;
  	         case 3:
  	        	 listarCases();
  	             break;
  	         case 4:
  	        	 listarSecretarias();
  	             break;
  	         case 0:
  	        	 System.out.println("\nVoltando ao menu principal...");
  	        	 break;
  	         default:
  	        	 System.out.println("Opção inválida!");
  	              break;
    		 } 
    		 
    }
    
    private static void menuBuscas() {
		
		System.out.println("\nBuscas - Menu"
							+ "\n1) Buscar advogado"
					        + "\n2) Buscar cliente"
							+ "\n3) Buscar caso"
				    	    + "\n4) Buscar secretária"
				    	    + "\n0) Buscar");
		
		int opBusca = Console.lerInt("Informe sua opção: ");
		
		 switch (opBusca) {
	         case 1:
	             buscarAdvogado();
	             break;
	         case 2:
	        	 buscarCliente();
	             break;
	         case 3:
	        	 buscarCaso();
	             break;
	         case 4:
	        	 buscarSecretaria();
	        	 break;
	         case 0:
	        	 exibirMenu();
	        	 break;
	         default:
	        	 System.out.println("Opção inválida!");
	              break;
		 } 
		 
    }
      
    private static void menuAtualizarDados() {
		
		System.out.println("\nListas - Menu"
							+ "\n1) Atualizar Dados advogado"
					        + "\n2) Atualizar Dados cliente"
							+ "\n3) Atualizar Dados caso"
				    	    + "\n4) Atualizar Dados secretárias"
				    	    + "\n0) voltar");
		
		int opAtualizar = Console.lerInt("Informe sua opção: ");
		
		 switch (opAtualizar) {
	         case 1 -> atualizarDadosAdv();
	         case 2 -> atualizarDadosCliente();
	         case 3 -> atualizarDadosCaso();
	         case 4 -> atualizarDadosSecretaria();
	         case 0 -> System.out.println("\nVoltando ao menu principal...");
	         default -> System.out.println("Opção inválida!");
		 } 
		 
}
      
  
    private static void cadastrarAdvogado() {
    	
        String nomeAdv = Console.lerString("\nDigite o nome do advogado: ");
        String oab = Console.lerString("Digite o número da OAB: ");
        String emailAdv = Console.lerString("Digite o e-mail: ");
        String passwordAdv = Console.lerString("Digite a senha: ");
        String especialidade = Console.lerString("Informe a especialidade: ");
        
        Lawyer lawyer = new Lawyer(nomeAdv, emailAdv,passwordAdv, oab, especialidade);
        ListaAdvogado.salvarAdvogado(lawyer);
        
        try {
            GerenciadorAdvogados.salvarAdvogadoNoArquivo(ListaAdvogado.getListaAdvogados());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   private static void cadastrarCliente() {
    	
    	String cpf = Console.lerString("\nDigite o CPF: ");
        String nomeCli = Console.lerString("Digite o nome do cliente: ");
        String emailCli = Console.lerString("Digite o e-mail: ");
        String cep = Console.lerString("Digite o cep: ");
        
        Client cliente = new Client(cpf ,nomeCli, emailCli, cep);
        ListaClientes.salvarCliente(cliente);
        
        try {
            GerenciadorCliente.salvarClienteNoArquivo(ListaClientes.getListaClientes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listarClientes() {
        ListaClientes.listarClientes();
    }

    private static void listarAdvogados() {
        ListaAdvogado.listarAdvogados();
    }

    private static void cadastrarCaso() {
    	
        int id = Console.lerInt("\nDigite o ID do caso: ");
        String tipoCaso = Console.lerString("Digite o tipo do caso: ");
        String clienteCpf = Console.lerString("Digite o CPF do cliente: ");
        String advogadoOab = Console.lerString("Digite o número da OAB do advogado: ");
        String descricao = Console.lerString("Digite a descrição do caso: ");
        Double valor = Console.lerDouble("Digite o valor do caso: ");

        try {
        	
            Client cliente = ListaClientes.buscarCliente(clienteCpf);
            Lawyer advogado = ListaAdvogado.buscarAdvogado(advogadoOab);
            Case caso = new Case(id, tipoCaso, cliente , advogado, descricao, valor);
   
            ListaCases.salvarCase(caso);
            GerenciadorAdvogados.salvarAdvogadoNoArquivo(ListaAdvogado.getListaAdvogados());
            GerenciadorCliente.salvarClienteNoArquivo(ListaClientes.getListaClientes());
            GerenciadorCasos.salvarCasoNoArquivo(ListaCases.getListaCases());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
    }

    private static void listarCases() {
        ListaCases.listarCases();
    }

    private static void cadastrarSecretaria() {
    	
    	int numRegistro = Console.lerInt("\nDigite o número de registro: ");
        String nomeSec = Console.lerString("Digite o nome da secretária: ");
        String emailSec = Console.lerString("Digite o email da secretária: ");
        String passwordSec = Console.lerString("Digite a senha da secretária: ");
        
        Secretary secretaria = new Secretary(nomeSec, emailSec, passwordSec, numRegistro);
        ListaSecretarias.salvarSecretaria(secretaria);
        
        try {
        	
            GerenciadorSecretarias.salvarSecretariaNoArquivo(ListaSecretarias.getListaSecretarias());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   private static void listarSecretarias() {
        ListaSecretarias.listarSecretarias();
    }

    private static void buscarCliente() {
      
        String cpf = Console.lerString("\nDigite o CPF do cliente que deseja buscar: ");

        try {
        	
            Client cliente = ListaClientes.buscarCliente(cpf);
            System.out.println("\nCliente encontrado: " + cliente);
            	
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

   private static void buscarAdvogado() {
     
        String oab = Console.lerString("\nDigite o número da OAB do advogado que deseja buscar: ");

        try {
        	
            Lawyer advogado = ListaAdvogado.buscarAdvogado(oab);
            System.out.println("\nAdvogado encontrado: " + advogado);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
   private static void buscarCaso() {
        
        int id = Console.lerInt("\nDigite o id do caso que deseja buscar: ");

        try {
        	
            Case c = ListaCases.buscarCase(id);
            System.out.println("\nCaso encontrado: " + c.showCaseData());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void buscarSecretaria() {
        
        int numRegistro = Console.lerInt("\nDigite o número de registro da secretaria que deseja buscar: ");

        try {
        	
            Secretary s = ListaSecretarias.buscarSecretaria(numRegistro);
            System.out.println("\nSecretaria encontrado: " + s);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void atualizarDadosAdv() {
    	
    	 try {

             ListaAdvogado.verificarListaVazia();

             System.out.println("\nInforme a OAB do advogado que deseja atualizar:");
             String oab = Console.lerString("OAB: ");

             Lawyer tempLawyer = ListaAdvogado.buscarAdvogado(oab);

             System.out.println("\nAdvogado Localizado:" +
             tempLawyer.toString() + "\nInforme novos dados:\n");

             String nomeAdv = Console.lerString("Digite o nome do advogado: ");
             oab = Console.lerString("Digite o número da OAB: ");
             String emailAdv = Console.lerString("Digite o e-mail: ");
             String passwordAdv = Console.lerString("Digite a senha: ");
             String especialidade = Console.lerString("Informe a especialidade: ");
             
             tempLawyer.setOab(oab);
             tempLawyer.setName(nomeAdv);
             tempLawyer.setEmail(emailAdv);
             tempLawyer.setPassword(passwordAdv);
             tempLawyer.setPracticArea(especialidade);
             
             GerenciadorAdvogados.salvarAdvogadoNoArquivo(listaAdvogados);

             System.out.println("\nDados do advogado atualizado com sucesso:" + 
             tempLawyer.toString());
         
         } catch (Exception exception) {

             System.out.println(exception.getMessage());
         }

    }
    
    private static void atualizarDadosCliente() {
    	
   	 try {

            ListaClientes.verificarListaVazia();

            System.out.println("\nInforme o CPF do cliente que deseja atualizar:");
            String cpf = Console.lerString("CPF: ");

            Client tempClient = ListaClientes.buscarCliente(cpf);
            
            System.out.println("\nCliente Localizado:" +
            tempClient.toString() + "\nInforme novos dados:\n");


            cpf = Console.lerString("\nDigite o CPF: ");
            String nomeCli = Console.lerString("Digite o nome do cliente: ");
            String emailCli = Console.lerString("Digite o e-mail: ");
            String cep = Console.lerString("Digite o cep: ");
            
            tempClient.setCpf(cpf);
            tempClient.setName(nomeCli);
            tempClient.setEmail(emailCli);
            tempClient.setCep(cep);
            
            GerenciadorCliente.salvarClienteNoArquivo(listaClientes);

            System.out.println("\nDados do cliente atualizado com sucesso:" + 
            tempClient.toString());
        
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

   }
    private static void atualizarDadosCaso() {
    	
   	 try {

            ListaAdvogado.verificarListaVazia();

            System.out.println("\nInforme o ID do caso que deseja atualizar:");
            int id = Console.lerInt("ID: ");

            Case tempCaso = ListaCases.buscarCase(id);
            
            System.out.println("\nCaso Localizado:" +
            tempCaso.showCaseData() + "\nInforme novos dados:\n");

            id = Console.lerInt("\nDigite o ID do caso: ");
            String tipoCaso = Console.lerString("Digite o tipo do caso: ");
            String clienteCpf = Console.lerString("Digite o CPF do cliente: ");
            String advogadoOab = Console.lerString("Digite o número da OAB do advogado: ");
            String descricao = Console.lerString("Digite a descrição do caso: ");
            Double valor = Console.lerDouble("Digite o valor do caso: ");
            
            tempCaso.setId(id);
            tempCaso.setDescription(descricao);
            tempCaso.setTypeCase(tipoCaso);
            tempCaso.setPrice(valor);
           

            try {
            	
                Client cliente = ListaClientes.buscarCliente(clienteCpf);
                Lawyer advogado = ListaAdvogado.buscarAdvogado(advogadoOab);
                
                tempCaso.setClient(cliente);
                tempCaso.setLawyer(advogado);
             
                GerenciadorAdvogados.salvarAdvogadoNoArquivo(ListaAdvogado.getListaAdvogados());
                GerenciadorCliente.salvarClienteNoArquivo(ListaClientes.getListaClientes());
                GerenciadorCasos.salvarCasoNoArquivo(ListaCases.getListaCases());
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nDados do caso atualizado com sucesso:" + 
            tempCaso.showCaseData());
        
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

   }
    private static void atualizarDadosSecretaria() {
    	
   	 try {

            ListaSecretarias.verificarListaVazia();

            System.out.println("\nInforme o nuemro de registro da secretaria que deseja atualizar:");
            int nR = Console.lerInt("NumRegistro: ");

            Secretary tempSec = ListaSecretarias.buscarSecretaria(nR);

            System.out.println("\nSecretaria Localizado:" +
            tempSec.toString() + "\nInforme novos dados:\n");

            nR = Console.lerInt("\nDigite o número de registro: ");
            String nomeSec = Console.lerString("Digite o nome da secretária: ");
            String emailSec = Console.lerString("Digite o email da secretária: ");
            String passwordSec = Console.lerString("Digite a senha da secretária: ");
            
            tempSec.setRegistrationNum(nR);
            tempSec.setName(nomeSec);
            tempSec.setEmail(emailSec);
            tempSec.setPassword(passwordSec);
           
            
            try {
            	
                GerenciadorSecretarias.salvarSecretariaNoArquivo(ListaSecretarias.getListaSecretarias());
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            GerenciadorAdvogados.salvarAdvogadoNoArquivo(listaAdvogados);

            System.out.println("\nDados da secretaria atualizado com sucesso:" + 
            tempSec.toString());
        
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

   }
    
}
