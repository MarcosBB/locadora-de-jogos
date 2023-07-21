
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.List;

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

}
