import java.util.List;
import java.util.ArrayList;

public class Loja extends Empresa {
    public List<Jogo> jogosDisponiveis;
    public List<Produtora> listaProdutoras;

<<<<<<< Updated upstream
    public Loja(String nome) {
        super(nome);
        jogosDisponiveis = new ArrayList<Jogo>();
    }

    public boolean adicionarProdutora(Produtora produtora) {
        if (!listaProdutoras.contains(produtora)) {
            listaProdutoras.add(produtora);
            return true;
        } else {
            return false;
        }
    }

    public void adicionarJogoProdutora(Jogo jogo, String nomeProdutora) {
        for (Produtora produtora : listaProdutoras) {
            if (produtora.getNome() == nomeProdutora) {
                produtora.addJogo(jogo);
                jogo.setProdutora(produtora);
                break;
            }
=======
    public Loja(String nome, float cnpj) {
        super(nome, cnpj);
        jogosDisponiveis = new ArrayList<Jogo>();
    }

    public boolean adicionarJogosProdutora(Produtora produtora) {
        for (Jogo jogo : produtora.getJogos()) {
            jogosDisponiveis.add(jogo);
>>>>>>> Stashed changes
        }
    }

    public boolean adicionarJogo(Jogo jogo) {
        if (!jogosDisponiveis.contains(jogo)) {
            jogosDisponiveis.add(jogo);
            return true;
        } else {
            return false;
        }
    }

<<<<<<< Updated upstream
    public List<Jogo> Busca(Jogo.Genero genero) {
=======
    public List<Jogo> Busca(String genero) {
>>>>>>> Stashed changes
        List<Jogo> jogosFiltrados = new ArrayList<Jogo>();
        for (Jogo jogo : jogosDisponiveis) {
            if (jogo.getGenero() == genero) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }

<<<<<<< Updated upstream
    public List<Jogo> Busca(Jogo.Plataforma plataforma) {
        List<Jogo> jogosFiltrados = new ArrayList<Jogo>();
        for (Jogo jogo : jogosDisponiveis) {
            if (jogo.getPlataforma() == plataforma) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }

=======
>>>>>>> Stashed changes
    public List<Jogo> Busca(float preco) {
        List<Jogo> jogosFiltrados = new ArrayList<Jogo>();
        for (Jogo jogo : jogosDisponiveis) {
            if (jogo.getPreco() <= preco) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }

    public double calcularValorCarrinho(List<Jogo> carrinho) {
        double valorTotal = 0;
        for (Jogo jogo : carrinho) {
            valorTotal += jogo.getPreco();
        }
        return valorTotal;
    }

    public void adicionarCarrinho(Usuario usuario, Jogo jogo) {
        if (jogosDisponiveis.contains(jogo)) {
            List<Jogo> carrinhoAtual = usuario.getCarrinho();
            carrinhoAtual.add(jogo);
            usuario.setCarrinho(carrinhoAtual);
        }
    }

    public void compraRealizada(Usuario usuario) {
        List<Jogo> carrinhoAtual = usuario.getCarrinho();
        if (usuario.getCarteira() >= calcularValorCarrinho(carrinhoAtual)) {
            for (Jogo jogo : carrinhoAtual) {
<<<<<<< Updated upstream
                jogo.iterarCopiasVendidas();
                this.recebeDinheiro(jogo.getPreco() * 4 / 5);
                jogo.getProdutora().recebeDinheiro(jogo.getPreco() * 1 / 5); // FUNCAO GETPRODUTORA NAO EXISTE TEM QUE
                                                                             // IMPLEMENTAR // IMPLEMENTAR
=======
                this.recebeDinheiro(jogo.getPreco() * 4 / 5);
                jogo.getProdutora().recebeDinheiro(jogo.getPreco() * 1 / 5);
>>>>>>> Stashed changes
                usuario.adicionarJogoBiblioteca(jogo);
            }
        } else {
            System.out
                    .println("Você não tem dinheiro na carteira para comprar todos os jogos. Retire algo do carrinho.");
        }
    }
}
