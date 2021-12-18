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
    
    static ArrayList<Cartela> cartelas = new ArrayList();
    static ArrayList<Integer> numerosJaSorteados = new ArrayList();
    
    static Random gerador = new Random();
    
    static int qntCartelas = 0;
    static int rodadas = 1;
    static int ultimoNSorteado = -1;
    
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
        perguntaImprimir();
        rodadas += 1;
    }
    private void auxSorteio(){
        
        while(true){
            
            int numero = 1 + gerador.nextInt(76);
            
            if(!numerosJaSorteados.contains(numero)){
                
                System.out.println(" RODADA: " + rodadas +"\n O NUMERO " + numero + " FOI O SORTEADO DESSA RODADA\n");
                numerosJaSorteados.add(numero);
                marcarValores(numero);
                ultimoNSorteado = numero;
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
        String mensagem = "";
        
        for(int i = 0; i < cartelas.size();i++)
            if(cartelas.get(i).cartelaCompleta()){
                listGanhadores.add(cartelas.get(i).getNumeroCartela());
                ganhadores +=1;
                gameOver = true;
            }
        if(gameOver){
            if(ganhadores == 1)mensagem += "\n A SEGUINTE CARTELA VENCEU: ";
            else mensagem +="\n AS SEGUINTES CARTELAS VENCERAM: ";
            
            for(int j = 0; j < listGanhadores.size();j++)
                mensagem +=(listGanhadores.get(j) + " ");
            
            JOptionPane.showMessageDialog (null, mensagem);
            auxPrintCartelas();
            }
        return gameOver;
    }
    
    public void iniciarJogo(){
        auxIniciarJogo();
    }
    
    private void perguntaImprimir(){
        
        int numero = JOptionPane.showConfirmDialog(null,"Numero sorteado " + ultimoNSorteado+". \nDeseja imprimir as cartelas da rodada " + rodadas+"?","Imprimir",JOptionPane.YES_NO_OPTION);
        if(numero == 0)
            auxPrintCartelas();
    }
    
    private void auxIniciarJogo(){
        while(true){
           
            sorteio();
            
            if(rodadas > 23 && ganhadores())
                break; 
        }
    } 
}
