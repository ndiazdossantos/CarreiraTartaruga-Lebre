public class Lebre extends Thread{
    private int casilla;

    Sincronizacion sc;

    public Lebre(String nome, Sincronizacion sc){
        super(nome);
        casilla=1;
        this.sc=sc;

    }

    @Override
    public void run() {

        try {
            sleep(10); // é necesario porque se non nalgúns casos solápanse
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(casilla<70){

            int random =(int) (Math.random()*(10)+1);

            if(random <= 2){
                System.out.println("A lebre durme");
            }

            if(random == 3 || random == 4){
                casilla = casilla+9;
            }

            if(random == 5){
                casilla = casilla-12;

                if(casilla<0){
                    casilla=1;
                }

            }


            if(random>5 && random<=8){
                casilla=casilla+1;
            }

            if(random==9 || random==10){
                casilla=casilla-2;
                if(casilla<0){
                    casilla=1;
                }

            }
            sc.incrementarL(casilla);
            int resultado = sc.getCasillaT();
            int comparacion1=sc.getCasillaL();
            int comparación2=sc.getCasillaT();
            if(resultado==70){
                System.out.println("A Tartaruga proclámase gañadora chegando a casilla Nº70");
                stop();
            }
            if(resultado>70){
                System.out.println("A Tartaruga proclámase gañadora sobrepasando a casilla 70");
                stop();
            }
            System.out.println(casilla+" "+getName());
            // chamamos ó metodo de sincronización para notificar o incremento

            //empate
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
