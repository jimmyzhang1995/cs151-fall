import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BarFrame extends JFrame implements ChangeListener{
	private ArrayList arraylist;
	private Model datamodel;
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 400;
	
	public BarFrame(Model datamodel)
	{
		this.datamodel = datamodel;
		arraylist = datamodel.getData();		
		setLocation(0, ICON_HEIGHT);				
		setLayout(new BorderLayout());
		Icon barIcon = new Icon()
				{
					public int getIconWidth()
					{
						return ICON_WIDTH;
					}
					public int getIconHeight()
					{
						return ICON_HEIGHT;
					}
					public void paintIcon(Component c, Graphics g, int x, int y)
					{
						Graphics2D g2 = (Graphics2D)g;
						g2.setColor(Color.blue);
						
						double max = ((Double) arraylist.get(0));
												for (int i = 1; i< arraylist.size(); i++)
						{
							double temp = (double)arraylist.get(i);
							if (temp > max)
								max = temp;
						}
						double barHeight = getIconHeight() / arraylist.size();
						for (int i = 0; i< arraylist.size(); i++)
						{
							double value = (double)arraylist.get(i);
							double barLength = getIconWidth() * value / max;
							Rectangle2D.Double rect = new Rectangle2D.Double(0, barHeight * i, barLength, barHeight);
							g2.fill(rect);
						}
	
					}
				};
	add(new JLabel(barIcon));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pack();
	setVisible(true);
	}
	
	public void stateChanged(ChangeEvent event)
	{
		arraylist = datamodel.getData();
		repaint();
	}
	


}
