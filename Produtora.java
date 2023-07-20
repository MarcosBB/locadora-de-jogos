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
        switch(genero)
        {
            case "Acao":
            jogosCriados.add(new JogoAcao(nomeDoJogo, genero, preco, this));
            break;

            case "Aventura":
            jogosCriados.add(new JogoAventura(nomeDoJogo, genero, preco, this));
            break;

            case "Casual":
            jogosCriados.add(new JogoCasual(nomeDoJogo, genero, preco, this));
            break;

            case "Simulacao":
            jogosCriados.add(new JogoSimulação(nomeDoJogo, genero, preco, this));
            break;

            case "RPG":
            jogosCriados.add(new JogoRPG(nomeDoJogo, genero, preco, this));
            break;

            case "Plataforma":
            jogosCriados.add(new JogoPlataforma(nomeDoJogo, genero, preco, this));
            break;

            default:
            break;
        }
        
    }

    public List<Joguin> getJogos()
    {
        return jogosCriados;
    }
}
