package ims.informationmanagementsystem.Home;

/**
 * Created by Asad Mehmood on 09/01/2018.
 */

public class MyData {

    private String name;
    private byte[] image;

    public MyData(String name, byte[] image)
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
