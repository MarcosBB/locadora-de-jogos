import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Loja extends Empresa {
    public List<Joguin> jogosDisponiveis;

    public Map<Integer, Joguin> jogosFiltrados = new HashMap<Integer, Joguin>();
    //public List<Produtora> listaProdutoras;

    public Loja(String nome, float cnpj) {
        super(nome, cnpj);
        jogosDisponiveis = new ArrayList<Joguin>();
    }

    public void adicionarJogosProdutora(Produtora produtora) {
        for (Joguin jogo : produtora.getJogos()) {
            jogosDisponiveis.add(jogo);
        }
    }

    public List<Joguin> Busca(String genero) {
        int i = 0;
        jogosFiltrados.clear();
        for (Joguin jogo : jogosDisponiveis) {
            if (jogo.getGenero() == genero) {
                jogosFiltrados.put(i, jogo);
                i++;
            }
        }
        List<Joguin> list = new ArrayList<Joguin>(jogosFiltrados.values());
        return list;
    }

    public List<Joguin> Busca(float preco) {
        int i = 0;
        jogosFiltrados.clear();
        for (Joguin jogo : jogosDisponiveis) {
            if (jogo.getPreco() <= preco) {
                jogosFiltrados.put(i, jogo);
                i++;
            }
        }
        List<Joguin> list = new ArrayList<Joguin>(jogosFiltrados.values());
        return list;
    }

    public Joguin EscolherJogo(int i) {
        return jogosFiltrados.get(i);
    }

    public int NumeroDeOpcoes() {
        return jogosFiltrados.size();
    }

    public void compraRealizada(List<Joguin> jogos) {
        for (Joguin j : jogos) {
            this.recebeDinheiro(j.getPreco() * 4 / 5);
            j.getProdutora().recebeDinheiro(j.getPreco() * 1 / 5);
        }
    }
}
