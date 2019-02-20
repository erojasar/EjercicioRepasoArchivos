/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.DAO;
import DAO.GestionArchivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erojasar
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Gestion de Enteros");
        int opcion = 0;
        int valor = 0, posicion = 0;
        Gui gui = new Gui();
        DAO bd = new DAO();
        GestionArchivo archivos = 
                new GestionArchivo("enteros.txt");
        Scanner lectura = new Scanner(System.in);
        while(true){
            opcion = gui.menu();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese dato");
                    valor = lectura.nextInt();
                    bd.AddBd(valor);
                    break;
                case 2:
                    System.out.println("Guardando..");
                    
                    try {
                        archivos.guardar(bd.getBd());
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    System.out.println("Cargando Archivo");
                    ArrayList <Integer> respaldo = null;
                    try {
                        respaldo = archivos.cargar();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    bd.setBd(respaldo);
                    break;
                case 4:
                    System.out.println("Lista");
                    gui.listar(bd.getBd());
                    break;
                case 5:
                    System.out.println("Ingrese posicion");
                    posicion = lectura.nextInt();
                    System.out.println("Ingrese numero");
                    valor = lectura.nextInt();
                    
                    if(posicion > 0 && posicion < bd.getBd().size()-1){
                        bd.modificar(valor, posicion);
                        try{
                            archivos.guardar(bd.getBd());
                        }catch(IOException ex){
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                        
            }
        }
    }
}
