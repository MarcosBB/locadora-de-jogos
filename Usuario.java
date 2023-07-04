import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private CarrinhoCompras Carrinho;
    public List<Joguin> Biblioteca;
    private int carteira;

    public Usuario() {
        this.Carrinho = new CarrinhoCompras();
        Biblioteca = new ArrayList<Joguin>();
        carteira = 0;
    }

    public void addDinheiroCarteira(int dinheiro) {
        this.carteira += dinheiro;
    }

    public void takeDinheiroCarteira(int dinheiro) {
        this.carteira -= dinheiro;
    }

    public int getCarteira() {
        return this.carteira;
    }

    public void adicionarJogoNoCarrinho(Joguin jogo) {
        Carrinho.adicionarJogo(jogo);
    }

    public void removerJogoNoCarrinho(Joguin jogo) {
        Carrinho.removerJogo(jogo);
    }

    public List<Joguin> mostrarJogosNoCarrinho() {
        return Carrinho.jogosQueTem();
    }

    public double calcularTotal() {
        return Carrinho.calcularTotal();
    }

    public void finalizarCompra(Loja loja) {
        if(carteira >= Carrinho.calcularTotal()) {
            loja.compraRealizada(Carrinho.jogosQueTem());
            Carrinho.finalizarCompra();
        }
        else {
            System.out.println("Você não tem dinheiro na carteira para comprar todos os jogos. Retire algo do carrinho ou adicione mais dinheiro.");
        }
    }

    public List<Joguin> getBiblioteca() {
        return this.Biblioteca;
    }

    public void adicionarJogoBiblioteca(Joguin jogo) {
        this.Biblioteca.add(jogo);
    }
}
