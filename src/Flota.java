public class Flota {
    private String naziv;
    private static class Elem{
        Brod brod; Elem sled;
        Elem(Brod b) {brod = b; sled = null;}

    }
    private Elem prvi, posl;

    public Flota(String n) {this.naziv = n;}

    public void dodajBrod(Brod b) throws GNeadekvatan {
        if(prvi != null && prvi.brod.vrsta() != b.vrsta()) throw new GNeadekvatan();
        Elem novi = new Elem(b);
        if(prvi == null) prvi = novi;
        else posl.sled = novi;
        posl = novi;
    }

    public Brod dohvatiBrodIndeksom(int i) throws GIndeks {
        Elem tmp = prvi;
        while(i>0 && tmp != null) {tmp = tmp.sled; i--;}
        if(tmp == null) throw new GIndeks();
        return tmp.brod;
    }

    public double kvalitet() {
        Elem tmp = prvi;
        double sum = 0;
        int count = 0;
        while(tmp != null) { sum+= tmp.brod.kvalitet(); tmp = tmp.sled; count++;}

        return sum / count;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flota(" + (prvi != null ? prvi.brod.vrsta() : "")
                + ") " + naziv + " : " + kvalitet() + "\n");
        Elem tmp = prvi;
        while (tmp != null) {
            sb.append(tmp.brod);
            if (tmp.sled != null) sb.append("\n");
            tmp = tmp.sled;
        }
        return sb.toString();
    }

    }
