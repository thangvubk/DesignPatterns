package CLient;

public class Client {
	static ClientUI clientUI;
	static EditorUI editorUI;
	static IController controller;
	
	public static void main(String[] args) {
		clientUI = new ClientUI();
		controller = new ClientUIController(clientUI);
		controller.registerController(new AddUIController(new AddUI()));
		controller.registerController(new UpdateDelController(new UpdateDeleteUI()));
//		for(IController registeredCtrl: controller.getRegisteredController()){
//			registeredCtrl.setParent(controller);
//			registeredCtrl.execute();;
//		}
//		controller.execute();

	}
}
