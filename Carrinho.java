interface Carrinho {
    void adicionarJogo(Jogo jogo);
    void removerJogo(Jogo jogo);
    double calcularTotal();
    void finalizarCompra();
}