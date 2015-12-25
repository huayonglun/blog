import boke.service.impl.ResourceManagerImpl;

public class Test {
public static void main(String[] args) {
	ResourceManagerImpl r=new ResourceManagerImpl();
	System.out.println(r);
	r.insertResource("a", "a", "a", "a");
}
}
