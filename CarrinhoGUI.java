import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CarrinhoGUI extends BaseGUI {
    private JLabel lblTotal;
    private DefaultTableModel model;

    public CarrinhoGUI(Usuario usuario, Loja loja) {
        super(usuario, loja);

        setTitle("Carrinho de Compras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the table to display the shopping cart items
        String[] colunas = { "Nome", "Preço" };
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
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        updateCartContent();
    }

    public void updateCartContent() {
        // Clear the current content of the table
        List<Joguin> jogosNoCarrinho = usuario.mostrarJogosNoCarrinho();
        model.setRowCount(0);

        for (Joguin jogo : jogosNoCarrinho) {
            model.addRow(new Object[] { jogo.getNome(), jogo.getPreco() });
        }

        lblTotal.setText("Total: R$" + String.format("%.2f", usuario.calcularTotal()));
    }

}
