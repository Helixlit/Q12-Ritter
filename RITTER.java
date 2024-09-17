public class RITTER extends FIGUR {

    public String name;

    public RITTER(int t_y, int t_x, String t_bild, String t_name) {
        super(t_bild);
        super.setzeMittelpunkt(t_x, t_y);
    }

    public void maschieren(double t_schritte) {
        super.verschiebenUm(t_schritte, 0);
    }

    public String nenneName() {
        return this.name;
    }
}
