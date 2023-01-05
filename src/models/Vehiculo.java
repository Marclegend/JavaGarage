package models;

public abstract class Vehiculo implements Refilleable{

    protected int numRuedas;
    protected int matricula;
    protected int gasolina;
    protected int tamano;
    protected String modeloVehiculo;
    protected String referencia;
    protected int gasolinaMAX;
    protected Cliente cliente;

    public Vehiculo(int numRuedas, int gasolina, int tamano, String modeloVehiculo, int gasolinaMAX, Cliente cliente) {
        this.numRuedas = numRuedas;
        this.matricula = (int) (Math.random() * 7000) + 1000;
        this.gasolina = gasolina;
        this.tamano = tamano;
        this.modeloVehiculo = modeloVehiculo;
        this.gasolinaMAX = gasolinaMAX;
        this.referencia = crearReferencia();
        this.cliente = cliente;
    }

    public String crearReferencia() {

        String referencia = "";

        String letra = this.modeloVehiculo.substring(0,1);

        referencia = letra + this.matricula;

        return referencia;
    }

    public String getreferencia() {
        return referencia;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    @Override
    public String toString() {
            return "Su Vehiculo " + modeloVehiculo + " con matrícula " + matricula + " tiene " + numRuedas +
                    " ruedas " + "tiene " + gasolina + " litros de gasolina";
    }

}
