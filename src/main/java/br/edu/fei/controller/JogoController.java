/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller;

import br.edu.fei.model.Frase;
import br.edu.fei.model.GerenciadorFrases;
import br.edu.fei.view.TelaDigitacao;
import java.awt.Color;

import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 *
 * @author feispkluongo
 */


public final class JogoController {

    private final GerenciadorFrases gerenciador;
    private final ArrayList<Frase> frases;

    private int indice;
    private int score;

    private final TelaDigitacao tela;

    public JogoController(TelaDigitacao tela) {

        this.tela = tela;

        gerenciador = new GerenciadorFrases();

        frases = gerenciador.getFrases();

        indice = 0;
        score = 0;

        mostrarFrase();
    }

    public void mostrarFrase() {

        if (indice < frases.size()) {

            tela.setFrase(
                    frases.get(indice).getTexto()
            );

        } else {

            finalizarJogo();
        }
    }

    public void verificarFrase(String digitado) {

        Frase fraseAtual = frases.get(indice);

        if (fraseAtual.comparar(digitado)) {

            JOptionPane.showMessageDialog(
                    tela,
                    "Correto!"
            );

            score++;

        } else {

            JOptionPane.showMessageDialog(
                    tela,
                    "Errado!"
            );
        }

        indice++;

        tela.limparTexto();

        mostrarFrase();
    }

    private void finalizarJogo() {

        gerenciador.salvarRecorde(score);

        int recorde = gerenciador.lerRecorde();

        JOptionPane.showMessageDialog(
                tela,
                "Fim do jogo\\n"
                + "Score: " + score
                + "\nRecorde: " + recorde
        );

        System.exit(0);
    }
    
    public void verificarCor() {

        Frase fraseAtual = frases.get(indice);

        String digitado = tela.getTextoDigitado();

        if (fraseAtual.comparar(digitado)) {

            tela.mudarCorTexto(Color.GREEN);

        } else {

            tela.mudarCorTexto(Color.RED);
        }
    }

}

