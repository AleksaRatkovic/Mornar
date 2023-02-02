public class GusarskiBrod extends Brod{

    public GusarskiBrod(String n, int k, Mornar m) {super(n,k,m);}

    @Override
    public char vrsta() {
        return 'G';
    }

    @Override
    public boolean uslov(Brod b) {
        return this.dohvTrenutniBrojMornara()>b.dohvTrenutniBrojMornara();
    }

    @Override
    public void obracun(Brod b) {
        if(b.dohvKapetana().dohvKvalitet()>this.mornari[NajgoriMornar()].dohvKvalitet() && this.br != this.kap) {
            this.dodajMornara(b.dohvKapetana());
        }
    }
}
