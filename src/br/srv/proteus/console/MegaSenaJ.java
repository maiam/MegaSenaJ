package br.srv.proteus.console;

import javax.swing.JOptionPane;

public class MegaSenaJ {

    public static void main(String[] args) {

        boolean ok = false;
        while (!ok) {

            String sValor = JOptionPane.showInputDialog("Digite o valor arrecadado...");
            if (sValor != null && sValor.length() > 0 && (sValor.matches("[0-9]*") || sValor.matches("[0-9]*\\.[0-9]*"))) {

                ok = true;
                Bolao bolao = new Bolao(Double.parseDouble(sValor));
                JOptionPane.showMessageDialog(null, bolao.toString());

            } else {

                JOptionPane.showMessageDialog(null, "ERRO: valor inválido. Use ponto para os centavos.");
            }
        }
    }
}
