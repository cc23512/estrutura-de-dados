public class Pilha<X> {
    private Object[] elemento;
    private int tamanhoInicial;
    private int ultimo = -1;

    public Pilha(int tamanho) throws Exception {
        if (tamanho <= 0)
            throw new Exception("Tamanho inválido");

        this.elemento = new Object[tamanho];
        this.tamanhoInicial = tamanho;
    }

    public Pilha() {
        this.elemento = new Object[10];
        this.tamanhoInicial = 10;
    }

    public void guardeUmItem(X x) throws Exception {
        if (x == null)
            throw new Exception("Falta o que guardar");

        if (this.ultimo + 1 == this.elemento.length)
            redimensioneSe(2.0F);

        this.ultimo++;
        this.elemento[this.ultimo] = x;
    }

    public X recupereUmItem() throws Exception {
        if (this.ultimo == -1)
            throw new Exception("Nada a recuperar");

        return (X) this.elemento[this.ultimo];
    }

    public void removaUmItem() throws Exception {
        if (this.ultimo == -1)
            throw new Exception("Nada a remover");

        this.elemento[this.ultimo] = null;
        this.ultimo--;

        if (this.elemento.length > this.tamanhoInicial &&
                this.ultimo + 1 <= Math.round(this.elemento.length * 0.25F))
            redimensioneSe(0.5F);
    }

    private void redimensioneSe(float fator) {
        Object[] novo = new Object[(int) Math.ceil(this.elemento.length * fator)];
        for (int i = 0; i <= this.ultimo; i++)
            novo[i] = this.elemento[i];
        this.elemento = novo;
    }

    public boolean isVazia() {
        return this.ultimo == -1;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i <= this.ultimo; i++) {
            ret.append(this.elemento[i]).append(" ");
        }
        return ret.toString().trim();
    }
}
