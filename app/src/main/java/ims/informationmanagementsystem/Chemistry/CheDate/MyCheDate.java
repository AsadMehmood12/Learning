package ims.informationmanagementsystem.Chemistry.CheDate;

/**
 * Created by Asad Mehmood on 12/01/2018.
 */

public class MyCheDate {

    private String name;
    private byte[] image;

    public MyCheDate(String name, byte[] image)
    {
        this.name = name;
        this.image = image;

    }
    public String GetName()
    {
        return name;
    }
    public byte[] GetImage()
    {
        return image;
    }
    public void SetName(String name)
    {
        this.name = name;
    }
    public void SetImage(byte[] image)
    {
        this.image = image;
    }
}


