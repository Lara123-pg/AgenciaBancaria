import java.util.Scanner;

public class BancoMain {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        ContaBancaria conta1 = new ContaBancaria("12445-1", "Ana da Silva", 500);
        ContaBancaria conta2 = new ContaBancaria("12345-2", "Pedro Santos", 200);
        ContaBancaria conta3 = new ContaBancaria("10104-1", "Maria Soares", 700);
        ContaBancaria conta4 = new ContaBancaria("53139-6", "João Ferreira", 600);

        AgenciaBancaria agencia1 = new AgenciaBancaria(1234);
        AgenciaBancaria agencia2 = new AgenciaBancaria(5678);

        agencia1.addConta(conta1);
        agencia2.addConta(conta2);
        agencia1.addConta(conta3);
        agencia2.addConta(conta4);

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Digite o número da sua agência: ");
        int agenciaNum = scanner2.nextInt();

        AgenciaBancaria agencia = null;
        boolean agenciaExiste = false;

        if (agenciaNum == agencia1.getNumeroAgencia()) {
            agencia = agencia1;
            agenciaExiste = true;

        } else if (agenciaNum == agencia2.getNumeroAgencia()) {
            agencia = agencia2;
            agenciaExiste = true;

        } else {
            System.out.println("\nEsse número não corresponde a nenhuma agência do banco.");
        }

        if (agenciaExiste) {
            System.out.print("Digite o número da sua conta: ");
            String numeroConta = scanner.nextLine();

            if (agencia.contaCadastrada(numeroConta) == null) {
                System.out.println("\nEssa conta não está cadastrada na agência "+agencia.getNumeroAgencia()  +" desse banco.");

            } else {
                System.out.println("\nBem vindo a sua conta bancária, "+agencia.contaCadastrada(numeroConta).getNome());

                do {
                    System.out.println("\nMenu de opções:\n1 - Depósito\n2 - Saque\n3 - Mostrar saldo");
                    System.out.print("Digite a sua opção ou -1 para sair: ");

                    opcao = scanner.nextInt();

                    switch(opcao) {
                        case 1:
                            Scanner scanner3 = new Scanner(System.in);
                    
                            System.out.print("Digite o valor que você quer depositar, "+agencia.contaCadastrada(numeroConta).getNome() +": ");

                            float deposito = scanner3.nextFloat();
                            agencia.contaCadastrada(numeroConta).deposito(deposito);

                            break;

                        case 2:
                            Scanner scanner4 = new Scanner(System.in);
                            
                            System.out.print("Digite o valor que você quer sacar, "+agencia.contaCadastrada(numeroConta).getNome()+": ");

                            float saque = scanner4.nextFloat();
                            agencia.contaCadastrada(numeroConta).saque(saque);

                            break;

                        case 3:
                            System.out.print("\nO seu saldo é de R$ "+agencia.contaCadastrada(numeroConta).getSaldo() +" reais.\n");
                            break;
                        
                        default:
                            if (opcao != -1) {
                                System.out.println("\nOpção inválida.");
                                
                                break;
                            }
                    } 

                } while (opcao != -1);
            }
        }
        
        scanner.close();
        scanner2.close();
    }
}