import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private CarrinhoCompras carrinho;
    public List<Joguin> biblioteca;
    private float carteira;

    public Usuario() {
        this.carrinho = new CarrinhoCompras();
        biblioteca = new ArrayList<Joguin>();
        carteira = 0;
    }

    public void addDinheiroCarteira(float dinheiro) {
        this.carteira += dinheiro;
    }

    public void takeDinheiroCarteira(float dinheiro) {
        this.carteira -= dinheiro;
    }

    public float getCarteira() {
        return this.carteira;
    }

    public void adicionarJogoNoCarrinho(Joguin jogo) {
        carrinho.adicionarJogo(jogo);
    }

    public void removerJogoNoCarrinho(Joguin jogo) {
        carrinho.removerJogo(jogo);
    }

    public List<Joguin> mostrarJogosNoCarrinho() {
        return carrinho.jogosQueTem();
    }

    public double calcularTotal() {
        return carrinho.calcularTotal();
    }

    public void finalizarCompra(Loja loja) {
        if (carteira >= carrinho.calcularTotal()) {
            loja.compraRealizada(carrinho.jogosQueTem());
            for (Joguin jogo : carrinho.jogosQueTem())
            {
                adicionarJogoBiblioteca(jogo);
            }
            carrinho.finalizarCompra();
        } else {
            System.out.println(
                    "Você não tem dinheiro na carteira para comprar todos os jogos. Retire algo do carrinho ou adicione mais dinheiro.");
        }
    }

    public List<Joguin> getBiblioteca() {
        return this.biblioteca;
    }

    public void adicionarJogoBiblioteca(Joguin jogo) {
        this.biblioteca.add(jogo);
    }
}
