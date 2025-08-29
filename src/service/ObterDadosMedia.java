package service;

import exceptions.CancelOperation;

import javax.swing.*;

public class ObterDadosMedia {

    //Aqui você irá inserir os dados solicitados que serão utilizados na classse "AddMedia"

    /*Objeto é criado com o intuito de obter todos os valores em um único item, Sem a necessitar a inserção de muitas variáveis distintas.
    O mesmo irá armazenar todos os valores como uma "Mini Lista"*/
    public static Object[] obterDadosMedia () throws CancelOperation {
        //Ele irá retornar os seguintes valores armazenados
        String titulo;
        while (true) {

            titulo = JOptionPane.showInputDialog(null, "Insira o titulo: ");

            if (titulo == null) {
                int exit = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                if (exit == JOptionPane.YES_OPTION) {
                    throw new CancelOperation();
                }
                continue;
            }
            try {
                if (titulo.isBlank()){
                    continue;
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Por favor insira uma opção válida.");
            }
            break;
        }

        String artista = "";

        while (!titulo.isBlank()) {

            artista = JOptionPane.showInputDialog(null, "Insira o artista: ");

            if (artista == null) {
                int exit = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                if (exit == JOptionPane.YES_OPTION) {
                    throw new CancelOperation();
                }
                continue;
            }
            try {
                if (artista.isEmpty()){
                    continue;
                }
            } catch (NullPointerException e) {
                if (artista == null){
                    JOptionPane.showMessageDialog(null, "Por favor insira uma opção válida.");
                }
            }
            break;
        }

        int minutos = 0;

        while (true) {
            String input = JOptionPane.showInputDialog(null, "Insira a quantidade de minutos:");

            if (input == null) {
                int exit = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                if (exit == JOptionPane.YES_OPTION) {
                    throw new CancelOperation();
                }
                continue;
            }

            try {
                minutos = Integer.parseInt(input);

                if (minutos == -1) {
                    int exit = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                    if (exit == JOptionPane.YES_OPTION) {
                        throw new CancelOperation();
                    }
                    continue;
                }

                if (minutos >= Integer.MAX_VALUE) {
                    continue;
                } else {
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor insira um número válido.");
            }
        }

        int segundos = 0;

        while (true) {
            String input = JOptionPane.showInputDialog(null, "Insira a quantidade de segundos:");

            if (input == null) {
                int exit = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                if (exit == JOptionPane.YES_OPTION) {
                    throw new CancelOperation();
                }
                continue;
            }

            try {
                segundos = Integer.parseInt(input);

                if (segundos == -1) {
                    int exit = JOptionPane.showConfirmDialog(null, "Deseja cancelar?");
                    if (exit == JOptionPane.YES_OPTION) {
                        throw new CancelOperation();
                    }
                    continue;
                }

                if (segundos < 0 || segundos > 59) {
                    JOptionPane.showMessageDialog(null, "Por favor insira um valor");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor insira um número válido.");
            }
        }

        if (!titulo.isBlank() && !artista.isEmpty() && minutos != -1 && segundos != -1) {

            return new Object[]{titulo, artista, minutos, segundos};
        }
        return new Object[0];
    }
}