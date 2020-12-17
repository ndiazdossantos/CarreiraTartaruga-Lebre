

public class Tartaruga extends Thread{

  private int casilla;

  Sincronizacion sc; // declaramos o obxeto de clase sincronización

  public Tartaruga(String nome, Sincronizacion sc){
      super(nome);
      casilla=1;
      this.sc = sc; // o inicializamos no constructor

  }

    @Override
    public void run() {

    while(casilla<70){

      int random =(int) (Math.random()*(10)+1);

      if(random <= 5){
        casilla=casilla+3;
      }

      if(random == 6 || random == 7){
        casilla = casilla-6;
        if(casilla<0) {
          casilla = 1;
        }

      }

      if(random > 7 && random<=10){
        casilla = casilla+1;
      }

      sc.incrementarT(casilla);
      System.out.println(casilla+" "+getName());

      int resultado = sc.getCasillaL();
      int comparacion1=sc.getCasillaL();
      int comparación2=sc.getCasillaT();

      if(resultado==70){
        System.out.println("A Lebre proclámase gañadora chegando a casilla Nº70");
        stop();
      }
      if(resultado>70){
        System.out.println("A Lebre proclámase gañadora sobrepasando a casilla 70");
        stop();
      }

      if(comparacion1>=70 && comparación2>=70 &&comparacion1==comparación2){
        System.out.println("Produciuse un empate");
      }

      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }



    }
}
