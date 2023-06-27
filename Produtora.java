import java.util.List;
import java.util.ArrayList;

public class Produtora extends Empresa {
    String name;
    public List<Jogo> jogosCriados;

    public Produtora(String nome) {
        super(nome);
        jogosCriados = new ArrayList<Jogo>();
    }

    // FUNÇÃO IMCOMPLETA VAI DAR MERDA, PRECISAR SER AJEITADA PRA COMBINAR COM A
    // CLASSE JOGO
    public void CriarJogo(String nomeDoJogo, Jogo.Genero genero) {
        jogosCriados.add(new Jogo(nomeDoJogo, genero, this));
    }
}
