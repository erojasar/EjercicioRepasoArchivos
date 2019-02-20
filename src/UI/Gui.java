/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author erojasar
 */
public class Gui {
    public int menu(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("1. leer\n" 
                + "2. guardar \n3. cargar \n" 
                + "4. Listar \n5. modificar");
        int opcion = teclado.nextInt();
        return opcion;
    }
    
    public void listar(ArrayList<Integer> data){
        System.out.println("------");
        for(Integer value : data){
            System.out.println("value");
        }
    }
}
