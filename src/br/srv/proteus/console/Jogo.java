package br.srv.proteus.console;

import java.text.NumberFormat;

public class Jogo {

    protected Aposta[] apostas;
    protected double preco;

    public Jogo(Aposta[] apostas) {
        
        this.setApostas(apostas);
    }

    public Aposta[] getApostas() {
        
        return apostas;
    }

    public void setApostas(Aposta[] apostas) {
        
        if (apostas != null) {
            
            this.preco = 0;
            for (int i = 0; i < apostas.length; i++) {
                
                this.preco += apostas[i].getPreco();
            }
        }
        this.apostas = apostas;
    }

    public double getPreco() {
        
        return preco;
    }

    public void setPreco(double preco) {
        
        this.preco = preco;
    }

    @Override
    public String toString() {
        
        StringBuffer sb = new StringBuffer();
        if (this.apostas != null) {
            
            for (int i = 0; i < apostas.length; i++) {
                
                sb.append(this.apostas[i].toString());
                sb.append("\n");
            }
            sb.append("Total do Jogo = ");
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            sb.append(nf.format(this.preco));
        }
        return sb.toString();
    }
}
