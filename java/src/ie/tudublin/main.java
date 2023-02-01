package ie.tudublin;

public class main
{
    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.setName("Martin");
        System.out.println("The dogs name is " + dog.getName());
        dog.speak();
        dog.speak();
    }
}