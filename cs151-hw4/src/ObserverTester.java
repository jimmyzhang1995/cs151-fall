import java.util.ArrayList;
public class ObserverTester 
{
	public static void main(String[] args)
	{
		ArrayList arraylist = new ArrayList();
		arraylist.add(new Double(40.0));
		arraylist.add(new Double(30.0));
		arraylist.add(new Double(20.0));
		arraylist.add(new Double(10.0));
		Model datamodel = new Model(arraylist);
		TextFrame textframe = new TextFrame(datamodel);
		BarFrame barframe = new BarFrame(datamodel);
		datamodel.attach(barframe);
	}
}
