import java.util.*;

public class automato {
    private enum Estado { INICIAL, S, T, U }

    private static Set<Estado> proximoEstado(Set<Estado> estadosAtuais, char simboloEntrada) {
        Set<Estado> proximosEstados = new HashSet<>();

        for (Estado estado : estadosAtuais) {
            switch (estado) {
                case INICIAL -> {
                    if (simboloEntrada == 'a') proximosEstados.add(Estado.S);
                    else if (simboloEntrada == 'b') proximosEstados.add(Estado.U);
                }
                case S -> {
                    if (simboloEntrada == 'a') proximosEstados.add(Estado.INICIAL);
                    else if (simboloEntrada == 'b') proximosEstados.add(Estado.T);
                }
                case T -> {
                    if (simboloEntrada == 'a') proximosEstados.add(Estado.U);
                    else if (simboloEntrada == 'b') proximosEstados.add(Estado.S);
                }
                case U -> {
                    if (simboloEntrada == 'a') proximosEstados.add(Estado.T);
                    else if (simboloEntrada == 'b') proximosEstados.add(Estado.INICIAL);
                }
            }
        }
        return proximosEstados;
    }

    public static String obterCaminho(String palavra) {
        Set<Estado> estadosAtuais = new HashSet<>();
        estadosAtuais.add(Estado.INICIAL);

        List<String> caminho = new ArrayList<>();
        caminho.add(estadosAtuais.toString());

        for (char simbolo : palavra.toCharArray()) {
            estadosAtuais = proximoEstado(estadosAtuais, simbolo);
            caminho.add(estadosAtuais.toString()); 
        }

        return "w => " + String.join(" -> ", caminho);
    }

    public static boolean aceitaPalavra(String palavra) {
        Set<Estado> estadosAtuais = new HashSet<>();
        estadosAtuais.add(Estado.INICIAL);

        for (char simbolo : palavra.toCharArray()) {
            estadosAtuais = proximoEstado(estadosAtuais, simbolo);
        }

        return estadosAtuais.contains(Estado.INICIAL);
    }

    public static void main(String[] args) {
        try (Scanner leitor = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("Digite uma palavra composta por 'a' e 'b': ");
                    String palavra = leitor.nextLine();

                    if (!palavra.matches("[ab]+")) {
                        throw new InputMismatchException("A palavra deve conter apenas 'a' e 'b'");
                    }

                    String caminho = obterCaminho(palavra);
                    boolean aceita = aceitaPalavra(palavra);

                    System.out.println("Palavra: " + palavra + " -> " + (aceita ? "Aceita" : "Rejeitada") + " | Caminho: " + caminho);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: " + e.getMessage());
                    System.out.println("Por favor, tente novamente.");
                    leitor.nextLine(); 
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                    break; 
                }
            }
        }
    }
}