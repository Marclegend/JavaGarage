package models;

public class Furgoneta extends Vehiculo implements Refilleable {

    public Furgoneta(int numRuedas, int gasolina, int tamano, String modeloVehiculo, int gasolinMAX, Cliente cliente) {

        super(numRuedas, gasolina, tamano, modeloVehiculo, gasolinMAX, cliente);

    }

    @Override
    public void Refill(Cliente cliente) { //Esta función pedirá el cliente para poder cobrarle
        System.out.println("Tu furgoneta tiene " + this.gasolina + " litros de gasolina,¡Vamos a aumentarlo!"); // Informamos de la gasolina actual
        if (this.gasolinaMAX <= this.gasolina) { //Si tiene más gasolina que la máxima, o igual, no le rellenaremos el tanque
            System.out.println("¡Hey, el depósito de tu furgoneta ya está lleno y no se le puede meter más gasolina!");
        } else {
            double precio = this.gasolinaMAX - this.gasolina * 0.5;//Si aún tiene espacio, calcularemos cuanta gasolina queda para llenarlo, y la cobraremos a 0.5€/l
            if (this.cliente.getDinero() < precio) { //Veremos si tiene el dinero suficiente para pagar el refill
                System.out.println("No puedes pagar el costo del relleno"); // si no puede, se le avisará
            } else {
                this.cliente.setDinero((float) (this.cliente.getDinero() - precio)); //Reducimos el dinero del cliente con un setter
                this.gasolina = (this.gasolina + (this.gasolinaMAX - this.gasolina)); //Rellenamos el tanque
                System.out.println("¡Ahora tu furgoneta tiene " + this.gasolina + " litros de gasolina en el depósito!");
            }

        }
    }
}
