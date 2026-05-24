/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model; //pacote

import java.io.BufferedReader; // importa classe que lê arquivos
import java.io.BufferedWriter; // importa classe que escreve em arquivos
import java.io.File; // importa classe que manipula arquivos
import java.io.FileReader; // importa classe que lê arquivos
import java.io.FileWriter; // importa classe que escreve en arquivos
import java.io.IOException; // importa classe que trata exceções
import java.util.ArrayList; // importa classe de listas

/**
 *classe que gerencia frases e os recordes
 * @author feispkluongo
 */
public class GerenciadorFrases {
    private final ArrayList<Frase> frases; //chama lista 

    /**
     * construtor de gerenciador de frases
     */
    public GerenciadorFrases() {

        frases = new ArrayList<>(); //cria lista 

        carregarFrases(); //carrega as frases da lista 
    }

    /**
     * método que lê e carrega as frases
     */
    private void carregarFrases() {

        try {
            //criar leitor
            BufferedReader leitor = new BufferedReader(
                    new FileReader("frases.txt")
            );

            String linha; //armazenar linhas 
            
            //lê todo o arquivo
            while ((linha = leitor.readLine()) != null) {

                frases.add(new Frase(linha));
            }

            leitor.close(); //termina a leitura
            
         //para caso tiver um erro na leitura 
        } catch (IOException e) {

            System.out.println("Erro ao ler arquivo");
        }
    }
    
    //get da lista de frases
    public ArrayList<Frase> getFrases() {
        return frases;
    }

    /**
     * método que lê recorde 
     * @return 
     */
    public int lerRecorde() {

        try {
            //cria um objeto do arquivo de recorde 
            File arquivo = new File("score.txt");
            
            //olha se ele existe
            if (!arquivo.exists()) {
                return 0;
            }
            
            //cria o leitor para esse arquivo
            BufferedReader leitor = new BufferedReader(
                    new FileReader(arquivo)
            );
            
            //lê o valor no arquivo
            int recorde = Integer.parseInt(leitor.readLine());

            leitor.close(); //termina a leitura

            return recorde; //retorna o recorde

        } catch (Exception e) {

            return 0;
        }
    }
    
    /**
     * Método que salva o maior recorde 
     * @param score 
     */
    public void salvarRecorde(int score) {

        int recordeAtual = lerRecorde();//lê o recorde que já esta no arquivo
        
        //compara o recorde atual com  o score do jogador de agora
        if (score > recordeAtual) {

            try {
                //cira o leitor do arquivo
                BufferedWriter escritor = new BufferedWriter(
                        new FileWriter("score.txt")
                );

                escritor.write(String.valueOf(score)); //escreve score no arquivo 

                escritor.close(); //fecha o arquivo
             
            //caso ocorra um erro no arquivo
            } catch (IOException e) {

                System.out.println("Erro ao salvar score");
            }
        }
    }

}
