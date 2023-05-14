package model;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Calendar;

public class PremiumUser extends User {
    private ArrayList<Book> books;
    private ArrayList<Magazine>magazines;
    private ArrayList<Factura>facturas;
    private int cantidadLibrosComprados=0;
    private int cantidadRevistasSuscritas=0;
    private int cantidadPaginasLeidas=0;

    public PremiumUser(String nameUser, String idUser, Calendar fechaVinculacion) {
        super(nameUser, idUser, fechaVinculacion);
        this.books=new ArrayList<Book>();
        this.magazines=new ArrayList<Magazine>();
        this.facturas=new ArrayList<Factura>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }



    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }



    public ArrayList<Magazine> getMagazines() {
        return magazines;
    }



    public void setMagazines(ArrayList<Magazine> magazines) {
        this.magazines = magazines;
    }



    public int getCantidadLibrosComprados() {
        return cantidadLibrosComprados;
    }

    public void setCantidadLibrosComprados(int cantidadLibrosComprados) {
        this.cantidadLibrosComprados = cantidadLibrosComprados;
    }

    public int getCantidadRevistasSuscritas() {
        return cantidadRevistasSuscritas;
    }

    public void setCantidadRevistasSuscritas(int cantidadRevistasSuscritas) {
        this.cantidadRevistasSuscritas = cantidadRevistasSuscritas;
    }

    public int getCantidadPaginasLeidas() {
        return cantidadPaginasLeidas;
    }

    public void setCantidadPaginasLeidas(int cantidadPaginasLeidas) {
        this.cantidadPaginasLeidas = cantidadPaginasLeidas;
    }

    @Override
    public String toString() {
        return "\nNombre:" + this.getNameUser()+ "\nIdentificador: " + this.getIdUser()
                + "\nFecha de vinculacion: "+this.getFechaVinculacion();
    }

    public String toStringMin(){
        return this.getNameUser()+"-"+this.getIdUser();
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
    
   
}
