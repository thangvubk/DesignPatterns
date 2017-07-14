package CLient;

import java.util.ArrayList;

public interface IController {
	public void execute();

	public void registerController(IController controller);

	public ArrayList<IController> getRegisteredController();

	public void update(Object code, Object params);

	public void setParent(IController controller);

	public void returnValueToParent();
}
