import java.util.List;
import java.util.ArrayList;

public class Usuario
{
    public List<Jogo> Carrinho;
    

    public Usuario()
    {
        Carrinho = new ArrayList<Jogo>();
    }
    
    public void setCarrinho(List<Jogo> carrinho)
    {
        this.Carrinho = carrinho;
    }
    
    public List<Jogo> getCarrinho()
    {
        return this.Carrinho;
    }
}
