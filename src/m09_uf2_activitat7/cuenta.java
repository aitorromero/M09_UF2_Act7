package m09_uf2_activitat7;

public class cuenta {

    /**
     * Declarem les variables
     */
    private int[] arrayContenedor=new int[10];
    private int contenido=900;
    private boolean contenedorLleno = Boolean.FALSE;
    private int punteroMeter=0, punteroSacar=0;
    
    /**
     * Creem un dels dos synchronized per a poder fer els ingresos amb un wait 
     * per a parar el fill i deixarlo en la cua de processos. Quan aquest rep la 
     * senyal, pugui accedir i cambiar l'estat de contenedorLleno per a evitar 
     * l'access a l'altre shynchronized. A més fem les modificacions en 
     * contenido. Per a despres permetre l'access d'un dels altres fils.
     * @param value 
     */
    public synchronized void ingreso(int value) {
        while (contenedorLleno /*|| contenido+value>1000*/) {
            try {
                if(contenido-value<0){
                    System.out.println("Intentando INTRODUCIR " +value+ " a "+ contenido);
                }
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        contenedorLleno = !contenedorLleno;
        for (int i = 0; i < 10; i++) {
            arrayContenedor[i]=value;
        }
        punteroMeter++;
        contenedorLleno = !contenedorLleno;
        notifyAll();
    }

    /**
     * Creem un dels dos synchronized per a poder fer els extraccions amb un wait 
     * per a parar el fill i deixarlo en la cua de processos. Quan aquest rep la 
     * senyal, pugui accedir i cambiar l'estat de contenedorLleno per a evitar 
     * l'access a l'altre shynchronized. A més fem les modificacions en 
     * contenido. Per a despres permetre l'access d'un dels altres fils.
     * @param value 
     */
    public synchronized void extraccion(int value) {
        while (contenedorLleno /*|| contenido-value<0*/) {
            try {
                if(contenido-value<0){
                    System.out.println("Intentando EXTRAER " +value+ " a "+ contenido);
                }
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        contenedorLleno = !contenedorLleno;
        for (int i = 0; i < 10; i++) {
            arrayContenedor[i]=0;
        }
        punteroSacar++;
        contenedorLleno = !contenedorLleno;
        notifyAll();
    }

    
    
}
