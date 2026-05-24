/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.controller; //pacote 

import br.edu.fei.model.Frase; // importar frase
import br.edu.fei.model.GerenciadorFrases; // importar GerenciadorFrases
import br.edu.fei.view.TelaDigitacao; // impotar TelaDigitacao
import java.awt.Color; // importa da biblioteca a classe que trata cores

import java.util.ArrayList; // importa a classe de lista dinâmica

import javax.swing.JOptionPane; // importa da biblioteca de swing que trata as mensagens
/**
 *
 * @author feispkluongo
 */


public final class JogoController {

    private final GerenciadorFrases gerenciador; //chama o gerenciador
    private final ArrayList<Frase> frases; //para listas de frases

    private int indice; //indice da frase 
    private int score; // score de acertos

    private final TelaDigitacao tela; //tela

    /**
     * construtor que controla a dinâmica do jogo
     * @param tela 
     */
    public JogoController(TelaDigitacao tela) {
        
        this.tela = tela; //tela

        gerenciador = new GerenciadorFrases(); //cria gerenciador de frases

        frases = gerenciador.getFrases(); //gerencia as frases do arquivo frases

        indice = 0; //começa com o indice zerado
        score = 0; //começa com o score zerado

        mostrarFrase(); //mostra a frase
    }

    /**
     * método que mostra a frase
     */
    public void mostrarFrase() {
        //olha se ainda tem frases para ser mostrada
        if (indice < frases.size()) {

            tela.setFrase(frases.get(indice).getTexto()); //mostra a frase atual 

        } else {

            finalizarJogo(); //finaliza quando acaba das frases
        }
    }

    /**
     * método que olha se a fraze ta certa ou não
     * @param digitado 
     */
    public void verificarFrase(String digitado) {

        Frase fraseAtual = frases.get(indice); //olha a frase atual
        
        //compara a frase atual com a digitada
        if (fraseAtual.comparar(digitado)) {

            //mensagem de acerto
            JOptionPane.showMessageDialog(
                tela,
                "Correto!"
            );

            score++; //soma 1 no score
            
         //se não, mostra mensagem de erro
        } else {

            JOptionPane.showMessageDialog(
                    tela,
                    "Errado!"
            );
        }

        indice++; //vai para a próxima frase

        tela.limparTexto(); //apaga o que foi digitado antes

        mostrarFrase(); //mostra a frase
    }

    /**
     * método que finaliza o jogo
     */
    private void finalizarJogo() {

        gerenciador.salvarRecorde(score); //salva o score

        int recorde = gerenciador.lerRecorde(); //olha o maior score
        
        //mostra o score do jogo atual e o maior que ja teve
        JOptionPane.showMessageDialog(
                tela,
                "Fim do jogo\\n"
                + "Score: " + score
                + "\nRecorde: " + recorde
        );

        System.exit(0); //termina 
    }
    
    /**
     * método para as cores
     */
    public void verificarCor() {

        Frase fraseAtual = frases.get(indice);//frase atuala

        String digitado = tela.getTextoDigitado(); //texto digitado
        
        //verificar se esta correto
        if (fraseAtual.comparar(digitado)) {

            tela.mudarCorTexto(Color.GREEN);//se estiver fica verde

        } else {

            tela.mudarCorTexto(Color.RED); //se não fica vermelho
        }
    }

}

