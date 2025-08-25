package service;

import javax.swing.*;

public class ObterDadosMedia {

    //Aqui você irá inserir os dados solicitados que serão utilizados na classse "AddMedia"

    /*Objeto é criado com o intuito de obter todos os valores em um único item, Sem a necessitar a inserção de muitas variáveis distintas.
    O mesmo irá armazenar todos os valores como uma "Mini Lista"*/
    public static Object[] obterDadosMedia (){

        //Ele irá retornar os seguintes valores armazenados
        String titulo = JOptionPane.showInputDialog(null, "Insira o titulo: ");
        String artista = JOptionPane.showInputDialog(null, "Insira o artista: ");
        int minutos = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de minutos: "));
        int segundos = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a quantidade de segundos: "));
        return new Object[]{titulo, artista, minutos, segundos};
    }
}