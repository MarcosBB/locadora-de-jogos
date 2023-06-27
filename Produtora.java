import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Produtora extends Empresa {
    String name;
    public List<Jogo> jogosCriados;

    public Produtora(String nome) {
        super(nome);
        jogosCriados = new ArrayList<Jogo>();
    }

    public List<Jogo> getJogosCriados() {
        return jogosCriados;
    }

    public void cadastraJogo(
            String nome,
            Calendar dataDeLancamento,
            Jogo.Genero genero,
            Jogo.Plataforma plataforma,
            int classificacaoIndicativa,
            int quantidadeDeJogadores,
            int preco) {
        jogosCriados.add(new Jogo(
                nome,
                dataDeLancamento,
                genero,
                plataforma,
                classificacaoIndicativa,
                quantidadeDeJogadores,
                preco,
                this));
    }
}
