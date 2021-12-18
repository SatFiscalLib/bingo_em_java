/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.bingo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author KleitonEwerton
 */

public class JogoDoBingo {
    
    static ArrayList<Cartela> cartelas = new ArrayList();
    static ArrayList<Integer> numerosJaSorteados = new ArrayList();
    
    static Random gerador = new Random();
    
    static int qntCartelas = 0;
    static int rodadas = 1;
    
    public JogoDoBingo(int qntCart){
        
        addCartelas(qntCart);
        
        System.out.println("\n ESSAS SAO AS CARTELAS ATUAIS");
        
        auxPrintCartelas();
    }
    
    public int getQntCarletas(){
        return JogoDoBingo.qntCartelas;
    }
    
    public void sorteio(){
        auxSorteio();
        rodadas += 1;
    }
    private void auxSorteio(){
        
        while(true){
            
            int numero = 1 + gerador.nextInt(76);
            
            if(!numerosJaSorteados.contains(numero)){
                
                System.out.println(" RODADA: " + rodadas +"\n O NUMERO " + numero + " FOI O SORTEADO DESSA RODADA\n");
                numerosJaSorteados.add(numero);
                marcarValores(numero);
                return;
            }
        }
        
    }
    
    private void marcarValores(int valor){
        for(int i = 0; i < qntCartelas;i++)
            cartelas.get(i).marcarNumero(valor);
    }
    
    private void addCartelas(int qntAdicional){
        int auxQntCartelas = qntCartelas; 
        System.out.println("\n CRIANDO AS "+ qntAdicional+" NOVAS CARTELAS DO JOGO");
        
        for(int i = auxQntCartelas;i < auxQntCartelas + qntAdicional;i++){
            cartelas.add(new Cartela(i + 1));
            qntCartelas += 1;
        }
    }
    
    public void printCartelas(){
        auxPrintCartelas();
    }
    private void auxPrintCartelas(){
        
        for(int i = 0 ;i<qntCartelas;i++)
            cartelas.get(i).printCartela();
    }
    
    public boolean ganhadores(){
        return auxGanhadores();
    }
    private boolean auxGanhadores(){
        
        int ganhadores = 0;
        boolean gameOver = false;
        ArrayList<Integer> listGanhadores = new ArrayList();
        
        for(int i = 0; i < cartelas.size();i++)
            if(cartelas.get(i).cartelaCompleta()){
                listGanhadores.add(cartelas.get(i).getNumeroCartela());
                ganhadores +=1;
                gameOver = true;
            }
        if(gameOver){
            if(ganhadores == 1)System.out.print("\n A seguinte cartela venceu: ");
            else System.out.print("\n As seguintes cartelas venceram: ");
            
            for(int j = 0; j < listGanhadores.size();j++)
                System.out.print(listGanhadores.get(j) + ", ");
            System.out.print("\n");
            }
        return gameOver;
    }
    
    public void iniciarJogo(){
        auxIniciarJogo();
    }
    
    private void perguntaImprimir(){
        
        
    }
    
    private void auxIniciarJogo(){
        while(true){
           
            sorteio();
            perguntaImprimir();
                
            if(rodadas > 23 && ganhadores())
                break; 
        }
    } 
}
