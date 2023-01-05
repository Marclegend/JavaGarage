package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Cliente {


    /**
     * Arraylist<String> // Creamos un Array para guardar todas las matrículas
     * this.dinero = (int) (Math.random() //le damos dinero para que pueda usarlo en la app
     * this.matriculasVehiculo.add(mat);//función para añadir matrículas a la lista
     */
    protected ArrayList<String> matriculasVehiculo = new ArrayList(); // Creamos un Array para guardar todas las matrículas
    protected double dinero;

    public Cliente() {


        this.dinero = (int) (Math.random() * 5000) + 3000; //le damos dinero para que pueda usarlo en la app
    }

    public void AñadirM(String mat){

        this.matriculasVehiculo.add(mat);//función para añadir matrículas a la lista
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public double getDinero() {
        return dinero;
    }

    /**
     * int horas = (int) (Math.random() * 6) + 1;//Calculamos un número aleatorio de horas y las cobramos a 6€/h
     * switch (tipo){//Dependiendo el tipo de vehículo, la hora saldrá más cara o más barata
     * @param tipo
     */
    public void pagar(String tipo) {
        int horas = (int) (Math.random() * 6) + 1;//Calculamos un número aleatorio de horas y las cobramos a 6€/h
        int precio = 0;
        switch (tipo){//Dependiendo el tipo de vehículo, la hora saldrá más cara o más barata
            case "m":
               this.dinero = this.dinero - horas * 2;
                precio = horas * 2;
                break;

            case "f":
                this.dinero = this.dinero - horas * 8;
                precio = horas * 8;
                break;

            case "c":
                this.dinero = this.dinero - horas * 5;
                precio = horas * 5;
                break;

        }

            System.out.println("Has pagado " + precio + " euros.");

        }

    }



