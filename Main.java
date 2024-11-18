import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma expressão aritmética:");
        String expressao = scanner.nextLine().replaceAll("\\s+", "");

        try {
            Fila<String> posfixa = Conversor.converterParaPosfixa(expressao);
            System.out.println("Expressão em notação pós-fixa: " + posfixa);

            double resultado = Calculadora.avaliarPosfixa(posfixa);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

        scanner.close();
    }
}
