import java.util.List;
import java.util.ArrayList;

public class Produtora extends Empresa {
    String name;
    public List<Jogo> jogosCriados;

    public Produtora(String nome) {
        super(nome);
        jogosCriados = new ArrayList<Jogo>();
    }

    public void addJogo(Jogo jogo) {
        jogosCriados.add(jogo);
    }

    public String getNome() {
        return this.name;
    }
}
