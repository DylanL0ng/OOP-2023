package ie.tudublin;

public class main
{

	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

	public static void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

	public static void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }
	
	public static void main(String[] args)
	{
		// System.out.println("Hello world");
		
		// Dog penny = new Dog();
		// penny.setName("Penny");
		// penny.speak();

		loops();
	}
	
}