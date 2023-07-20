public abstract class Joguin{
    private String nome;
    private String genero;
    private float preco;
    private Produtora produtora;

    public Joguin(String nome, String genero, float preco, Produtora produtora) {
        this.nome = nome;
        this.genero = genero;
        this.preco = preco;
        this.produtora = produtora;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Produtora getProdutora() {
        return this.produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    public abstract void jogar();
}
