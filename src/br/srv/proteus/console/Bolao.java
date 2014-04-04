package br.srv.proteus.console;

import java.text.NumberFormat;

public class Bolao extends Jogo {

    private double valor;
    private double troco;

    public Bolao(double valor) {

        super(null);
        this.valor = valor;
        double sobra = valor;
        int[] tiposJogos = new int[10];
        int acumula = 0;
        for (int i = 15; i >= 6; i--) {

            int qtde = (int) (sobra / TabelaPrecos.obterPreco(i));
            if (qtde > 0) {

                tiposJogos[i - 6] = qtde;
                acumula += qtde;
            }
            sobra -= TabelaPrecos.obterPreco(i) * qtde;
        }
        this.troco = sobra;
        Aposta[] apostas = new Aposta[acumula];
        int indice = 0;
        for (int i = tiposJogos.length - 1; i >= 0; i--) {

            if (tiposJogos[i] > 0) {

                for (int j = 0; j < tiposJogos[i]; j++) {

                    apostas[indice] = new Aposta(i + 6);
                    indice++;
                }
            }
        }
        this.setApostas(apostas);
    }

    public double getValor() {

        return valor;
    }

    public void setValor(double valor) {

        this.valor = valor;
    }

    public double getTroco() {

        return troco;
    }

    public void setTroco(double troco) {

        this.troco = troco;
    }

    @Override
    public String toString() {

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return super.toString() + "\n" + "Troco = " + nf.format(this.troco);
    }
}
