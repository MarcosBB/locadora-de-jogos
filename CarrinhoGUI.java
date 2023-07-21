import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.List;

public class CarrinhoGUI extends JFrame {
    private JLabel lblTotal;
    private DefaultTableModel model;
    private Usuario usuario;

    public CarrinhoGUI(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Carrinho de Compras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the table to display the shopping cart items
        String[] colunas = { "Nome", "Preço", "Remover do Carrinho" };
        model = new DefaultTableModel(colunas, 0);

        JTable table = new JTable(model);

        // Create a panel to display the total price and finalize button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2, 10, 0)); // 1 row, 2 columns, horizontal gap of 10
        lblTotal = new JLabel("Total: R$0.00");

        // Create the button to finalize the purchase
        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
            dispose(); // Close the cart window after purchase is completed
        });

        bottomPanel.add(btnFinalizarCompra);

        // Add the components to the frame
        setLayout(new BorderLayout());
        TableColumn buttonColumn = table.getColumnModel().getColumn(2);
        buttonColumn.setCellRenderer(new ButtonRenderer());
        buttonColumn.setCellEditor(new ButtonEditor(new JCheckBox()));
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        updateCartContent();
    }

    public void updateCartContent() {
        // Clear the current content of the table
        List<Joguin> jogosNoCarrinho = usuario.mostrarJogosNoCarrinho();
        model.setRowCount(0);

        for (Joguin jogo : jogosNoCarrinho) {
            model.addRow(new Object[] { jogo.getNome(), jogo.getPreco(), "Remover" });
        }

        lblTotal.setText("Total: R$" + String.format("%.2f", usuario.calcularTotal()));
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
                Joguin jogo = usuario.mostrarJogosNoCarrinho().get(selectedRow);
                usuario.removerJogoNoCarrinho(jogo);
                JOptionPane.showMessageDialog(CarrinhoGUI.this,
                        "Jogo \"" + jogo.getNome() + "\" removido do carrinho!");
                // updateCartContent();
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

    }

}
