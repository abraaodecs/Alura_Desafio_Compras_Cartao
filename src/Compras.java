import java.lang.Comparable;
import java.lang.Double;

public class Compras implements Comparable<Compras> {
    String produto;
    Double valor;
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public java.lang.Double getValor() {
        return valor;
    }

    public void setValor(java.lang.Double valor) {
        this.valor = valor;
    }
    public String toString() {
        return this.produto + " - R$ " + this.valor;
    }

    @java.lang.Override
    public int compareTo(Compras outroCompras) {
        return this.valor.compareTo(outroCompras.valor);
    }
}
