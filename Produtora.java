import java.util.List;
import java.util.ArrayList;

public class Produtora extends Empresa {
    String name;
<<<<<<< Updated upstream
    public List<Jogo> jogosCriados;

<<<<<<< Updated upstream
    public Produtora(String nome) {
        super(nome);
        jogosCriados = new ArrayList<Jogo>();
    }

    public void addJogo(Jogo jogo) {
        jogosCriados.add(jogo);
    }

    public String getNome() {
        return this.name;
=======
    public Produtora(String nome, float cnpj) {
        super(nome, cnpj);
        jogosCriados = new ArrayList<Jogo>();
    }

=======
    public List<Joguin> jogosCriados;

    public Produtora(String nome, float cnpj) {
        super(nome, cnpj);
        jogosCriados = new ArrayList<Joguin>();
    }

>>>>>>> Stashed changes
    public String getNome() 
    {
        return this.name;
    }

    public void criarJogo(String nomeDoJogo, String genero, float preco)
    {
<<<<<<< Updated upstream
        jogosCriados.add(new Jogo(nomeDoJogo, genero, preco, this));
    }

    public List<Jogo> getJogos()
    {
        return jogosCriados;
>>>>>>> Stashed changes
=======
        jogosCriados.add(new Joguin(nomeDoJogo, genero, preco, this));
    }

    public List<Joguin> getJogos()
    {
        return jogosCriados;
>>>>>>> Stashed changes
    }
}
