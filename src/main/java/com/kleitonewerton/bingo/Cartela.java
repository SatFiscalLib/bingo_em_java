/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.bingo;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author KleitonEwerton
 */
public class Cartela {
    
    String[][] tabuleiro;
    int numeroCartela;
    
    public Cartela(int numeroCartela){
        
        this.numeroCartela = numeroCartela;
        
        this.tabuleiro = iniciaCartela();
        
        
        
    }
    public static String[][] iniciaCartela(){
        String[][] cart = new String[6][5] ;
        
        cart[0][0] = "B";cart[0][1] = "I";cart[0][2] = "N";cart[0][3] = "G";cart[0][4] = "O";
        
        Random gerador = new Random();
        String sorteado;
        ArrayList<String> sorteados = new ArrayList();
        
        for(int i = 1;i<6;i++)
            for(int j=0;j<5;j++){
                while (true){
                    sorteado = Integer.toString(1 + gerador.nextInt(76));
                    if(!sorteados.contains(sorteado)){
                        sorteados.add(sorteado);
                        cart[i][j] = sorteado;
                        break;
                }
                }
                
            }
                
        cart[3][2] = "*";
        return cart;     
    }
    
    public void printCartela(){
        System.out.println("\n-------------------------------");
        System.out.println("     Cartela de numero " + this.numeroCartela);
        System.out.println("-------------------------------");
        for(int i = 0;i<6;i++){
            for(int j = 0; j < 5;j++)
                
                if(this.tabuleiro[i][j].length() == 1)System.out.print("|  "+this.tabuleiro[i][j] +"  ");
                else System.out.print("|  "+this.tabuleiro[i][j] +" ");
            
            System.out.print("|");
            if(i<5)System.out.println("\n|-----|-----|-----|-----|-----|");
        }
        System.out.println("\n-------------------------------");
    }
}
