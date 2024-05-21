package PVA8_Streams;

public class GenderCat
{
    private String name ;
    private int    weight ;
    private Gender gender ;

    public GenderCat( String name, int weight, Gender gender )
    {
        this.name   = name ;
        this.weight = weight ;
        this.gender = gender ;
    }

    public String getName()
    {
        return name ;
    }

    public int getWeight()
    {
        return weight ;
    }

    public Gender getGender()
    {
        return gender ;
    }

    public String toString()
    {
        return name + " " + weight ;
    }
}