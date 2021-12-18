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
    static int qntCartelas = 0;
    static Random gerador = new Random();
    
    private final int numeroCartela;
    static final int LINHAS = 5;
    static final int COLUNAS = 5;
    
    public Cartela(int numeroCartela){
        
        this.numeroCartela = numeroCartela;
        this.tabuleiro = iniciaCartela();
        qntCartelas += 1;
        
        
    }
    
    private String[][] iniciaCartela(){
        String[][] cart = new String[LINHAS][COLUNAS] ;
        
        
        String sorteado;
        ArrayList<String> sorteados = new ArrayList();
        
        for(int i = 0;i<LINHAS;i++)
            for(int j=0;j<COLUNAS;j++){
                while (true){
                    int sort = -1;
                    switch(j){
                        case 0:
                            sort = 1 + gerador.nextInt(15);
                            break;
                        case 1:
                            sort = 16 + gerador.nextInt(15);
                            break;
                         case 2:
                            sort = 31 + gerador.nextInt(15);
                            break;
                        case 3:
                            sort = 46 + gerador.nextInt(15); 
                            break;
                        case 4:
                            sort = 61 + gerador.nextInt(15);
                            break;
                        }

                    sorteado =Integer.toString(sort);
                    if(!sorteados.contains(sorteado)){
                        sorteados.add(sorteado);
                        cart[i][j] = sorteado;
                        break;
                    }
                }  
            }
     
        cart[2][2] = "(*)";
 
        return cart;     
    }
    
    public void printCartela(){
        auxPrintCartela();
    }
    private void auxPrintCartela(){
        
        System.out.println("\n-------------------------------");
        System.out.println("    Cartela de numero " + this.numeroCartela);
        System.out.println("-------------------------------");
        System.out.println("|   B    I     N     G     O  |");
        System.out.println("-------------------------------");
        
        for(int i = 0;i<LINHAS;i++){
            for(int j = 0; j < COLUNAS;j++)
                
                switch(this.tabuleiro[i][j].length()){
                    case 1:
                        System.out.print("|  "+this.tabuleiro[i][j] + "  ");
                        break;
                    case 2:
                        System.out.print("|  "+this.tabuleiro[i][j] + " ");
                        break;
                     case 3:
                        System.out.print("| "+this.tabuleiro[i][j] + " ");
                        break;
                    case 4:
                        System.out.print("| "+this.tabuleiro[i][j]);
                        break;
                }
            System.out.print("|");
            if(i<4)System.out.println("\n|-----|-----|-----|-----|-----|");
        }
        System.out.println("\n-------------------------------");
    }
    
    public void marcarNumero(int numero){
        
        auxMarcarNumero(Integer.toString(numero));
        
    }
    private void auxMarcarNumero(String numero){
        
        for(int i = 0; i < LINHAS;i++)
            for(int j = 0;j<COLUNAS;j++)
                if(this.tabuleiro[i][j].equals(numero)){
                    this.tabuleiro[i][j] = "(" + tabuleiro[i][j]+")";
                    break;
                }               
        
    }
    
    public boolean cartelaCompleta(){
        return auxCartelaCompleta();
    }
    private boolean auxCartelaCompleta(){
        
        for(int i = 0;i<LINHAS;i++)
            for(int j = 0; j < COLUNAS; j++)
              if(this.tabuleiro[i][j].charAt(0) != '(')
                  return false;
        
        return true;
    }
    
    public int getNumeroCartela(){
        return this.numeroCartela;
    }
    
    public int getQuantidadeCartelas(){
        return Cartela.qntCartelas;
    }
    
}
