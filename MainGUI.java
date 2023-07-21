import java.io.File;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class MainGUI {
    public static void main(String[] args) {
        Produtora produtora = new Produtora("Peter games", 0000);
        Usuario usuario = new Usuario("João", 18, "joaozinhozikadopantano@gmail.com");
        Loja loja = new Loja("Loja LP2", 711230911);

        System.out.println("Importando jogos...");
        try {
            Scanner txtscanner = new Scanner(new File("jogos.txt"));

            while (txtscanner.hasNextLine()) {
                String nome = txtscanner.nextLine();
                String genero = txtscanner.nextLine();
                String preco = txtscanner.nextLine();

                try {
                    produtora.criarJogo(nome, genero, Float.parseFloat(preco));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            loja.adicionarJogosProdutora(produtora);
            System.out.println("Importação concluída!");

        } catch (Exception e) {
            System.out.println("Erro ao importar jogos!");
            System.out.println(e);
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LojaGUI(loja, usuario).setVisible(true);
            }
        });
    }
}
