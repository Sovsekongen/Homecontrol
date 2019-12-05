package p.vikpo.homecontrol.entities;

import java.util.ArrayList;

public class CoffeeBagWrapper
{
    private String name, country, county, brand;
    private double price;
    private int rating;
    private long purchaseTime, added;
    private ArrayList<String> tastes;

    public CoffeeBagWrapper()
    {

    }

    public CoffeeBagWrapper(String name, String country, String county, String brand, double price, int rating, long purchaseTime, long added, ArrayList<String> tastes)
    {
        this.name = name;
        this.country = country;
        this.county = county;
        this.brand = brand;
        this.price = price;
        this.rating = rating;
        this.purchaseTime = purchaseTime;
        this.added = added;
        this.tastes = tastes;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCounty()
    {
        return county;
    }

    public void setCounty(String county)
    {
        this.county = county;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public long getPurchaseTime()
    {
        return purchaseTime;
    }

    public void setPurchaseTime(long purchaseTime)
    {
        this.purchaseTime = purchaseTime;
    }

    public ArrayList<String> getTastes()
    {
        return tastes;
    }

    public void setTastes(ArrayList<String> tastes)
    {
        this.tastes = tastes;
    }

    public long getAdded()
    {
        return added;
    }

    public void setAdded(long added)
    {
        this.added = added;
    }
}
