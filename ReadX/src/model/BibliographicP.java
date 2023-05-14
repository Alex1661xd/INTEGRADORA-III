package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BibliographicP {
    private String identifier;
    private String name;
    private int numberPages;
    private Calendar datePublished;
    private String URL;
    private int pagesRead;
    
    public BibliographicP(String identifier, String name, int numberPages, Calendar datePublished, String URL) {
            
        this.identifier = identifier;
        this.name = name;
        this.numberPages = numberPages;
        this.datePublished = datePublished;
        this.URL = URL;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public Calendar getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Calendar datePublished) {
        this.datePublished = datePublished;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    @Override
    public String toString() {
        return "BibliographicP [identifier=" + identifier + ", name=" + name + ", numberPages=" + numberPages
                + ", datePublished=" + datePublished + ", URL=" + URL + ", pagesRead=" + pagesRead + "]";
    }

    
    
}
