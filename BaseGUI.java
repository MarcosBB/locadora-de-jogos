import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseGUI extends JFrame {
    protected Usuario usuario;
    protected Loja loja;
    private CarrinhoGUI carrinhoGUI;

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

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            selectedRow = row;
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                adicionarAoCarrinho(selectedRow);
            }
            isPushed = false;
            return label;
        }

        private void adicionarAoCarrinho(int row) {
            Joguin jogo = loja.getJogosDisponiveis().get(row);
            usuario.adicionarJogoNoCarrinho(jogo);
            JOptionPane.showMessageDialog(BaseGUI.this,
                    "Jogo \"" + jogo.getNome() + "\" adicionado ao carrinho!");

            if (carrinhoGUI != null)
                carrinhoGUI.updateCartContent();
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
