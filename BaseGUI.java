import javax.swing.*;

public class BaseGUI extends JFrame {
    protected Usuario usuario;
    protected Loja loja;
    protected CarrinhoGUI carrinhoGUI;

    public BaseGUI(Usuario usuario, Loja loja) {
        this.usuario = usuario;
        this.loja = loja;

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create User menu with sub-menu Biblioteca and Perfil
        JMenu userMenu = new JMenu("Usuário");
        JMenuItem bibliotecaMenuItem = new JMenuItem("Biblioteca");
        JMenuItem perfilMenuItem = new JMenuItem("Perfil");
        userMenu.add(bibliotecaMenuItem);
        userMenu.add(perfilMenuItem);
        menuBar.add(userMenu);

        // Create Store menu with sub-menu Catálogo and Carrinho
        JMenu storeMenu = new JMenu("Loja");
        JMenuItem BuscarJogoMenuItem = new JMenuItem("Buscar Jogo");
        JMenuItem carrinhoMenuItem = new JMenuItem("Carrinho");
        storeMenu.add(BuscarJogoMenuItem);
        storeMenu.add(carrinhoMenuItem);
        menuBar.add(storeMenu);

        // Add the menu bar to the frame
        setJMenuBar(menuBar);

        carrinhoMenuItem.addActionListener(e -> {
            // Open the shopping cart page
            showCarrinho();
        });
    }

    private void showCarrinho() {
        if (carrinhoGUI == null) {
            carrinhoGUI = new CarrinhoGUI(usuario, loja);
        } else {
            carrinhoGUI.updateCartContent();
        }
        carrinhoGUI.setVisible(true);
    }
}
