public abstract class Brod {
    protected Mornar[] mornari;
    int kap, br =0;
    Mornar kapetan;

    public Brod(String n, int k, Mornar m) {
        this.naziv = n;
        this.mornari = new Mornar[kap];
    }

    public void dodajMornara(Mornar m) {
        if(br != kap) mornari[br++] = m;
    }

   public Mornar dohvMornaraPrekoIndeksa(int i) throws GIndeks(){
        if(i< 0 || i > kap) throw new GIndeks();
        return mornari[i];
    }

    public int NajgoriMornar() {
        int tmp = 101;
        int indeks=0;
        for(int i =0; i< br; i++){
            if(mornari[i].dohvKvalitet() < tmp)
            {
                tmp = mornari[i].dohvKvalitet();
                indeks = i;
            }
        }
        if(tmp ==101) return -1;
        else return indeks;
    }

    int dohvTrenutniBrojMornara()
    {
        return br;
    }

    void ukloniMornare()
    {
        for(int i = 0; i<br; i++) mornari[i] = null;
        br = 0;
    }






}
