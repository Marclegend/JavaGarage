package com.company;

import models.*;
import utils.ControlDatos;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        boolean creado = false;
        int contador = 0;
        Cliente cliente = new Cliente();
        Scanner input = new Scanner(System.in);

        Garaje garaje = new Garaje();
        String menu = (" PARKING FOMEPO \n" +
                "[ 1 ]. Dejar un vehiculo  \n" +
                "[ 2 ]. Retirar el vehiculo \n" +
                "[ 3 ]. Recargar vehículo \n" +
                "[ 4 ]. Buscar tu coche \n" +
                "[ 5 ]. Mover vehículo de sitio \n"+
                "[ 6 ]. Ver parking \n"+
                "[ 7 ]. Salir del parking \n"+
                "\n"
                );

        String tipoV =(" --* Tipo de vehículo *-- \n" +
                "[ 1 ]. Moto\n" +
                "[ 2 ]. Coche\n" +
                "[ 3 ]. Furgoneta\n");

        boolean sortir = false;

        //
        do {
            System.out.println();
            garaje.mostrarReferencia(); //siempre que reinicie el menú se le mostrarán todas las matrículas por si se le olvida
            switch (ControlDatos.controlErrorsint(menu)) {
                case 1:
                    switch (ControlDatos.controlErrorsint(tipoV)) {

                        case 1:
                            Moto moto = new Moto(2,20,1,"moto", 80, cliente);
                            cliente.AñadirM( moto.getreferencia());
                            garaje.meterVehiculo(moto);
                            break;
                        case 2:

                            Coche coche = new Coche(4,100,2,"coche", 120, cliente);
                            cliente.AñadirM( coche.getreferencia());
                            garaje.meterVehiculo(coche);
                            break;
                        case 3:
                            Furgoneta furgo = new Furgoneta(4,100,3,"furgoneta", 200, cliente);
                            cliente.AñadirM( furgo.getreferencia());
                            garaje.meterVehiculo(furgo);
                            break;
                    }


                 creado = true;

                    break;

                case 2:
                    if(creado){
                        garaje.sacarVehiculo(cliente);
                    } else {
                        System.out.println("debes crear un cliente");
                    }
                    break;
                case 3:
                    garaje.recargarVehículo();
                    break;
                case 4:
                    garaje.buscarCoche();
                    break;
                case 5:
                    garaje.moverCoche();
                    break;
                case 6:
                    garaje.mostrarSala();
                    break;
                case 7:
                    sortir = true;
                    break;
                default:
                    System.out.println("El numero no entra en el rango");
                    break;
            }
        } while (!sortir);


    }

}
