/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.fei.jogodigitacao; //pacote

import br.edu.fei.view.TelaDigitacao; // impotar TelaDigitacao

/**
 * classe main do programa
 * @author kamil
 */
public class JogoDigitacao {
    //método que inicia o programa
    public static void main(String[] args) {
        TelaDigitacao tela = new TelaDigitacao();//cia a tela principal
        tela.setVisible(true); //mostra a tela
    }
}
