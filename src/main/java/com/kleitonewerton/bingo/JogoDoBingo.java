/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.bingo;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 */

public class JogoDoBingo {
    
    private final ArrayList<Cartela> cartelas = new ArrayList();
    private final ArrayList<Integer> numerosJaSorteados = new ArrayList();
    
    static Random gerador = new Random();
    
    private int rodadas = 1;
    private int ultimoNSorteado = -1;
    
    /**
    * @brief                            Construtor da classe
    * @param qntCartelas                Quantidade de cartelas a serem adicionadas
    */
    public JogoDoBingo(int qntCartelas){
        
        addCartelas(qntCartelas);
        System.out.println("\nAdiante voce podera ver, no terminal, as cartelas atuais.\n\nAo longo do jogo numeros marcados estarao entre '()'.\n\nBOA SIMULACAO :)");
        JOptionPane.showMessageDialog(null, "Adiante você poderá ver, no terminal, as cartelas atuais.\n\nAo longo do jogo números marcados estarão entre '()'.\n\nBOA SIMULAÇÃO :)", "Aviso",JOptionPane.WARNING_MESSAGE);
        auxPrintCartelas();
    }
    
    /**
    * @brief                            Método para a chamada do sorteio e impressão das cartelas após cada rodada 
    */
    private void sorteio(){
        auxSorteio();
        perguntaImprimir();
        this.rodadas += 1;
    }
    
    /**
    * @brief                            Método que sorteia o número da rodada atual
    */
    private void auxSorteio(){
        
        while(true){
            
            int numero = 1 + gerador.nextInt(76);
            
            if(!this.numerosJaSorteados.contains(numero)){
                
                System.out.println(" RODADA: " +  getRodadaAtual() +"\n O NUMERO " + numero + " FOI O SORTEADO DESSA RODADA\n");
                this.numerosJaSorteados.add(numero);
                marcarValores(numero);
                this.ultimoNSorteado = numero;
                return;
            }
        }
    }
    
    /**
    * @breif                            Método que passa por todas as cartelas do jogo marcando o resultado 
    */
    private void marcarValores(int valor){
        for(int i = 0; i < this.cartelas.size();i++)
            this.cartelas.get(i).marcarNumero(valor);
    }
    
    /**
    * @brief                            Método que adiciona novas cartelas ao jogo 
    */
    private void addCartelas(int qntAdicional){
        
        System.out.println("\n CRIANDO AS "+ qntAdicional+" NOVAS CARTELAS DO JOGO");
        
        for(int i = 0;i < qntAdicional;i++)
            this.cartelas.add(new Cartela());
    
    }
    
    /**
    * @brief                            Método que chama a impressão de todas as cartelas 
    */
    public void printCartelas(){
        auxPrintCartelas();
    }
    
    /**
    * @brief                             Método que imprime todas as cartelas na tela 
    */
    private void auxPrintCartelas(){
        for(int i = 0 ;i<this.cartelas.size();i++)
            this.cartelas.get(i).printCartela();
    }
    
    /**
    * @brief                             Método chama o método para verificar se há ganhadores  
    * @return                            true caso haja ganhadores, false caso não possua ganhadores
    */
    public boolean ganhadores(){
        return auxGanhadores();
    }
    
    /**
    * @brief                             Método que retorna se há algum ganhador ou não  
    * @return                            true caso haja ganhadores, false caso não possua ganhadores
    */
    private boolean auxGanhadores(){
        
        ArrayList<Integer> listGanhadores = new ArrayList();
        boolean gameOver = false;
      
        for(int i = 0; i < this.cartelas.size();i++)
            if(this.cartelas.get(i).cartelaCompleta()){
                listGanhadores.add(this.cartelas.get(i).getNumeroCartela());
                gameOver = true;
            }
        
        if(gameOver)
            imprimeGanhadores(listGanhadores);
        
        return gameOver;
    }
    
    /**
    * @brief                             Método que imprime o/os ganhador/ganhadores desse jogo de bingo
    */
    private void imprimeGanhadores(ArrayList<Integer> listGanhadores){
        String mensagem = "";
        if(1 == listGanhadores.size())
            mensagem += "\n A SEGUINTE CARTELA VENCEU: ";
        else 
            mensagem +="\n AS SEGUINTES CARTELAS VENCERAM: ";
            
        for(int j = 0; j < listGanhadores.size();j++)
            mensagem += (listGanhadores.get(j) + " ");
        
        auxPrintCartelas();
        JOptionPane.showMessageDialog (null, mensagem, "GAME OVER", JOptionPane.DEFAULT_OPTION);
        System.out.println(mensagem);
        
        
    }
    
    /**
    * @breif                            Método que pergunta a usuário se deseja imprimir as cartelas
    */
    private void perguntaImprimir(){
        
        int numero = JOptionPane.showConfirmDialog(null,"NÚMERO SORTEADO: " + getUltimoNumero() +". \n\nDeseja imprimir as cartelas da rodada " + getRodadaAtual() + "?","IMPRESSÃO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(numero == 0)
            auxPrintCartelas();
    }
    
    /**
    * @breif                            Método que chama o iniciar jogo 
    */
    public void iniciarJogo(){
        auxIniciarJogo();
    }
    
    /**
    * @brief                            Método que inicia todo o jogo
    */
    private void auxIniciarJogo(){
        while(true){
            sorteio();
            if(getRodadaAtual() > 23 && ganhadores())
                break; 
        }
    }
    
    /**
    * @brief                            Método que retorna a rodada utual desse jogo do bingo 
    * @return                           Rodada atual
    */
    public int getRodadaAtual(){
        return this.rodadas;
    }
    
    /**
    * @brief                            Método que retorna o último número sorteado desse jogo do bingo 
    * @return                           Último número sorteado
    */
    public int getUltimoNumero(){
        return this.ultimoNSorteado;
    }
}
