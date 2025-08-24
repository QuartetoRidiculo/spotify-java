package service;

import javax.swing.*;

public class ObterDadosMedia {

    public static Object[] obterDadosMedia (){

        String titulo = JOptionPane.showInputDialog(null, "Insira o titulo: ");
        String artista = JOptionPane.showInputDialog(null, "Insira o artista: ");
        int minutos = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de minutos: "));
        int segundos = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de segundos: "));
        return new Object[]{titulo, artista, minutos, segundos};
    }
}
