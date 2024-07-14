
class A{
	A(){
		super();
		System.out.println("A");
	}
	
	int i=6;
	void add() {
		System.out.println("add");
	}
}

class B extends A{
	B(){
		super();
		System.out.println("B");
		
		System.out.println(super.i); //calling i of parent class
		super.add(); //calling add method of parent class
	}
}

class C extends B{
	C(){
		super();
		System.out.println("C");
	}
}


public class Constructor_Demo {
	Constructor_Demo(int i){
		
	}
	Constructor_Demo(){
		
	}

	public static void main(String[] args) {
		new C();
		
		Constructor_Demo a=new Constructor_Demo();

	}

}
