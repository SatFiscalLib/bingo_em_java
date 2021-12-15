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
    public static void main(String[] args){
    
        ArrayList<Cartela> cartelas = new ArrayList();
        for(int i = 0; i <10 ;i++)
            cartelas.add(new Cartela(i));
        
        for(int i = 0; i <10 ;i++)
            cartelas.get(i).printCartela();
        
        cartelas.clear();
    }
}
