package m09_uf2_activitat7;

public class M09_UF2_Activitat6 {
    
    /**
     * Declarem la CuentaBancaria, els fils i la cuantitat de productors i
     * consumidors.
     */
    private static cuenta cuentabancaria;
    private static Thread[] introducir;
    private static Thread[] extraer;
    private static final int CANTIDADINTRODUCIR = 5;
    private static final int CANTIDADEXTRAER = 5;
    
    /**
     * Inicialitzem cuentabancaria, introducit i extraer i fem el dos bucles
     * per als consumidors i per als productors.
     * @param args 
     */
    public static void main(String[] args) {
        
        cuentabancaria = new cuenta();
        introducir = new Thread[CANTIDADINTRODUCIR];
        extraer = new Thread[CANTIDADEXTRAER];
        
        
        for (int i = 0; i < CANTIDADINTRODUCIR; i++) {
            introducir[i] = new Thread(new Introducir(cuentabancaria, i));
            introducir[i].start();
        }
        
        for (int i = 0; i < CANTIDADEXTRAER; i++) {
            extraer[i] = new Thread(new Extraer(cuentabancaria, i));
            extraer[i].start();
        }
        
    
    }

}
