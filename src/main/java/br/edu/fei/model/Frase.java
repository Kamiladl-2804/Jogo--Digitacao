/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

/**
 *
 * @author feispkluongo
 */
public class Frase {
    private final String texto;

    public Frase(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public boolean comparar(String digitado) {
        return texto.equals(digitado);
    }

}
