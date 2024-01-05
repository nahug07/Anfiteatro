package com.mycompany.anfiteatro;
import java.util.Scanner;

public class Anfiteatro {

    public static void main(String[] args) {
        
        char asientos[][] = new char [11][11];
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila = 0, asiento = 0;
        String salida;
        String mostrarMapa;
        
        for(int f=1; f<11; f++){
            for(int c=1; c<11; c++){
                asientos[f][c] = 'L';
            } 
        }
        
        System.out.println("------ BIENVENIDO AL SISTEMA DE RESERVAS ------");  
        
        while(bandera != true){
            
            System.out.println("¿Desea ver los asientos disponibles? S: Si, Cualquier tecla: No");
            mostrarMapa = teclado.next();
            
            if(mostrarMapa.equalsIgnoreCase("S")){
                dibujarMapa(asientos);
            }
            
            boolean error = true;
            while(error == true){
                System.out.println("\n Ingrese Fila y Asiento a reservar");
                System.out.print("Fila (entre 1 y 10)");
                fila = teclado.nextInt();
            
                System.out.print("Asiento (entre 1 y 10)");
                asiento = teclado.nextInt();
                
                if(fila <= 10 && fila >= 1) {
                    if(asiento <= 10 && asiento >= 1) {
                        error = false;
                    } else {
                        System.out.println("El numero de asiento no es valido");
                    }
                } else {
                    System.out.println("El numero de fila no es valido");
                }
            }
            
            if(asientos[fila][asiento]=='L') {
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento fue reservado correctamente");
            } else {
                System.out.println("El asiento esta ocupado, por favor elija otro");
            }
            
            System.out.println("\n ¿Desea finalizar la reserva? S: Si, Cualquier tecla: No");
            salida = teclado.next();
            
            if(salida.equalsIgnoreCase("S")){
                bandera = true;
            }
        }
        
    }
    
    static void dibujarMapa(char asientos[][]){
        for(int f=0; f<11; f++){
            System.out.print((f != 10 ? "0" : "") + f + " "); 
            
            for(int c=1; c<11; c++){
                if(f == 0) {
                    System.out.print((c != 10 ? "0" : "") + c + " "); 
                } else {
                    System.out.print("[" + asientos[f][c] + "]");
                }
            } 
            System.out.println("");    
        }
    }
}
