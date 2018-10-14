import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class TextFrame extends JFrame{
	
	Model dataModel;
	JTextField[] fieldList;
	public TextFrame(Model d)
	{
		dataModel = d;
		final Container contentPane = this.getContentPane();
		setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		ArrayList a = dataModel.getData();
		fieldList = new JTextField[a.size()];
	
	
		ActionListener AL = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JTextField text = (JTextField)e.getSource();
					int i = 0;
					int count = fieldList.length;
					while (i < count && fieldList[i] != text)
						i++;
					String s = text.getText().trim();						
					try
					{
						double value = Double.parseDouble(s);
						dataModel.update(i, value);
					}
					catch (Exception exc)
					{
						text.setText("Error: No update");
					}
				}
			};
		final int FIELD_WIDTH = 11;
		for (int i = 0; i < a.size(); i++)
		{
			JTextField textField = new JTextField(a.get(i).toString(),FIELD_WIDTH);
			textField.addActionListener(AL);
			add(textField);
			fieldList[i] = textField;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
