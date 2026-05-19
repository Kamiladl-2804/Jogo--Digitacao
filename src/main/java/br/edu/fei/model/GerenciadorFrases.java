/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author feispkluongo
 */
public class GerenciadorFrases {
    private final ArrayList<Frase> frases;

    public GerenciadorFrases() {

        frases = new ArrayList<>();

        carregarFrases();
    }

    private void carregarFrases() {

        try {

            BufferedReader leitor = new BufferedReader(
                    new FileReader("frases.txt")
            );

            String linha;

            while ((linha = leitor.readLine()) != null) {

                frases.add(new Frase(linha));
            }

            leitor.close();

        } catch (IOException e) {

            System.out.println("Erro ao ler arquivo");
        }
    }

    public ArrayList<Frase> getFrases() {
        return frases;
    }

    public int lerRecorde() {

        try {

            File arquivo = new File("score.txt");

            if (!arquivo.exists()) {
                return 0;
            }

            BufferedReader leitor = new BufferedReader(
                    new FileReader(arquivo)
            );

            int recorde = Integer.parseInt(leitor.readLine());

            leitor.close();

            return recorde;

        } catch (Exception e) {

            return 0;
        }
    }

    public void salvarRecorde(int score) {

        int recordeAtual = lerRecorde();

        if (score > recordeAtual) {

            try {

                BufferedWriter escritor = new BufferedWriter(
                        new FileWriter("score.txt")
                );

                escritor.write(String.valueOf(score));

                escritor.close();

            } catch (IOException e) {

                System.out.println("Erro ao salvar score");
            }
        }
    }

}
