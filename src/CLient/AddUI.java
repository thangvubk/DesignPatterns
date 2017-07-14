package CLient;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddUI extends EditorUI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btAdd;
	public AddUI() {
		super();
		
		btAdd = new JButton("Add");
		btAdd.setBounds(550, 200, 100, 23);
		contentPane.add(btAdd);		
		setVisible(false);
	}
	
	
	public void addBtAddListener(ActionListener actionListener){
		btAdd.addActionListener(actionListener);
	}
	public JButton getBtAdd() {
		return btAdd;
	}
	public void setBtAdd(JButton btAdd) {
		this.btAdd = btAdd;
	}
	
	
}
