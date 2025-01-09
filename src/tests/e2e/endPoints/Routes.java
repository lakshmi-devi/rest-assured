package tests.e2e.endPoints;

public class Routes extends ShippingEndPoint {

	// login
	public static String login = "login";

	// SCM
	public static String supplyChainAPI = "/supplyChains";

	// Projects
	public static String getProject = "/projects/allProjectsForUser";
	public static String createProject = "/projects/update";
	public static String getProjectForUser = "/projects/allProjectsForUser";

	//company Level
	public static String getLocation = "/location/getLocationsForUser";
	public static String getUser = "/projects/listUsers";
	public static String createMember = "/users/editUser";
	public static String getCompany = "companies/get";
	public static String getCompanyRuns = "/companies/getCompanyRuns";
	public static String getAllLocations = "/location/getAllLocationsForUser";
	public static String getCompanyProjectAllLinkedUsersRoute = "/users/getCompanyProjectAllLinkedUsers";
	public static String getTemplateForms = "/formBuilder/getTemplateForms";
	public static String getTransferRequest = "/task/list";
	public static String getPermissionGroups = "/companies/getPermissionGroups";

	public static String getCategories = "/categories";
	public static String getSubCategories = "/categories/subCategories";

	public static String getCatalogue = "/catalogue";
	public static String archiveCatalogue = "/catalogue/archive/items";
	public static String createParts = "/catalogue/add/items";
	public static String createAssembly = "/catalogue/add/assemblies";

	public static String getCompanyVendors = "/vendors";
	
	//Ryvit API
	public static String createRyvitProject = "/projects/ryvitCreateProject";
	
	
	public static String getCreateBOMID(String cardId) {
		return "/materials/createBOM/" + cardId;
	}
	
	public static String getAddMaterialCardID(String cardId) {
		return "/orders/addMaterials/" + cardId;
	}
	
	
}
