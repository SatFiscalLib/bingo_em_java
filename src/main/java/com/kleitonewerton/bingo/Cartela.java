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
    
    static Random gerador = new Random();
    private final String[][] tabuleiro;
    private final int numeroCartela;
    static int qntCartelas = 0;
    
    static final int LINHAS = 5;
    static final int COLUNAS = 5;
    
    /**
    * @brief                                Construtor da classe Cartela
    */
    public Cartela(){
        
        this.numeroCartela = qntCartelas + 1;
        this.tabuleiro = iniciaCartela();
        qntCartelas += 1;
       
    }
    
    /**
    * @brief                                Metodo usado para iniciar uma cartela(tabuleiro) respeitando as regras de numeracao, e que será atribuida a cartela desse objeto
    */
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

                    sorteado = Integer.toString(sort);
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
    
    /**
    * @brief                                Método que chama a impressão da cartela 
    */
    public void printCartela(){
        auxPrintCartela();
    }
    
    /**
    * @brief                                Método que realiza a impressão da cartela 
    */
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
    
    /**
    * @brief                                Método que converte um número para String e tenta marca-lo na cartela
    * @param numero                         Número que será convertido e marcado
    */
    public void marcarNumero(int numero){
     
        auxMarcarNumero(Integer.toString(numero));
    }
    
    /**
    * @brief                                Método que marca uma String utilizando '()',mas somente se estiver presente na cartela
    */
    private void auxMarcarNumero(String numero){
        
        for(int i = 0; i < LINHAS;i++)
            for(int j = 0;j<COLUNAS;j++)
                if(this.tabuleiro[i][j].equals(numero)){
                    this.tabuleiro[i][j] = "(" + tabuleiro[i][j]+")";
                    break;
                }               
        
    }
    
    /**
    * @brief                                Método que chama a verificação de cartela completa
    * @return                               true caso esteja completa, false caso não esteja completa
    */
    public boolean cartelaCompleta(){
        return auxCartelaCompleta();
    }
    
    /**
    * @brief                                Método que  verifica se todas as posições da cartela está marcada
    * @return                               true caso esteja completa, false caso não esteja completa
    */
    private boolean auxCartelaCompleta(){
        
        for(int i = 0;i<LINHAS;i++)
            for(int j = 0; j < COLUNAS; j++)
              if(this.tabuleiro[i][j].charAt(0) != '(')
                  return false;
        
        return true;
    }
    
    /**
    * @brief                                Método que retorna o número seguêncial da cartela 
    * @return                               Número dessa cartela
    */
    public int getNumeroCartela(){
        return this.numeroCartela;
    }
    
    /**
    * @brief                                Método que retorna o número de cartelas já criadas 
    * @return                               Número de cartelas atuais
    */
    public int getQuantidadeCartelas(){
        return Cartela.qntCartelas;
    }
    
}
