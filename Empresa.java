public abstract class Empresa {
    private String nome;
    private String cnpj;
    private double caixa = 0.00;

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
    }

    public double getCaixa() {
        return this.caixa;
    }

    public void recebeDinheiro(double valorGanho) {
        this.caixa += valorGanho;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
