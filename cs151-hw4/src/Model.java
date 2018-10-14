import java.util.ArrayList;
import javax.swing.event.*;
public class Model {

	ArrayList data;
	ArrayList listeners;
	public Model(ArrayList arraylistData)
	{
		data = arraylistData;
		listeners = new ArrayList();
	}
	public ArrayList getData()
	{
		return (ArrayList)(data.clone());
	}
	public void attach(ChangeListener c)
	{
		listeners.add(c);
	}
		public void update(int location, double value)
	{
		data.set(location, value);			for (int i = 0; i < listeners.size(); i++)
		{
			ChangeListener cl = (ChangeListener)listeners.get(i);
			cl.stateChanged(new ChangeEvent(this));
			System.out.println("1:" + listeners.get(i));
		}
		
	}

}
