import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BibliotecaGUI extends JFrame {
    private Usuario usuario;
    private DefaultTableModel model;

    public BibliotecaGUI(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Loja de Jogos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);

        // Criação da tabela com os jogos
        String[] colunas = { "Nome", "Genero" };
        model = new DefaultTableModel(colunas, 0);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }

    public void updateBibliotecaContent() {
        List<Joguin> biblioteca = usuario.getBiblioteca();
        model.setRowCount(0);

        for (Joguin jogo : biblioteca) {
            model.addRow(new Object[] { jogo.getNome(), jogo.getGenero() });
        }
    }
}
