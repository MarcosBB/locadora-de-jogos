public abstract class Empresa
{
    public String nome;
    private double Caixa = 0.00;
    
    public Empresa(String nome)
    {
        this.nome = nome;
    }
    
    public void recebeDinheiro(double valorGanho)
    {
        this.Caixa += valorGanho;
    }
}
