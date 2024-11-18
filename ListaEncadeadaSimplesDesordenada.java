public class ListaEncadeadaSimplesDesordenada<X> implements Cloneable {
    private class No implements Cloneable {
        private X info;
        private No prox;

        public No(X i, No p) {
            this.info = i;
            this.prox = p;
        }

        public No(X i) {
            this.info = i;
            this.prox = null;
        }

        public X getInfo() {
            return this.info;
        }

        public No getProx() {
            return this.prox;
        }

        public void setInfo(X i) {
            this.info = i;
        }

        public void setProx(No p) {
            this.prox = p;
        }
    }

    private No primeiro;

    public ListaEncadeadaSimplesDesordenada() {
        this.primeiro = null;
    }

    public void guardeNoInicio(X i) throws Exception {
        if (i == null)
            throw new Exception("Informação ausente");

        X copia = i;
        this.primeiro = new No(copia, this.primeiro);
    }

    public void removaDoInicio() throws Exception {
        if (this.primeiro == null)
            throw new Exception("Nada a remover");

        this.primeiro = this.primeiro.getProx();
    }

    public boolean isVazia() {
        return this.primeiro == null;
    }

    public X recupereDoInicio() throws Exception {
        if (this.primeiro == null)
            throw new Exception("Nada a recuperar");

        return this.primeiro.getInfo();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();

        for (No atual = this.primeiro; atual != null; atual = atual.getProx())
            ret.append(atual.getInfo()).append("\n");

        return ret.toString();
    }
}
