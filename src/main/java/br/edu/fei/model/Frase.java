/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model; //pacote

/**
 * Classe das frases do programa
 * @author feispkluongo
 */
public class Frase {
    private final String texto; //ve o texto 

    //construtor da frase
    public Frase(String texto) {
        this.texto = texto; //recebe o texto da própria frase como parametro
    }
    
    //get da frase
    public String getTexto() {
        return texto; //retorna a frase
    }
    
    /**
     * compara a frase do txt com a digitada pelo jogador
     * @param digitado
     * @return 
     */
    public boolean comparar(String digitado) {
        return texto.equals(digitado); //diz verdadeiro se forem iguais e falso se for diferente
    }

}
