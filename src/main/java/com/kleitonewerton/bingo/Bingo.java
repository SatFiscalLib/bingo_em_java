/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.bingo;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author KleitonEwerton
 */
public class Bingo {
    
    static Scanner teclado = new Scanner(System.in);
    
    /**
    * @brief                            Função que lê um número do usuário 
    * @return                           Número lido 
    */
    public static int leituraNumero(){
 
        int numero =  Integer. parseInt(JOptionPane.showInputDialog("Usuário, digite o número de jogadores", "50"));
        return numero;
    }
    
    /**
    * @brief                            Função que pergunta o número ao usuário até que seja válido
    * @return                           Número lido
    */
    public static int perguntaNumero(){
        
        while(true)
            try{
               int numero = leituraNumero();
               if(numero > 0) 
                   return numero;
               else 
                   JOptionPane.showMessageDialog(null, "NÚMERO DA JOGADORES INVÁLIDO, DEVE SER MAIOR QUE ZERO", "ERRO",JOptionPane.ERROR_MESSAGE);
                   
       
            }catch (Exception ex){
                
               JOptionPane.showMessageDialog(null, "NÚMERO DA JOGADORES INVÁLIDO", "ERRO",JOptionPane.ERROR_MESSAGE);}
        
    }
    
    /**
    * @brief                            Mensagem de bem-vindo do jogo
    */
    public static void mensagemBemVindo(){
        
        JOptionPane.showMessageDialog(null, "BEM-VINDO JOGADOR AO MEU JOGO DO BINGO", "BEM-VINDO",JOptionPane.DEFAULT_OPTION);
    }
    
    public static void main(String[] args){
       
       mensagemBemVindo();
       JogoDoBingo jogo = new JogoDoBingo(perguntaNumero());
       JOptionPane.showMessageDialog(null, "SIMULAÇÃO INICIADA", "START",JOptionPane.DEFAULT_OPTION);
       jogo.iniciarJogo();
       
    }
}
