import java.util.StringTokenizer;

public class Conversor {
    public static Fila<String> converterParaPosfixa(String expressao) throws Exception {
        Pilha<String> operadores = new Pilha<>(expressao.length());
        Fila<String> saida = new Fila<>(expressao.length());

        StringTokenizer quebrador = new StringTokenizer(expressao, "+-*/^()", true);

        while (quebrador.hasMoreTokens()) {
            String token = quebrador.nextToken();

            if (isNumero(token)) {
                saida.guardeUmItem(token);
            } else if (token.equals("(")) {
                operadores.guardeUmItem(token);
            } else if (token.equals(")")) {
                while (!operadores.isVazia() && !operadores.recupereUmItem().equals("(")) {
                    saida.guardeUmItem(operadores.recupereUmItem());
                    operadores.removaUmItem();
                }
                operadores.removaUmItem();
            } else if (isOperador(token)) {
                while (!operadores.isVazia() &&
                       precedencia(operadores.recupereUmItem()) >= precedencia(token)) {
                    saida.guardeUmItem(operadores.recupereUmItem());
                    operadores.removaUmItem();
                }
                operadores.guardeUmItem(token);
            } else {
                throw new Exception("Token inválido: " + token);
            }
        }

        while (!operadores.isVazia()) {
            saida.guardeUmItem(operadores.recupereUmItem());
            operadores.removaUmItem();
        }

        return saida;
    }

    private static boolean isNumero(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperador(String token) {
        return "+-*/^".contains(token);
    }

    private static int precedencia(String operador) {
        switch (operador) {
            case "^": return 3;
            case "*": case "/": return 2;
            case "+": case "-": return 1;
            default: return 0;
        }
    }
}
