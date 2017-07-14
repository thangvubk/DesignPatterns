package CLient;

import java.util.ArrayList;

import javax.swing.JFrame;

import CustomerFactory.CustomerFactory;
import Repository.CustomerTransaction;
import Repository.IRepository;
import Repository.MySQLRepository;

public abstract class ControllerBase implements IController{
	protected JFrame UI;
	protected CustomerFactory custFactory;
	protected CustomerTransaction custTran;
	protected IRepository repo;
	protected ArrayList<IController> registestedController = null;
	protected IController parentController = null;
	public ControllerBase(JFrame newUI) {
		UI = newUI;
		custFactory = CustomerFactory.getInstance();
		custTran = CustomerTransaction.getInstance();
		repo = new MySQLRepository();
	}
	
	@Override
	public void registerController(IController controller){
		registestedController.add(controller);
	}
	
	@Override
	public void setParent(IController controller){
		parentController = controller;
	}
	
	@Override
	public ArrayList<IController> getRegisteredController(){
		return registestedController;
	}
}
