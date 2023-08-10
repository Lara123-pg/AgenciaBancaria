public class ContaBancaria {
    private String numeroConta;
    private String nome;
    private float saldo;


    public ContaBancaria(String numeroConta, String nome, float saldo) {
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void saque(float valor) {
        if (valor > this.saldo) {
            System.out.println("\nVocê não poderá sacar esse valor, pois atualmente você tem R$ " +this.saldo +" reais.");

        } else {
            this.saldo = saldo - valor;
            System.out.println("\nSaque realizado com sucesso.");
        }
    }

    public void deposito(float valor) {
        if (valor > 0) {
            this.saldo = saldo + valor;

            System.out.println("\nDepósito realizado com sucesso.");

        } else {
            System.out.println("\nValor inválido para o depósito.");
        }
    }
}