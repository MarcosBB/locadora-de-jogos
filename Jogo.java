import java.util.Calendar;

public class Jogo {
    public enum Genero {
        ACAO("Ação"),
        AVENTURA("Aventura"),
        RPG("RPG"),
        ESTRATEGIA("Estratégia"),
        TIRO("Tiro"),
        SIMULACAO("Simulação"),
        CORRIDA("Corrida"),
        ESPORTE("Esporte");

        private final String nome;

        Genero(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return this.nome;
        }
    }

    public enum Plataforma {
        PC,
        PS4,
        PS5,
        XBOX_ONE,
        XBOX_SERIES,
        NINTENDO_SWITCH,
    }

    private String nome;
    private Calendar dataDeLancamento;
    private Genero genero;
    private Plataforma plataforma;
    private int classificacaoIndicativa;
    private int quantidadeDeJogadores;
    private float preco;
    private int copiasVendidas;
    // private Empresa produtora;

    public Jogo(String nome, Calendar dataDeLancamento, Genero genero, Plataforma plataforma,
            int classificacaoIndicativa, int quantidadeDeJogadores, int preco) {
        this.nome = nome;
        this.dataDeLancamento = dataDeLancamento;
        this.genero = genero;
        this.plataforma = plataforma;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.quantidadeDeJogadores = quantidadeDeJogadores;
        this.preco = preco;
        this.copiasVendidas = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataDeLancamento() {
        return this.dataDeLancamento;
    }

    public void setDataDeLancamento(Calendar dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Plataforma getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public int getClassificacaoIndicativa() {
        return this.classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getQuantidadeDeJogadores() {
        return this.quantidadeDeJogadores;
    }

    public void setQuantidadeDeJogadores(int quantidadeDeJogadores) {
        this.quantidadeDeJogadores = quantidadeDeJogadores;
    }

    public int getCopiasVendidas() {
        return this.copiasVendidas;
    }

    public void iterarCopiasVendidas() {
        this.copiasVendidas += 1;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
