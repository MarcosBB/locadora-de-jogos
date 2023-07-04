public abstract class Empresa {
    public String nome;
    public float cnpj;
    private double Caixa = 0.00;

<<<<<<< Updated upstream
    public Empresa(String nome) {
=======
    public Empresa(String nome, float cnpj) {
>>>>>>> Stashed changes
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public void recebeDinheiro(double valorGanho) {
        this.Caixa += valorGanho;
    }

    public double getCaixa() {
        return this.Caixa;
    }
}
