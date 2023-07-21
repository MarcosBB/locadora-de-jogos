import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String username;
    private int idade;
    private String email;
    private CarrinhoCompras carrinho;
    public List<Joguin> biblioteca;
    private float carteira;

    public Usuario(String username, int idade, String email) {
        this.username = username;
        this.idade = idade;
        this.email = email;
        this.carrinho = new CarrinhoCompras();
        biblioteca = new ArrayList<Joguin>();
        carteira = 2000;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addDinheiroCarteira(float dinheiro) {
        this.carteira += dinheiro;
    }

    public void takeDinheiroCarteira(double dinheiro) {
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
            for (Joguin jogo : carrinho.jogosQueTem()) {
                adicionarJogoBiblioteca(jogo);
            }
            takeDinheiroCarteira(carrinho.calcularTotal());
            carrinho.finalizarCompra();
        } else {
            throw new IllegalArgumentException(
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
