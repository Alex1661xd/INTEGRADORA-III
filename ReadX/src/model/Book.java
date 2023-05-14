package model;

import java.util.Calendar;

public class Book extends BibliographicP {
    
    private GenreBook genre;
    private double priceSold;
    private int soldCopies;
    private String review;

    public Book(String identifier, String name, int numberPages, Calendar datePublished, String URL, 
     GenreBook genre, double priceSold, int soldCopies, String review) {
        
        super(identifier, name, numberPages, datePublished, URL);
        this.genre=genre;
        this.priceSold=priceSold;
        this.soldCopies=soldCopies;
        this.review=review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public GenreBook getGenre() {
        return genre;
    }

    public void setGenre(GenreBook genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return priceSold;
    }

    public void setPrice(double priceSold) {
        this.priceSold = priceSold;
    }

    public int getSoldCopies() {
        return soldCopies;
    }

    public void setSoldCopies(int soldCopies) {
        this.soldCopies = soldCopies;
    }

    @Override
    public String toString() {
        return "Identificador: " + this.getIdentifier() + "\nNombre: " + this.getName() +"\nGenero:"+ genre+"\nCantidad de paginas: " + this.getNumberPages() + "\nReseña: "+review+"\nURL: "+this.getURL()+"\nEjemplares vendidos: "+this.getSoldCopies();
    }
    
    public String toStringMin(){
        return this.getIdentifier()+"-"+this.getName();
    }

    
    

}
