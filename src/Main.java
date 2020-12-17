public class Main {

    public static void main(String[] args) throws InterruptedException {

        Sincronizacion sc = new Sincronizacion();

        System.out.println("Comeza a carreira");

      Tartaruga tarta = new Tartaruga("T",sc);
      Lebre lebre = new Lebre("L",sc);
      tarta.start();
      lebre.start();




    }

}
