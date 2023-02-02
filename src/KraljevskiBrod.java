public class KraljevskiBrod extends Brod{
    public KraljevskiBrod(String n, int k, Mornar m) {super(n,k,m);}

    @Override
    public char vrsta() {
        return 'K';

    }

    @Override
    public boolean uslov(Brod b) {
        return this.vrsta() != b.vrsta();
    }

    @Override
    public void obracun(Brod b) {
        while(br != kap){
            if(this.mornari[NajgoriMornar()].dohvKvalitet() < b.dohvKapetana().dohvKvalitet()) this.dodajMornara(b.uzmiNajboljeg());
            else break;
        }
    }
}
