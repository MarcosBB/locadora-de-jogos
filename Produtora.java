import java.util.List;
import java.util.ArrayList;

public class Produtora extends Empresa {
    String name;
    public List<Joguin> jogosCriados;

    public Produtora(String nome, float cnpj) {
        super(nome, cnpj);
        jogosCriados = new ArrayList<Joguin>();
    }

    public String getNome() 
    {
        return this.name;
    }

    public void criarJogo(String nomeDoJogo, String genero, float preco)
    {
        jogosCriados.add(new Joguin(nomeDoJogo, genero, preco, this));
    }

    public List<Joguin> getJogos()
    {
        return jogosCriados;
    }
}
