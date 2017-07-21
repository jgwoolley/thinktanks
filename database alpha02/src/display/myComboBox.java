package display;

import javax.swing.JComboBox;
import javax.swing.MutableComboBoxModel;

@SuppressWarnings("serial")
public class myComboBox extends JComboBox<String>{
	
	@SuppressWarnings("unchecked")
	public myComboBox(String[] list){
		super(list);
		this.setModel((MutableComboBoxModel<String>) getModel());
		
	}
}
