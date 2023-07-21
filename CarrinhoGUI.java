import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CarrinhoGUI extends BaseGUI {

    public CarrinhoGUI(Usuario usuario, Loja loja) {
        super(usuario, loja);
        List<Joguin> jogosNoCarrinho = usuario.mostrarJogosNoCarrinho();

        setTitle("Carrinho de Compras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the table to display the shopping cart items
        String[] colunas = { "Nome", "Preço" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        double totalPreco = usuario.calcularTotal();
        for (Joguin jogo : jogosNoCarrinho) {
            model.addRow(new Object[] { jogo.getNome(), jogo.getPreco() });
        }

        JTable table = new JTable(model);

        // Create a panel to display the total price and finalize button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2, 10, 0)); // 1 row, 2 columns, horizontal gap of 10
        bottomPanel.add(new JLabel("Total: R$" + String.format("%.2f", totalPreco)));

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
    }
}
