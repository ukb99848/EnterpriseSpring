package eu.noelvaes.domain;

import javax.persistence.*;
import java.io.Serializable;

@NamedQuery(name = "getAllBeers",query = "select b from Beers as b")
@NamedQuery(name = "updatePriceBeers",query = "update Beers b set b.price=b.price*:rise")
@Entity
@Table(name = "Beers")
public class Beers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int beerId;
    @Column(name = "Name")
    private String beerName;
    private float price;
    private int stock;
    private float alcohol;
    private int version;
    private byte[] image;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CategoryId")
    private Category category;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BrewerId")
    private Brewer brewer;

    public Beers() {
    }

    public Beers(String beerName, float price, int stock, float alcohol, Category category) {
        this.beerName = beerName;
        this.price = price;
        this.stock = stock;
        this.alcohol = alcohol;
        this.category = category;
    }

    public int getBeerId() {
        return beerId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brewer getBrewer() {
        return brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
    }

    @Override
    public String toString() {
        return "Beers{" +
                "beerId=" + beerId +
                ", beerName='" + beerName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", alcohol=" + alcohol +
                ", version=" + version +
                ", category=" + category +
                ", brewer=" + brewer +
                '}';
    }
}
