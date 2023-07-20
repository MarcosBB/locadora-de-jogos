public class JogoAcao extends Joguin{
    public JogoAcao(String nome, String genero, float preco, Produtora produtora) {
        super(nome, genero, preco, produtora);
    }

    public void jogar()
    {
        System.out.println("Jogando com muita ação");
    }
}
