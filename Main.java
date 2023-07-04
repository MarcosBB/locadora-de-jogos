<<<<<<< Updated upstream
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
=======
import java.util.Scanner;
import java.util.List;

public class Main {
    private static void showGameList(List<Jogo> j) {
        if(j.size() < 1) System.out.println("Não há jogos.");
        else {
            for (int i = 0; i < j.size(); i++) {
                System.out.println("[" + (i+1) + "] " + j.get(i).getNome());
            }
        }
    }

    private static void input(String s, Usuario u, Loja l) {
        Scanner scanner = new Scanner(System.in);
        
        if(s == "Adicionar dinheiro")
        {
            System.out.println("Quanto você quer adicionar ?");
            u.addDinheiroCarteira(scanner.nextInt());
            System.out.println("Carteira atualizada, agora você tem " + u.getCarteira() + " dinheiros.");
        }
        else if(s == "Gênero")
        {
            System.out.println("Digite uma das opções de gênero a seguir. {Ação, Aventura, Tiro}");
            showGameList(l.Busca(scanner.nextLine()));
        }
        else if(s == "Preço máximo")
        {
            System.out.println("Digite um valor máximo de preço.");
            showGameList(l.Busca(scanner.nextInt()));
        }
    }

    private static void title(String t) {
        System.out.println("================");
        System.out.println(t);
        System.out.println("================");
      }
      
    private static String options(List<String> ops) {
        for (int i = 0; i < ops.size(); i++) {
          System.out.println("[" + (i+1) + "] " + ops.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        try {
          return ops.get(scanner.nextInt()-1);
        } catch (Exception e) {
          System.out.println("Tente novamente.");
          return options(ops);
        }
      }

      /*private static String createRandomGames(Loja l) {
        int ver = 1;
        String s = "";
        for (int i = 0; i < 3; i++) {
            Produtora produtora = new Produtora();
            for (int j = 0; j < 5; j++) {
                produtora.criarJogo("Jogo " + ver, "Ação", i*j);
                ver++;
            }
            l.adicionarJogosProdutora(produtora);
        }
      }*/
      
      public enum Page {
        HOME, ACCOUNT, STORE, BASKET, GAMEFILTER
      }
      
      public static void main(String args[]) {
        boolean RUNNING = true;
        Page PAGE = Page.HOME;

        Usuario user = new Usuario();
        Loja loja = new Loja();

        //createRandomGames(loja);
        
        while (RUNNING == true) {
      
          if (PAGE == Page.HOME) {
            title("Bem-vindo!");
            String chosen = options(List.of("Minha conta", "Loja", "Sair"));
            if (chosen == "Minha conta") PAGE = Page.ACCOUNT;
            else if (chosen == "Loja") PAGE = Page.STORE;
            else if (chosen == "Sair") RUNNING = false;
          }
          
          if (PAGE == Page.ACCOUNT) {
            title("Essa é sua conta");
            String chosen = options(List.of("Ver meus jogos", "Adicionar dinheiro", "Voltar"));
            if (chosen == "Ver meus jogos") showGameList(user.getBiblioteca());
            else if (chosen == "Adicionar dinheiro") input(chosen, user, loja);
            else if (chosen == "Voltar") PAGE = Page.HOME;
          }
      
          if (PAGE == Page.STORE) {
            title("Loja de jogos LP2");
            String chosen = options(List.of("Ver jogos", "Ver Carrinho", "Voltar"));
            if (chosen == "Ver jogos") PAGE = Page.GAMEFILTER;
            else if (chosen == "Ver Carrinho") PAGE = Page.BASKET;
            else if (chosen == "Voltar") PAGE = Page.HOME;
          }

          if (PAGE == Page.GAMEFILTER) {
            title("Busca de jogos");
            String chosen = options(List.of("Gênero", "Preço máximo", "Voltar"));
            if (chosen == "Gênero") input(chosen, user);
            else if (chosen == "Preço máximo") input(chosen, user, loja);
            else if (chosen == "Voltar") PAGE = Page.STORE;
          }

          if (PAGE == Page.BASKET) {
            title("Loja de jogos LP2");
            String chosen = options(List.of("Ver jogos", "Adicionar dinheiro", "Voltar"));
            if (chosen == "Ver meus jogos") showGameList(user.getBiblioteca());
            else if (chosen == "Adicionar dinheiro") input(chosen, user, loja);
            else if (chosen == "Voltar") PAGE = Page.HOME;
          }
      
        }
      
      }
}

>>>>>>> Stashed changes
