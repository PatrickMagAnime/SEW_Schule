/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author riedl
 */
public class Dat {

    private String datum;
    private double temp;
    private double sonne;
    private double nieder;
    private double luft;
    private int n_dauer;

    public double getLuft() {
        return luft;
    }

    public void setLuft(double luft) {
        this.luft = luft;
    }
    

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getSonne() {
        return sonne;
    }

    public void setSonne(double sonne) {
        this.sonne = sonne;
    }

    public double getNieder() {
        return nieder;
    }

    public void setNieder(double nieder) {
        this.nieder = nieder;
    }

    public int getN_dauer() {
        return n_dauer;
    }

    public void setN_dauer(int n_dauer) {
        this.n_dauer = n_dauer;
    }

    
   Dat(String datum,double temp,double sonne,double nieder,int n_dauer,double luft){
       this.datum=datum;
       this.temp=temp;
       this.sonne=sonne;
       this.nieder=nieder;
       this.n_dauer=n_dauer;
       this.luft=luft;
   }
}
