package models;

import utils.ControlDatos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Garaje {

    protected Vehiculo[][][] sala; //Creamos una array llena de nulls del tipo Vehiculo

    public Garaje() {

        this.sala = new Vehiculo[2][3][6]; //la inicializamos
        inicio(); //Iniciamos la aplicación Inicio en cuanto se crea el garaje,
        mostrarSala(); //Mostramos la sala por primera vez con la creación del garaje
    }

    public void mostrarSala() {
        for (int i = 0; i < 2; i++) {
            System.out.println(); //Damos un espacio para que se corte
            for (int j = 0; j < 3; j++) {
                System.out.println();
                for (int k = 0; k < 6; k++) {

                    if (this.sala[i][j][k] == null) {
                        System.out.print("[  ]"); //si la sala está vacia, no pondremos ninguna letra

                    } else {//si está lleno, cogeremos la referencia, y cortaremos la primera letra, ya que esta representará qué tipo de vehículo es

                        if (sala[i][j][k].getreferencia().substring(0, 1).equalsIgnoreCase("c")) {
                            System.out.print("[ C ] ");

                        }
                        if (sala[i][j][k].getreferencia().substring(0, 1).equalsIgnoreCase("m")) {
                            System.out.print("[ M ] ");

                        }
                        if (sala[i][j][k].getreferencia().substring(0, 1).equalsIgnoreCase("f")) {
                            System.out.print("[ F ] ");

                        }
                    }

                }
            }

        }
    }

    public void recargarVehículo() {
        String posiciones = buscarCoche();
        if (posiciones == null) {

        } else {
            int planta = Integer.parseInt(posiciones.substring(0, 1));//Separamos el string de posicion y lo pasamos a int (planta)
            int fila = Integer.parseInt(posiciones.substring(2, 3));//Separamos el string de posicion y lo pasamos a int (fila)
            int columna = Integer.parseInt(posiciones.substring(4, 5));//Separamos el string de posicion y lo pasamos a int (columna)
            sala[planta][fila][columna].Refill( sala[planta][fila][columna].cliente); //usamos la función refill del vehículo en cuestión
        }
    }

    /**
     * int tipo = (int) (Math.random() * 3) + 1; //Creación de un número random para añadir vehiculos al garaje
     * 
     */
    public void inicio() {
        int tipo = (int) (Math.random() * 3) + 1; //Creación de un número random para añadir vehiculos al garaje


        switch (tipo) {
            case 1:
                Moto moto = new Moto(4, 100, 2, "moto", 120, new Cliente());
                this.sala[0][0][0] = moto; //Sea cual sea el vehículo que toque, se le pondrá en la primera posición
                System.out.println("Su vehículo es una moto con matrícula " + moto.matricula );
                break;

            case 2:
                Coche coche = new Coche(4, 100, 2, "coche", 100, new Cliente());
                this.sala[0][0][0] = coche;
                this.sala[0][0][1] = coche;
                System.out.println("Su vehículo es un coche con matrícula " + coche.matricula );
                break;

            case 3:
                Furgoneta furgo = new Furgoneta(4, 100, 2, "furgoneta", 120, new Cliente());
                this.sala[0][0][0] = furgo;
                this.sala[0][0][1] = furgo;
                this.sala[0][0][2] = furgo;
                System.out.println("Su vehículo es una furgoneta con matrícula " + furgo.matricula );
                break;

        }
    }

    /**
     * // Primero mostrar la sala para saber que posicion queremos mover.
     * Luego decir a que vehículo quieres mover ( pedir vehículo )
     * String posicio = buscarCoche(); //Una vez tenemos el input, usaremos la función para buscarlo
     * System.out.println(posicio); //Enseñamos la posición del vehículo
     * System.out.println("El vehículo se encuentra en la posicion " + posicio);
     * planta1 = Integer.parseInt(posicio.substring(0, 1));//Separamos el string de posicion y lo pasamos a int (planta)
     * fila1 = Integer.parseInt(posicio.substring(2, 3));//Separamos el string de posicion y lo pasamos a int (fila)
     * columna1 = Integer.parseInt(posicio.substring(4, 5));//Separamos el string de posicion y lo pasamos a int (columna)
     * Vehiculo vamover = this.sala[planta1][fila1][columna1]; //Cogemos el vehículo que queremos mover
     * planta2 = Integer.parseInt(pos.substring(0, 1)); // lo mismo que con planta 1
     * switch (vamover.getreferencia().substring(0, 1)) { //Revisamos que tipo de objeto va a ser
     * case "c": //Dependiendo el tipo de vehículo se sumará +1 o +2 por su tamaño, ya que necesitan varias celdas
     * if (columna2 < 3) //Revisamos que l posición a la que se vaya a mover esté vacía
     * else //Si la posición a escoger, no tuviera suficiente espacio,
     * case "f"://Con tal de que no nos traguemos un error de OutOfBound (se sale del array), comprobamos
     * que las celdas a las que vayamos a mover la furgoneta, no sobrepasen el límite de la array
     * Y en este sumamos 1 y 2, porque es el número de posiciones que tendremos que sumar
     * Y donde puede sueceder el error, (si escoge el 2, y le sumamos +2, tenderemos un OutOFBound)
     */
    public void moverCoche() {
        Scanner input = new Scanner(System.in);
        String referencia = "";
        int planta1, fila1, columna1, planta2, fila2, columna2;
        // Primero mostrar la sala para saber que posicion queremos mover.
        // Decir a que vehículo quieres mover ( pedir vehículo )

        String posicio = buscarCoche(); //Una vez tenemos el input, usaremos la función para buscarlo

        if (posicio == null) {
        } else {
            System.out.println(posicio); //Enseñamos la posición del vehículo
            System.out.println("El vehículo se encuentra en la posicion " + posicio);
            planta1 = Integer.parseInt(posicio.substring(0, 1));//Separamos el string de posicion y lo pasamos a int (planta)
            fila1 = Integer.parseInt(posicio.substring(2, 3));//Separamos el string de posicion y lo pasamos a int (fila)
            columna1 = Integer.parseInt(posicio.substring(4, 5));//Separamos el string de posicion y lo pasamos a int (columna)
            Vehiculo vamover = this.sala[planta1][fila1][columna1]; //Cogemos el vehículo que queremos mover
            System.out.println("En que posicion lo quieres mover?");
            String pos = input.next();
            planta2 = Integer.parseInt(pos.substring(0, 1)); // lo mismo que con planta 1
            fila2 = Integer.parseInt(pos.substring(2, 3));
            columna2 = Integer.parseInt(pos.substring(4, 5));
            switch (vamover.getreferencia().substring(0, 1)) { //Revisamos que tipo de objeto va a ser
                case "c": //Dependiendo el tipo de vehículo se sumará +1 o +2 por su tamaño, ya que necesitan varias celdas
                    if (columna2 < 3) {//Revisamos que l posición a la que se vaya a mover esté vacía
                        if (this.sala[planta2][fila2][columna2] == null && this.sala[planta2][fila2][columna2 + 1] == null) {
                            this.sala[planta2][fila2][columna2] = vamover;
                            this.sala[planta2][fila2][columna2 + 1] = vamover;
                            this.sala[planta1][fila1][columna1] = null;
                            this.sala[planta1][fila1][columna1 - 1] = null;
                        } else {
                            System.out.println("la posicion indicada esta llena o no existe");
                        }
                    } else {//Si la posición a escoger, no tuviera suficiente espacio,
                        System.out.println("No tienes suficiente espacio!");
                    }
                    break;

                case "m":
                    if (this.sala[planta2][fila2][columna2] == null) {
                        this.sala[planta2][fila2][columna2] = vamover;
                        this.sala[planta1][fila1][columna1] = null;
                        System.out.println("se ha movido la moto");
                    } else {
                        System.out.println("la posicion indicada esta llena / o no existe");
                    }

                    break;
                case "f"://Con tal de que no nos traguemos un error de OutOfBound (se sale del array), comprobamos
                    // que las celdas a las que vayamos a mover la furgoneta, no sobrepasen el límite de la array
                    //Y en este sumamos 1 y 2, porque es el número de posiciones que tendremos que sumar
                    //Y donde puede sueceder el error, (si escoge el 2, y le sumamos +2, tenderemos un OutOFBound)
                    if (columna2 <= 2 && fila2 <= 3 && planta2 < 2) {
                        if (this.sala[planta2][fila2][columna2] == null && this.sala[planta2][fila2][columna2 + 1] == null && this.sala[planta2][fila2][columna2 + 2] == null) {
                            this.sala[planta2][fila2][columna2] = vamover;
                            this.sala[planta2][fila2][columna2 + 1] = vamover;
                            this.sala[planta2][fila2][columna2 + 2] = vamover;
                            this.sala[planta1][fila1][columna1] = null;
                            this.sala[planta1][fila1][columna1 - 1] = null;
                            this.sala[planta1][fila1][columna1 - 2] = null;
                        } else {
                            System.out.println("la posicion indicada esta llena");
                        }
                    } else {
                        System.out.println("No tienes suficiente espacio!");
                    }
                    break;
            }
        }
    }

    /**
     * ArrayList<String> referencias = new ArrayList<>(); //Creamos una arraylist de referencias para guardar todas las referencias de la array
     * if (this.sala[i][j][k] != null) { //Revisamos que no esté null para que no salte ningún error
     * if (!referencias.contains(this.sala[i][j][k].getreferencia())) { //Después comprobamos que la celda tenga una referencia y no otra cosa
     * referencias.add(this.sala[i][j][k].getreferencia());//Si lo es, la agregamos a la array de referencias
     * System.out.println("Referencias de los coches que tenemos actualmente aparcados: " + referencias.toString()); //y ahora mostramos las referencias
     */
    public void mostrarReferencia() {

        ArrayList<String> referencias = new ArrayList<>(); //Creamos una arraylist de referencias para guardar todas las referencias de la array

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 6; k++) {

                    if (this.sala[i][j][k] != null) { //Revisamos que no esté null para que no salte ningún error

                        if (!referencias.contains(this.sala[i][j][k].getreferencia())) { //Después comprobamos que la celda tenga una referencia y no otra cosa
                            referencias.add(this.sala[i][j][k].getreferencia());//Si lo es, la agregamos a la array de referencias

                        }

                    }

                }
            }

        }
        System.out.println("Referencias de los coches que tenemos actualmente aparcados: " + referencias.toString()); //y ahora mostramos las referencias
    }

    /**
     * String referencia = input.next(); // Referencia del vehículo con la cual podremos buscarlo
     * boolean encontrado = false; // hacemos un booleano para que solamente diga que ha encontrado su coche una vez, pero podamos decir las posiciones
     * while (!encontrado) {//Una vez que entre, significará que lo ha encontrado, dejará el mensaje de éxito, y empezará a decir las posiciones fuera del while sin repetirse
     * posicio = i + "," + j + "," + k; //Guardamos la posición para devolverla, ya que la usaremos para otras funciones
     * if (encontrado == false) { //si el coche no se encuentra gracias al flag, lo comunicamos
     * else {//si se encuentra, le cobramos al usuario
     * return posicio; //devolvemos la posición del coche encontrado
     * @param cliente
     * @return
     */
    public String sacarVehiculo(Cliente cliente) {
        Scanner input = new Scanner(System.in);
        String posicio = null;
        int precio = 0;
        System.out.println("Porfavor, dinos la referencia del vehículo");
        String referencia = input.next(); // Referencia del vehículo con la cual podremos buscarlo
        boolean encontrado = false; // hacemos un booleano para que solamente diga que ha encontrado su coche una vez, pero podamos decir las posiciones
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 6; k++) {
                    if (this.sala[i][j][k] == null) {
                    } else if (this.sala[i][j][k].referencia.equalsIgnoreCase(referencia)) {
                        this.sala[i][j][k] = null;
                        while (!encontrado) {//Una vez que entre, significará que lo ha encontrado, dejará el mensaje de éxito, y empezará a decir las posiciones fuera del while sin repetirse


                            encontrado = true;
                        }
                        posicio = i + "," + j + "," + k; //Guardamos la posición para devolverla, ya que la usaremos para otras funciones
                        System.out.println(posicio);
                    }
                }
            }
        }
        if (encontrado == false) { //si el coche no se encuentra gracias al flag, lo comunicamos
            System.out.println("El teu cotxe no es troba!");
        } else {//si se encuentra, le cobramos al usuario
            cliente.pagar(referencia.substring(0, 1));
            System.out.println("Se ha sacado el vehiculo ");
        }
        return posicio; //devolvemos la posición del coche encontrado

    }


    /**
     * String referencia = input.next(); // Referencia del vehículo con la cual podremos buscarlo
     * boolean encontrado = false; // hacemos un booleano para que solamente diga que ha encontrado su coche una vez, pero podamos decir las posiciones
     * while (!encontrado) {//Una vez que entre, significará que lo ha encontrado, dejará el mensaje de éxito, y empezará a decir las posiciones fuera del while sin repetirse
     * posicio = i + "," + j + "," + k; //Guardamos la posición para devolverla, ya que la usaremos para otras funciones
     * @return
     */
    public String buscarCoche() {
        mostrarSala();
        Scanner input = new Scanner(System.in);
        String posicio = null;
        int precio = 0;
        System.out.println("\nPorfavor, dinos la referencia del vehículo");
        String referencia = input.next(); // Referencia del vehículo con la cual podremos buscarlo
        boolean encontrado = false; // hacemos un booleano para que solamente diga que ha encontrado su coche una vez, pero podamos decir las posiciones
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 6; k++) {
                    if (this.sala[i][j][k] == null) {
                    } else if (this.sala[i][j][k].referencia.equalsIgnoreCase(referencia)) {
                        while (!encontrado) {//Una vez que entre, significará que lo ha encontrado, dejará el mensaje de éxito, y empezará a decir las posiciones fuera del while sin repetirse
                            System.out.println("Hemos encontrado tu vehiculo y la posición es ");
                            encontrado = true;
                        }
                        posicio = i + "," + j + "," + k; //Guardamos la posición para devolverla, ya que la usaremos para otras funciones
                        System.out.println(posicio);
                    }
                }
            }
        }
        if (encontrado == false) {
            System.out.println("El teu cotxe no es troba!");
        }
        return posicio;

    }

    /**
     * boolean creado = false; //Flag para después, nos ayuda con la funcionalidad
     * switch (vehiculo.getModeloVehiculo().substring(0, 1)) { //Cogemos la primera letra de la referencia, que es el tipo de coche
     * Se usa el flag de creado para que podamos romper cada iteración, de lo contrario, cuando encontrara otro coche, lo cambiaría por ese
     * @param vehiculo
     */
    public void meterVehiculo(Vehiculo vehiculo) {
        boolean creado = false; //Flag para después, nos ayuda con la funcionalidad
        System.out.println(vehiculo);
        switch (vehiculo.getModeloVehiculo().substring(0, 1)) { //Cogemos la primera letra de la referencia, que es el tipo de coche

            case "m":

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 6; k++) {

                            if (this.sala[i][j][k] == null) {
                                this.sala[i][j][k] = vehiculo;
                                creado = true;
                                if (creado == true) {
                                    break;
                                }
                            }
                        }
                        if (creado == true) {
                            break;
                        }
                    }
                    if (creado == true) {
                        System.out.println("Has metido una moto");
                        break;
                    }
                }
                break;

            case "c":

                for (int i = 0; i < this.sala.length; i++) {
                    for (int j = 0; j < this.sala.length; j++) {
                        for (int k = 0; k < 6; k++) {

                            if (this.sala[i][j][k] == null && this.sala[i][j][k + 1] == null) {

                                this.sala[i][j][k] = vehiculo;
                                this.sala[i][j][k + 1] = vehiculo;
                                creado = true;
                                if (creado == true) {
                                    break;
                                }
                            }
                        }
                        if (creado == true) {
                            break;
                        }
                    }
                    if (creado == true) {
                        break;
                    }
                }
                break;

            case "f":

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 6; k++) {
                            if (k <= 3) {
                                if (this.sala[i][j][k] == null && this.sala[i][j][k + 1] == null && this.sala[i][j][k + 2] == null) {

                                    this.sala[i][j][k] = vehiculo;
                                    this.sala[i][j][k + 1] = vehiculo;
                                    this.sala[i][j][k + 2] = vehiculo;
                                    creado = true;
                                    if (creado == true) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (creado == true) {
                            break;
                        }
                    }
                    if (creado == true) {
                        System.out.println("Has metido una furgoneta");
                        break;
                    }
                }
                break;
        }
    }
}
