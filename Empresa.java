public class Empresa {
    public String nome;
    public float cnpj;
    private double Caixa = 0.00;

    public Empresa(String nome, float cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public void recebeDinheiro(double valorGanho) {
        this.Caixa = Caixa + valorGanho;
    }
}
