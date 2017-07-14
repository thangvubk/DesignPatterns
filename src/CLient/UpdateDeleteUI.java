package CLient;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UpdateDeleteUI extends EditorUI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btUpdate;
	private JButton btDelete;
	public UpdateDeleteUI() {
		super();
		btUpdate = new JButton("Update");
		btUpdate.setBounds(550, 200, 100, 23);
		contentPane.add(btUpdate);		
		
		btDelete = new JButton("Delete");
		btDelete.setBounds(400, 200, 100, 23);
		contentPane.add(btDelete);
		setVisible(false);
	}
	
	public void addBtUpdateDelAction(ActionListener listener){
		btUpdate.addActionListener(listener);
		btDelete.addActionListener(listener);
	}
	
	
	
	public JButton getBtUpdate() {
		return btUpdate;
	}
	public void setBtUpdate(JButton btUpdate) {
		this.btUpdate = btUpdate;
	}
	public JButton getBtDelete() {
		return btDelete;
	}
	public void setBtDelete(JButton btDelete) {
		this.btDelete = btDelete;
	}
	
}
