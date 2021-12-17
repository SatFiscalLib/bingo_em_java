/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kleitonewerton.bingo;
import java.util.ArrayList;
/**
 *
 * @author KleitonEwerton
 */
public class Bingo {
    
    static ArrayList<Cartela> cartelas = new ArrayList();
    
    public static void main(String[] args){
    
        
        for(int i = 0; i <10 ;i++)
            cartelas.add(new Cartela(i));
            
        for(int i = 0; i <10 ;i++)
            cartelas.get(i).printCartela();
        for(int i = 0; i <10 ;i++)
            cartelas.get(i).marcarNumero(4);
        for(int i = 0; i <10 ;i++)
            cartelas.get(i).marcarNumero(1);
        for(int i = 0; i <10 ;i++)
            cartelas.get(i).marcarNumero(14);
        for(int i = 0; i <10 ;i++)
            cartelas.get(i).printCartela();
        cartelas.clear();
    }
}
