import java.util.Scanner;
import java.util.List;

public class Main {
    private static void showGameList(List<Joguin> j) {
        title("Lista de jogos");
        if (j.size() < 1)
            System.out.println("Não há jogos.");
        else {
            for (int i = 0; i < j.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + j.get(i).getNome());
            }
        }

    }

    private static void input(String s, Usuario u, Loja l, Scanner scanner) {
        if (s == "Adicionar dinheiro") {
            System.out.println("Quanto você quer adicionar ?");
            u.addDinheiroCarteira(scanner.nextInt());
            System.out.println("Carteira atualizada, agora você tem " + u.getCarteira() + " dinheiros.");
        }

        else if (s == "Gênero") {
            System.out.println("Digite uma das opções de gênero a seguir. {Ação, Aventura, Tiro}");
            showGameList(l.Busca(scanner.nextLine()));
        }

        else if (s == "Preço máximo") {
            System.out.println("Digite um valor máximo de preço.");
            showGameList(l.Busca(scanner.nextInt()));
        }

        else if (s == "Adicionar ao carrinho") {
            System.out.println("Digite o número do jogo.");
            u.adicionarJogoNoCarrinho(l.VerJogo(scanner.nextInt()));
        }

        else if (s == "Retirar do carrinho") {
            System.out.println("Digite o número do jogo.");
            u.adicionarJogoNoCarrinho(l.VerJogo(scanner.nextInt()));
        }
    }

    private static void title(String t) {
        System.out.println("================");
        System.out.println(t);
        System.out.println("================");
    }

    private static String options(List<String> options, Scanner scanner) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + options.get(i));
        }

        int selection = scanner.nextInt() - 1;

        return options.get(selection);
    }

    /*
     * private static String createRandomGames(Loja l) {
     * int ver = 1;
     * String s = "";
     * for (int i = 0; i < 3; i++) {
     * Produtora produtora = new Produtora();
     * for (int j = 0; j < 5; j++) {
     * produtora.criarJogo("Jogo " + ver, "Ação", i*j);
     * ver++;
     * }
     * l.adicionarJogosProdutora(produtora);
     * }
     * }
     */

    public enum Page {
        HOME, ACCOUNT, STORE, BASKET, GAMEFILTER, WANNABUY
    }

    public static void main(String args[]) {
        boolean RUNNING = true;
        Page PAGE = Page.HOME;
        Scanner scanner = new Scanner(System.in);

        Usuario user = new Usuario();
        Loja loja = new Loja("Loja LP2", 711230911);

        while (RUNNING == true) {

            if (PAGE == Page.HOME) {
                title("Bem-vindo!");
                String chosen = options(List.of("Minha conta", "Loja", "Sair"), scanner);

                if (chosen == "Minha conta")
                    PAGE = Page.ACCOUNT;
                else if (chosen == "Loja")
                    PAGE = Page.STORE;
                else if (chosen == "Sair") {
                    scanner.close();
                    RUNNING = false;
                }
            }

            if (PAGE == Page.ACCOUNT) {
                title("Essa é sua conta");
                String chosen = options(List.of("Ver meus jogos", "Adicionar dinheiro", "Voltar"), scanner);
                if (chosen == "Ver meus jogos")
                    showGameList(user.getBiblioteca());
                else if (chosen == "Adicionar dinheiro")
                    input(chosen, user, loja, scanner);
                else if (chosen == "Voltar")
                    PAGE = Page.HOME;
            }

            if (PAGE == Page.STORE) {
                title("Loja de jogos LP2");
                String chosen = options(List.of("Ver jogos", "Ver Carrinho", "Voltar"), scanner);
                if (chosen == "Ver jogos")
                    PAGE = Page.GAMEFILTER;
                else if (chosen == "Ver Carrinho") {
                    showGameList(user.mostrarJogosNoCarrinho());
                    PAGE = Page.BASKET;
                } else if (chosen == "Voltar")
                    PAGE = Page.HOME;
            }

            if (PAGE == Page.GAMEFILTER) {
                title("Busca de jogos");
                String chosen = options(List.of("Gênero", "Preço máximo", "Voltar"), scanner);
                if (chosen == "Gênero") {
                    input(chosen, user, loja, scanner);
                    PAGE = Page.WANNABUY;
                } else if (chosen == "Preço máximo") {
                    input(chosen, user, loja, scanner);
                    PAGE = Page.WANNABUY;
                } else if (chosen == "Voltar")
                    PAGE = Page.STORE;
            }

            if (PAGE == Page.WANNABUY) {
                title("Busca de jogos");
                String chosen = options(List.of("Adicionar ao carrinho", "Realizar outra busca", "Voltar"), scanner);
                if (chosen == "Realizar outra busca")
                    PAGE = Page.GAMEFILTER;
                else if (chosen == "Adicionar ao carrinho") {
                    input(chosen, user, loja, scanner);
                    PAGE = Page.STORE;
                } else if (chosen == "Voltar")
                    PAGE = Page.STORE;
            }

            if (PAGE == Page.BASKET) {
                String chosen = options(List.of("Finalizar compra", "Retirar do carrinho", "Voltar"), scanner);
                if (chosen == "Finalizar compra") {
                    user.finalizarCompra(loja);
                    PAGE = Page.STORE;
                } else if (chosen == "Retirar do carrinho") {
                    input(chosen, user, loja, scanner);
                    PAGE = Page.STORE;
                } else if (chosen == "Voltar")
                    PAGE = Page.STORE;
            }

        }

    }
}
