
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LojaGUI extends BaseGUI {
    public LojaGUI(Loja loja, Usuario usuario) {
        super(usuario, loja);
        List<Joguin> jogosDisponiveis = loja.getJogosDisponiveis();

        setTitle("Loja de Jogos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Criação da tabela com os jogos
        String[] colunas = { "Nome", "Preço", "Adicionar ao Carrinho" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        for (Joguin jogo : jogosDisponiveis) {
            model.addRow(new Object[] { jogo.getNome(), jogo.getPreco(), "Adicionar" });
        }

        JTable table = new JTable(model);
        TableColumn buttonColumn = table.getColumnModel().getColumn(2);
        buttonColumn.setCellRenderer(new ButtonRenderer());
        buttonColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
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
                Joguin jogo = loja.getJogosDisponiveis().get(selectedRow);
                usuario.adicionarJogoNoCarrinho(jogo);
                JOptionPane.showMessageDialog(LojaGUI.this,
                        "Jogo \"" + jogo.getNome() + "\" adicionado ao carrinho!");

                if (carrinhoGUI != null)
                    carrinhoGUI.updateCartContent();
            }
            isPushed = false;
            return label;
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
