package tests.e2e.endPoints;

public class PrefabPlanner extends TemplateOrders {

	public static String createPrefab = "/prefabs/create";
	
	public static  String getPrefabUpdateRoutes(String cardId) {
		return "/prefabs/update/" + cardId;	
	}
	
	public static String getMoveToPoUpdateID(String cardId) {
		return "/move/updatePO/" + cardId;
	}
}
