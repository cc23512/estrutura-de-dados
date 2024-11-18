public class Calculadora {
    public static double avaliarPosfixa(Fila<String> posfixa) throws Exception {
        Pilha<Double> resultados = new Pilha<>(posfixa.toString().length());

        while (!posfixa.isVazia()) {
            String token = posfixa.recupereUmItem();
            posfixa.removaUmItem();

            if (isNumero(token)) {
                resultados.guardeUmItem(Double.parseDouble(token));
            } else if (isOperador(token)) {
                double v2 = resultados.recupereUmItem();
                resultados.removaUmItem();
                double v1 = resultados.recupereUmItem();
                resultados.removaUmItem();
                resultados.guardeUmItem(calcular(v1, v2, token));
            } else {
                throw new Exception("Token inválido: " + token);
            }
        }

        return resultados.recupereUmItem();
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

    private static double calcular(double v1, double v2, String operador) {
        switch (operador) {
            case "+": return v1 + v2;
            case "-": return v1 - v2;
            case "*": return v1 * v2;
            case "/": return v1 / v2;
            case "^": return Math.pow(v1, v2);
            default: throw new RuntimeException("Operador desconhecido: " + operador);
        }
    }
}
