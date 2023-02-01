package ie.tudublin;

public class Dog {

    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void speak()
    {
        System.out.println("Roof!\n");
    }

    public Dog()
    {
    }

    public Dog(String name)
    {
        this.name = name;
    }
}
