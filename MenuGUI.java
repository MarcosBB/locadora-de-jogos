import javax.swing.*;

public class MenuGUI extends JFrame {
    protected Usuario usuario;
    protected Loja loja;
    protected CarrinhoGUI carrinhoGUI;
    protected UsuarioGUI usuarioGUI;

    public MenuGUI(Usuario usuario, Loja loja) {
        this.usuario = usuario;
        this.loja = loja;

        JMenuBar menuBar = new JMenuBar();

        JMenu userMenu = new JMenu("Usuário");
        JMenuItem bibliotecaMenuItem = new JMenuItem("Biblioteca");
        JMenuItem perfilMenuItem = new JMenuItem("Perfil");
        userMenu.add(bibliotecaMenuItem);
        userMenu.add(perfilMenuItem);
        menuBar.add(userMenu);

        JMenu storeMenu = new JMenu("Loja");
        JMenuItem BuscarJogoMenuItem = new JMenuItem("Buscar Jogo");
        JMenuItem carrinhoMenuItem = new JMenuItem("Carrinho");
        storeMenu.add(BuscarJogoMenuItem);
        storeMenu.add(carrinhoMenuItem);
        menuBar.add(storeMenu);

        setJMenuBar(menuBar);

        carrinhoMenuItem.addActionListener(e -> {
            showCarrinho();
        });

        perfilMenuItem.addActionListener(e -> {
            showUsuario();
        });
    }

    private void showCarrinho() {
        if (carrinhoGUI == null) {
            carrinhoGUI = new CarrinhoGUI(usuario, loja, usuarioGUI);
        } else {
            carrinhoGUI.updateCartContent();
        }
        carrinhoGUI.setVisible(true);
    }

    private void showUsuario() {
        if (usuarioGUI == null) {
            usuarioGUI = new UsuarioGUI(usuario);
        } else {
            usuarioGUI.updateUsuarioContent();
        }
        usuarioGUI.setVisible(true);

    }
}
