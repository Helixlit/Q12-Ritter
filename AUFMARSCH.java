import java.util.Random;

class AUFMARSCH extends SPIEL {
    private int zaehler;
    private RITTER[] armee;
    private Random random;
    private RITTER ritter_entfernen;

    public AUFMARSCH() {
        super(960, 540);
        super.setzeHintergrundgrafik("wiese.jpg");

        this.zaehler = 0;
        this.armee = new RITTER[8];
        this.random = new Random();

        super.starteTickerNeu(2);
    }

    @Override
    public void tick() {
        this.ritter_entfernen = null;

        if (this.zaehler >= armee.length)
            return;

        int random = this.random.nextInt(5);


        if(this.zaehler < 4) {        
            if (random <= 1) this.abmaschieren();
            if (random >= 1) this.einordnen();
        } else {
            if (random >= 1) this.abmaschieren();
            if (random <= 1) this.einordnen();
        }


    }

    private void einordnen() {
        for (int i = 0; i < armee.length; i++) {
            if (armee[i] != null) continue;

            this.zaehler++;
            
            int random_int = this.random.nextInt(4) + 1;

            RITTER ritter_neu = new RITTER(-4, -3, "ritter_" + random_int + ".png", "ritter" + zaehler);

            armee[i] = ritter_neu;

            ritter_neu.setzeMittelpunkt(-20, -4);
            ritter_neu.animiereGerade(1, (4*-i)+14, -4, false);

            return;
        }
    }

    private void abmaschieren() {
        if(armee[0] == null) return;

        zaehler--;

        armee[0].animiereGerade(1, 20, -4, false);
        this.ritter_entfernen = armee[0];
        armee[0] = null;

        for (int i = 1; i < armee.length; i++) {
            if (armee[i] == null) return;

            armee[i].animiereGerade(1, (-4*(i-1)+14), -4, false);
            armee[i].setzeMittelpunkt((-4*(i-1)+14), -4);
            armee[i-1] = armee[i];
            armee[i] = null;
        }
    }
}