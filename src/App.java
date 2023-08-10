import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        ContaBancaria conta1 = new ContaBancaria("12445-1", "Ana da Silva", 500);
        ContaBancaria conta2 = new ContaBancaria("12345-2", "Pedro Santos", 200);
        ContaBancaria conta3 = new ContaBancaria("10104-1", "Maria Soares", 700);
        ContaBancaria conta4 = new ContaBancaria("53139-6", "João Ferreira", 600);

        AgenciaBancaria agencia1 = new AgenciaBancaria(1234);

        agencia1.addConta(conta1);
        agencia1.addConta(conta2);
        agencia1.addConta(conta3);
        agencia1.addConta(conta4);

        System.out.print("Digite o número da sua conta: ");
        String numeroConta = scanner.nextLine();

        if (agencia1.contaCadastrada(numeroConta) == null) {
            System.out.println("\nEssa conta não está cadastrada na agência desse banco.");

        } else {
            System.out.println("\nBem vindo a sua conta bancária, "+agencia1.contaCadastrada(numeroConta).getNome());

            do {
                System.out.println("\nMenu de opções:\n1 - Depósito\n2 - Saque\n3 - Mostrar saldo");
                System.out.print("Digite a sua opção ou -1 para sair: ");

                opcao = scanner.nextInt();

                switch(opcao) {
                    case 1:
                        Scanner scanner2 = new Scanner(System.in);
                 
                        System.out.print("Digite o valor que você quer depositar, "+agencia1.contaCadastrada(numeroConta).getNome() +": ");

                        float deposito = scanner2.nextFloat();
                        agencia1.contaCadastrada(numeroConta).deposito(deposito);

                        System.out.println("\nDepósito realizado com sucesso.");

                        break;

                    case 2:
                        Scanner scanner3 = new Scanner(System.in);
                        
                        System.out.print("Digite o valor que você quer sacar, "+agencia1.contaCadastrada(numeroConta).getNome()+": ");

                        float saque = scanner3.nextFloat();
                        agencia1.contaCadastrada(numeroConta).saque(saque);

                        break;

                    case 3:
                        System.out.print("\nO seu saldo é de R$ "+agencia1.contaCadastrada(numeroConta).getSaldo() +" reais.\n");
                        break;
                    
                    default:
                        if (opcao != -1) {
                            System.out.println("\nOpção inválida.");
                            
                            break;
                        }
                } 

            } while (opcao != -1);
        }

        scanner.close();
    }
}