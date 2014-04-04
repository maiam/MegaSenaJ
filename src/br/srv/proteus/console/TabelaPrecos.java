package br.srv.proteus.console;

public class TabelaPrecos {

    private static double valorDaAposta = 2; //dois reais

    private static int[] qtdApostas = {
        
        1, 7, 28, 84, 210, 462, 924, 1716, 3003, 5005
    };

    private TabelaPrecos() {

        //bloqueia a construcao de objetos dessa classe
    }

    public static double obterPreco(int qtdeNumeros) {

        double retorno = 0;
        if (qtdeNumeros >= 6 && qtdeNumeros <= 15) {

            retorno = qtdApostas[qtdeNumeros - 6] * valorDaAposta;
        }
        return retorno;
    }
}
