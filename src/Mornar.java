public class Mornar {
    private int kvalitet;
    private String ime;

    public Mornar(int k, String ime)
    {
        if(k>100) this.kvalitet = 100;
        else if(k<0) this.kvalitet = 0;
        else this.kvalitet = k;

        this.ime = ime;
    }

    public int dohvKvalitet() {return this.kvalitet;}
    public String dohvIme() {return this.ime;}

    @Override
    public String toString() {
        return "M_" + this.ime + " : " + this.kvalitet;
    }

}
