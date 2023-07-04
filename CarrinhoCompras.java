import java.util.List;
import java.util.ArrayList;

class CarrinhoCompras implements Carrinh{
    private List<Joguin> jogos;

    public CarrinhoCompras() {
        jogos = new ArrayList<>();
    }

    public void adicionarJogo(Joguin jogo) {
        this.jogos.add(jogo);
        System.out.println(jogo.getNome() + " adicionado ao carrinho.");
    }

    public void removerJogo(Joguin jogo) {
        this.jogos.remove(jogo);
        System.out.println(jogo.getNome() + " removido do carrinho.");
    }

    public List<Joguin> jogosQueTem() {
        return this.jogos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Joguin jogo : jogos) {
            total += jogo.getPreco();
        }
        return total;
    }

    public void finalizarCompra() {
        System.out.println("Compra finalizada.");
        for (Joguin j : jogos)
        {
            this.jogos.remove(j);
        }
    }
}