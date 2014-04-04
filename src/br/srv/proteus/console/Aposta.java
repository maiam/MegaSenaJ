package br.srv.proteus.console;

import java.text.NumberFormat;
import java.util.Arrays;

public class Aposta {

    private int[] numeros;
    private double preco;

    public Aposta(int qtde) {
        
        if (qtde >= 6 && qtde <= 15) {
            
            this.numeros = new int[qtde];
            for (int i = 0; i < this.numeros.length; i++) {
                
                boolean ok = false;
                int num = 0;
                while (!ok) {
                    
                    num = (int) (Math.random() * 60) + 1;
                    for (int j = i; j >= 0; j--) {
                        
                        if (num != numeros[j]) {
                            
                            ok = true;
                        } else {
                            
                            ok = false;
                            break;
                        }
                    }
                }
                numeros[i] = num;
            }
            // coloca os números em ordem
            Arrays.sort(numeros);
            //inicializa o preco
            this.preco = TabelaPrecos.obterPreco(qtde);
        }
    }

    @Override
    public String toString() {
        
        StringBuffer retorno = new StringBuffer();
        retorno.append(String.format("%2.2s ---> ", numeros.length));
        if (this.numeros != null) {
            
            for (int i = 0; i < this.numeros.length; i++) {
                
                retorno.append(String.format("[%2.2s]", this.numeros[i]));
                if (i < this.numeros.length - 1) {
                    
                    retorno.append(" ");
                }
            }
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            retorno.append(" = ");
            retorno.append(nf.format(this.preco));
        }
        return retorno.toString();
    }

    public int[] getNumeros() {
        
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        
        this.numeros = numeros;
    }

    public double getPreco() {
        
        return preco;
    }

    public void setPreco(double preco) {
        
        this.preco = preco;
    }
}
