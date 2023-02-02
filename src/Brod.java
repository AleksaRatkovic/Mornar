public abstract class Brod {
    protected String naziv;
    protected Mornar[] mornari;
    int kap, br =0;
    int kapetan = 0;

    public Brod(String n, int k, Mornar m) {
        this.naziv = n;
        this.kap = k;
        this.mornari = new Mornar[kap];
        mornari[kapetan] = m;
        br++;
    }

    public Mornar dohvKapetana(){
        return br!=0 ? mornari[kapetan]:null;
    }

    public void dodajMornara(Mornar m) {

        if(br != kap) {
            int i =0;
            for(; i<mornari.length; i++){
                if(mornari[i] == null) {
                    mornari[i] = m;
                    br++;
                    break;
                }

            }
            if(m.dohvKvalitet() > mornari[kapetan].dohvKvalitet()){
                kapetan = i;
            }
        }
    }

   public Mornar dohvMornaraPrekoIndeksa(int i) throws GIndeks{
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
        for(int i = 0; i<mornari.length; i++) mornari[i] = null;
        br = 0;
    }

    public Mornar uzmiNajboljeg(){
        Mornar tmp;
        if(br==0) return null;
        tmp = mornari[kapetan];
        mornari[kapetan] = null;
        int max = 0;
        for(int i =0; i<mornari.length && mornari[i] == null ;i++) {max =mornari[i].dohvKvalitet(); kapetan = i;}
        for(int i =0; i <mornari.length; i++){
            if(mornari[i] != null) {
                if (mornari[i].dohvKvalitet() > max) {
                    max = mornari[i].dohvKvalitet();
                    kapetan = i;
                }
            }
        }
        br--;
        return tmp;
    }

    public abstract char vrsta();
    public abstract boolean uslov(Brod b);
    public abstract void obracun(Brod b);
    public void napadni(Brod b){
        if(uslov(b)){
            if(this.kvalitet() > b.kvalitet()){
                obracun(b); b.ukloniMornare();
            }
            else {
                b.obracun(this); ukloniMornare();
            }
        }
    }

    public double kvalitet(){
        int sum = 0;
        for(int i =0; i < mornari.length; i++){
            if(mornari[i] != null) sum += mornari[i].dohvKvalitet();
        }
        return br!=0?sum/br:0;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(vrsta() + " - " + naziv + " : " +
                kvalitet() + "\n(");
        for(int i = 0, j = 0; i < mornari.length; i++) {
            if(mornari[i]==null) continue;
            sb.append(mornari[i]); j++;
            if(j < br) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();


        }






}
