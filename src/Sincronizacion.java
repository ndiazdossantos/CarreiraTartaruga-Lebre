public class Sincronizacion {

    private int casillaL;
    private int casillaT;

    private boolean available = true;

    public int getCasillaL() {
        return casillaL;
    }

    public int getCasillaT() {
        return casillaT;
    }

    public synchronized void incrementarL(int value) {
        while (available == false) {  // mentras sexa falso fai o wait de maneira continuada
            try {
                wait(1);
            } catch (InterruptedException e) { }
        }
        available= false; // Este false prohibe empezar a incrementarT ata cambiar a casilla da lebre
        casillaL = value;
        available = true;
        notifyAll();
    }


    public synchronized void incrementarT(int value) {
        while (available == false) {
            try {
                wait(1);
            } catch (InterruptedException e) { }
        }
        available=false;
        casillaT = value;
        available = true;
        notifyAll();
    }
}