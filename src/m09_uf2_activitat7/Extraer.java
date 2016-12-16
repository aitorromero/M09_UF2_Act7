package m09_uf2_activitat7;

import java.util.Random;

public class Extraer implements Runnable{

    /**
     * Declarem les variables.
     */
    private final Random aleatorio;
    private final cuenta cuenta;
    private final int idextraer;
    private final int TIEMPOESPERA = 1500;
    
    /**
     * Constructor de Extraer amb els parametres següents.
     * @param cuenta
     * @param idintroductir 
     */
    public Extraer(cuenta cuenta, int idextraer) {
        this.cuenta=cuenta;
        this.idextraer=idextraer;
        aleatorio = new Random();
    }

    /**
     * Run on es crea aleatoriament en valor que estraurem a cuentaBancaria.
     */
    @Override
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(300);
            cuenta.extraccion(poner);
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Extractor " + idextraer + ": Error en run -> " + e.getMessage());
            }
        }
    }

}
