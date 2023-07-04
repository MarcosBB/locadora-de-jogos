import java.util.List;
import java.util.ArrayList;

public class Usuario {
<<<<<<< Updated upstream
    public List<Jogo> Carrinho;
    public List<Jogo> Biblioteca;
    private double carteira;

    public Usuario() {
        Carrinho = new ArrayList<Jogo>();
        Biblioteca = new ArrayList<Jogo>();
        carteira = 0.00;
    }

    public void addDinheiroCarteira(double dinheiro) {
        this.carteira += dinheiro;
    }

    public void takeDinheiroCarteira(double dinheiro) {
        this.carteira -= dinheiro;
    }

    public double getCarteira() {
        return this.carteira;
    }

    public void setCarrinho(List<Jogo> carrinho) {
=======
    CarrinhoCompras Carrinho;
    public List<Jogo> Biblioteca;
    private int carteira;

    public Usuario() {
        Carrinho = new Carrinho();
        Biblioteca = new ArrayList<Jogo>();
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

    /*public void setCarrinho(List<Jogo> carrinho) {
>>>>>>> Stashed changes
        this.Carrinho = carrinho;
    }

    public List<Jogo> getCarrinho() {
        return this.Carrinho;
    }*/

    public List<Jogo> getBiblioteca() {
        return this.Biblioteca;
    }

<<<<<<< Updated upstream
    public List<Jogo> getBiblioteca() {
        return this.Biblioteca;
    }

=======
>>>>>>> Stashed changes
    public void adicionarJogoBiblioteca(Jogo jogo) {
        this.Biblioteca.add(jogo);
    }

<<<<<<< Updated upstream
    public void adicionarJogoCarrinho(Jogo jogo) {
        this.Carrinho.add(jogo);
    }

    public void verListaCarrinho() {
        System.out.println("Você tem " + Carrinho.size() + " itens na sua lista");
        for (int i = 0; i < Carrinho.size(); i++) {
            System.out.println((i + 1) + " - " + Carrinho.get(i));
        }
    }

    public void verListaBiblioteca() {
        System.out.println("Você tem " + Biblioteca.size() + " itens na sua biblioteca");
        for (int i = 0; i < Biblioteca.size(); i++) {
            System.out.println((i + 1) + " - " + Biblioteca.get(i));
        }
    }

=======
    /*public void adicionarJogoCarrinho(Jogo jogo) {
        this.Carrinho.add(jogo);
    }
*/
>>>>>>> Stashed changes
}
