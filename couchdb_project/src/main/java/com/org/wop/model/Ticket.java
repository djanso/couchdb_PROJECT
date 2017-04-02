package com.org.wop.model;

/**
 * model class for Ticket object
 * 
 * @author ArnaudTessandier
 *
 */
public class Ticket
{
    private String  Compagny;
    private double  price;
    private String  startLocation;
    private String  endLocation;
    private Long    endValidity;
    private boolean used;

    public String getCompagny()
    {
        return Compagny;
    }

    public void setCompagny(String compagny)
    {
        Compagny = compagny;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getStartLocation()
    {
        return startLocation;
    }

    public void setStartLocation(String startLocation)
    {
        this.startLocation = startLocation;
    }

    public String getEndLocation()
    {
        return endLocation;
    }

    public void setEndLocation(String endLocation)
    {
        this.endLocation = endLocation;
    }

    public Long getEndValidity()
    {
        return endValidity;
    }

    public void setEndValidity(Long endValidity)
    {
        this.endValidity = endValidity;
    }

    public boolean isUsed()
    {
        return used;
    }

    public void setUsed(boolean used)
    {
        this.used = used;
    }

}
