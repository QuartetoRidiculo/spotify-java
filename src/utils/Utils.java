package utils;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public class Utils {
    public static Scanner scanner;

    public static int exibirMenu(List<String> opcoesMenu) {
        String[] opcoesArray = opcoesMenu.toArray(new String[0]);

        JList<String> listaOpcoes = new JList<>(opcoesArray);
        listaOpcoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaOpcoes.setVisibleRowCount(Math.min(opcoesArray.length, 10));
        listaOpcoes.setFont(new Font("Arial", Font.PLAIN, 18));

        JScrollPane scrollPane = new JScrollPane(listaOpcoes);
        scrollPane.setPreferredSize(new Dimension(400, 220));

        int resposta = JOptionPane.showConfirmDialog(
                null,
                scrollPane,
                "Escolha um serviço:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (resposta == JOptionPane.OK_OPTION) {
            int selecionado = listaOpcoes.getSelectedIndex();
            return (selecionado != -1) ? selecionado : -2; // OK mas nada selecionado
        }

        return -1;
    }

}