abstract public class Animal {
	String name;
	String food;
	int hunger;
	int boundaries;
	String location;

	public abstract void makeNoise();
	public abstract void eat();
	public abstract void roam();

	public void sleep() {
		System.out.println(name + ": zzZZZ");
	}
}