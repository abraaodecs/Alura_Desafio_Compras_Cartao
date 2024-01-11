import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Comparator;

public class Principal {
    public static void main(String[] args) {
        double totalValor = 0;
        double saldoCartao = 0;
        int menu = 1;
        int j = 0;

        System.out.println("Digite o limite do cartão: ");
        Scanner limite = new Scanner(System.in);
        double limiteCartao = limite.nextDouble();

        List<Compras> comprasCartao = new ArrayList<Compras>();

        while (menu == 1) {
            System.out.println("Digite a descrição da compra: ");
            Scanner produto = new Scanner(System.in);
            String nomeProduto = produto.nextLine();

            System.out.println("Digite o valor da compra: ");
            Scanner preco = new Scanner(System.in);
            Double valor = preco.nextDouble();

            if (j == 0) {
                saldoCartao = limiteCartao - valor;
            } else {
                saldoCartao -= valor;
            }

            if (saldoCartao < 0) {
                System.out.println("Saldo insuficiente!");
                menu = 0;
            } else {
                comprasCartao.add(new Compras());
                comprasCartao.get(j).setProduto(nomeProduto);
                comprasCartao.get(j).setValor(valor);

                j++;

                System.out.println("Digite 1 para continuar ou 0 para sair: ");
                Scanner opcao = new Scanner(System.in);
                menu = opcao.nextInt();
            }
        }

        // Ordenar as compras em ordem crescente pelo valor
        comprasCartao.sort(Comparator.comparing(Compras::getValor));

        // Exibir os valores de cada compra, após ordenação
        System.out.println("******************************");
        System.out.println("COMPRAS REALIZADAS");
        for (int i = 0; i < j; i++) {
            System.out.println(comprasCartao.get(i));
            totalValor += comprasCartao.get(i).getValor();
        }

        saldoCartao = limiteCartao - totalValor;

        System.out.println("------------------------------");
        System.out.println("Valor total das compras: R$ " + totalValor);
        System.out.println("\nSaldo do cartão: R$ " + saldoCartao);
        System.out.println("******************************");

    }

}
