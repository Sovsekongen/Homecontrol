package p.vikpo.homecontrol.entities;

public class RoomWrapper
{
    private String name;
    private double temp, hum;
    private long lastUpdate;

    public RoomWrapper()
    {

    }

    public RoomWrapper(String name, double temp, double hum, long lastUpdate)
    {
        this.name = name;
        this.temp = temp;
        this.hum = hum;
        this.lastUpdate = lastUpdate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getTemp()
    {
        return temp;
    }

    public void setTemp(double temp)
    {
        this.temp = temp;
    }

    public double getHum()
    {
        return hum;
    }

    public void setHum(double hum)
    {
        this.hum = hum;
    }

    public long getLastUpdate()
    {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }
}
