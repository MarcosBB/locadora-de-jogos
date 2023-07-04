import java.util.List;
import java.util.ArrayList;

public class Loja extends Empresa {
    public List<Joguin> jogosDisponiveis;
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

    public Joguin VerJogo(int i) {
        return jogosDisponiveis.get(i);
    }

    public List<Joguin> Busca(String genero) {
        List<Joguin> jogosFiltrados = new ArrayList<Joguin>();
        for (Joguin jogo : jogosDisponiveis) {
            if (jogo.getGenero() == genero) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }

    public List<Joguin> Busca(float preco) {
        List<Joguin> jogosFiltrados = new ArrayList<Joguin>();
        for (Joguin jogo : jogosDisponiveis) {
            if (jogo.getPreco() <= preco) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }

    public void compraRealizada(List<Joguin> jogos) {
        for (Joguin j : jogos) {
            this.recebeDinheiro(j.getPreco() * 4 / 5);
            j.getProdutora().recebeDinheiro(j.getPreco() * 1 / 5);
        }
    }
}
