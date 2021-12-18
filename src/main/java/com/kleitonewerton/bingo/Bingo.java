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
    
    public static int leituraNumero(){
 
        int numero =  Integer. parseInt(JOptionPane.showInputDialog("Usuario, digite o numero de jogadores atuais"));
        
        return numero;
    }
    
    public static int perguntaNumero(){
        
        while(true)
            try{
               int numero = leituraNumero();
    
               if(numero > 0) return numero;
               else System.out.println(" NUMERO DA JOGADORES INVALIDO");
       
            }catch (Exception ex){System.out.println(" NAO FOI POSSIVEL LER TAL NUMERO");}
    }
    
    public static void mensagemBemVindo(){
        
        JOptionPane.showMessageDialog (null, "BEM VINDO AO JOGO DO BINGO");
    }
    
    public static void main(String[] args){
        
       mensagemBemVindo();
       JogoDoBingo jogo = new JogoDoBingo(perguntaNumero());
       jogo.iniciarJogo();
       
    }
}
