package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import datastructures.Table;
import datastructures.ThinkTank;
import datastructures.Trait;
import field.Affiliation;
import field.City;
import field.Coordinates;
import field.Country;
import field.Province;
import field.Region;
import field.SubRegion;

public class TraitButton<T> extends JButton{

	
	public TraitButton(Panel_Query frame,T object,int index){
		super();		
		this.setText(object.toString());
		this.setToolTipText(object.toString());
		this.addActionListener(new TraitButtonListener(frame,index));
	}
	
	public class TraitButtonListener implements ActionListener{
		int index;
		Panel_Query frame;
		public TraitButtonListener(Panel_Query frame, int index){
			this.index = index;
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ComboPanel.createQuery(frame, frame.getReadTable(), getText(), index, -1);

		}
	}
}
