package tests.e2e.endPoints;

public class ProductionManager extends PrefabPlanner {

	public static String createPO = "/prodTemplates/createOrderFromTemplate";
	public static String moveToCoord = "/move/moveToPO";
	public static String moveToPM = "/move/moveTOPM";

	public static  String getPMUpdateRoutes(String cardId) {
		return "/OrdersManager/update/" + cardId;	
	}
	
	public static  String getMoveToManufRoutes(String cardId) {
		return "/OrdersManager/moveTo/manufacturing/" + cardId;	
	}

	public static  String getQaMoveRoutes(String cardId) {
		return "/OrdersManager/moveTo/qa/" + cardId;	
	}
	
	public static  String getBaseorderByID(String cardId) {
		return "/ordersManager/get/" + cardId;	
	}

}
