import java.util.ArrayList;

public class AgenciaBancaria {
    private int numeroAgencia;
    private ArrayList<ContaBancaria> contas;

    public AgenciaBancaria(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
        contas = new ArrayList<>();
    }

    public int getNumeroAgencia() {
        return this.numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public void getContas() {
        for(int i = 0; i < this.contas.size(); i++)  {
            System.out.println(contas.get(i).getNumeroConta());
        }
    }

    public void addConta(ContaBancaria conta) {
        this.contas.add(conta);
    }

    public ContaBancaria contaCadastrada(String conta2) {
        for (ContaBancaria conta : this.contas) {
            if (conta.getNumeroConta().equals(conta2)) {
                return conta;
            }
        }

        return null;
    }
}