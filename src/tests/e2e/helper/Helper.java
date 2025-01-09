package tests.e2e.helper;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.json.JsonObject;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import tests.e2e.dataStore.DataStore;
import tests.e2e.module.AllLocations;
import tests.e2e.module.Baseorder;
import tests.e2e.module.Catalogue;
import tests.e2e.module.Category;
import tests.e2e.module.Company;
import tests.e2e.module.DefaultRunNew;
import tests.e2e.module.LocationForUser;
import tests.e2e.module.Me;
import tests.e2e.module.Member;
import tests.e2e.module.PermissionForUser;
import tests.e2e.module.Project;
import tests.e2e.module.ResponseWithTotal;
import tests.e2e.module.Shipping;
import tests.e2e.module.SubCategory;
import tests.e2e.module.SupplyChain;
import tests.e2e.module.TemplateForms;
import tests.e2e.module.User;
import tests.e2e.module.Vendor;
import tests.e2e.staticKeys.Statickeys;

public class Helper {

	/* General */
	public static void logRequestduration(String requestType, String apiRoute, Response response, String startTime,
			String module) throws Exception {
		try {
			String requestDetails = (String) DataStore.getInstance().getProperty(Statickeys.log);
			String endTime = getUtcTimeZone();
			requestDetails = requestDetails + "\n" + "StartTime :" + startTime + "\n" + "EndTime :" + endTime + "\n";
			if (response == null) {
				requestDetails = requestDetails + "Request Type :" + requestType + "\n" + "Request End Api : "
						+ apiRoute + "\n" + "Request Status :" + "500" + "\n" + "module : " + module;
			} else if (response != null) {
				long requestTime = (response.getTime() / 1000) % 60;
				int requestStatus = response.getStatusCode();

				if (requestStatus == 500) {
					String requestBody = response.getBody().toString();
					requestDetails = requestDetails + "\n" + "Request Body :" + requestBody + "\n";
				}

				requestDetails = requestDetails + "Request Type :" + requestType + "\n" + "Request End Api : "
						+ apiRoute + "\n" + "Request Time :" + requestTime + "sec" + "\n" + "Request Status :"
						+ requestStatus + "\n" + "module : " + module + "\n";
			}
			DataStore.getInstance().setProperty(Statickeys.log, (Object) requestDetails);
			FileWriter fileObject = new FileWriter("ApiLog-Result.txt");
			fileObject.write(requestDetails);
			fileObject.close();
		} catch (Exception e) {
			throw new Exception("Error while log the Request duration" + e);
		}
	}

	public static String getUtcTimeZone(int offSetDate) throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, offSetDate);
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			return dateFormatter.format(calendar.getTime());
		} catch (Exception e) {
			throw new Exception("Error While getUtcTimeZone with Offset" + e);
		}
	}

	public static String getUtcTimeZone() throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			return dateFormatter.format(calendar.getTime());
		} catch (Exception e) {
			throw new Exception("Error While getUtcTimeZone without Offset" + e);
		}
	}

	public static String randomNameBuilder(String type) throws Exception {
		try {
			// chose a Character random from this String
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
			StringBuilder sb = new StringBuilder(16);

			for (int i = 0; i < 10; i++) {

				// generate a random number between
				// 0 to AlphaNumericString variable length
				int index = (int) (AlphaNumericString.length() * Math.random());

				// add Character one by one in end of sb
				sb.append(AlphaNumericString.charAt(index));
			}

			if (type == "part") {
				sb.append("_PART");
			} else if (type == "assembly") {
				sb.append("_ASMB");
			} else if (type == "order") {
				sb.append(":Order");
			} else if (type == "item") {
				sb.append(":Item");
			} else if (type == "projects") {
				sb.append(":project");
			} else if (type == "projectid") {
				sb.append("-id");
			} else if (type == "templateId") {
				sb.append("tempid");
			}

			return sb.toString();
		} catch (Exception e) {
			throw new Exception("Error While Generate randomNameBuilder" + e);
		}
	}

	public static String getUuid() throws Exception {
		try {
			UUID uuid = UUID.randomUUID();
			return uuid.toString();
		} catch (Exception e) {
			throw new Exception("Error While Generate UUID" + e);
		}
	}

	public static String getProjectName(String user, String project) {
		if (user.contains("Tarun Kumar")) {
			return "606fee109ff7ed0189638771";
		}
		return project;
	}

	public static String getbaseUrl(String instance) {
		if (instance.equals("local")) {
			return "http://localhost:3002/api/v4";
		}
		return "https://" + instance + ".manufacton.com/api/v4";
	}

	public static int getRandomNumber(int length) {
		Random rand = new Random();
		int int_random = rand.nextInt(length);

		return int_random;
	}

	public static ArrayList<String> getProjectsName() {
		ArrayList<String> projects = new ArrayList<>();
		projects.add("AMC HOSPITAL");
		projects.add("BUS YARD");
		projects.add("CITY LIBRARY");
		projects.add("MOUNTAIN HOUSE");
		projects.add("PARKWOOD");

		return projects;

	}

	public static ArrayList<String> getlocation() {
		ArrayList<String> values = new ArrayList<>();
		values.add("BOSTON");
		values.add("NEW YORK");
		values.add("LOS ANGELES");
		values.add("WOODLAND WINDOW STORAGE");
		values.add("MILFORD SHOP");
		values.add("VDD - SHIPPING");
		values.add("PRODUCTION - 1");
		values.add("PRODUCTION - 2");
		values.add("SHOP FLOOR");
		values.add("STORAGE");

		return values;

	}

	public static ArrayList<String> getlevels() {
		ArrayList<String> values = new ArrayList<>();
		values.add("Mechanical Yard");
		values.add("Roof");
		values.add("08-Mate Wall Build");
		values.add("29-Electrical Test");
		values.add("01-Floor Framing");
		return values;

	}

	public static ArrayList<String> getZone() {
		ArrayList<String> values = new ArrayList<>();
		values.add("Admin Area A");
		values.add("Zone A");
		values.add("Area A");
		values.add("Area B");
		values.add("Zone B");
		return values;

	}

	public static ArrayList<String> getMMOrderName() {
		ArrayList<String> values = new ArrayList<>();
		values.add("P1 POD - ROOM A");
		values.add("P2 POD - ROOM B");
		values.add("P3 POD - ROOM C");
		values.add("P4 POD - ROOM D");
		values.add("P5 POD - ROOM E");
		values.add("P6 POD - ROOM F");
		values.add("P7 POD - ROOM G");
		values.add("P8 POD - ROOM H");
		values.add("P9 POD - ROOM I");
		values.add("P10 POD - ROOM J");
		return values;

	}

	public static ArrayList<String> getPOOrderName() {
		ArrayList<String> values = new ArrayList<>();
		values.add("900mm Pipe - Wall Monted");
		values.add("exterior curtain wall");
		values.add("exterior insulation on masonry'");
		values.add("M_Curtain Wall Dbl Glass");
		values.add("Mechanical Supply Air 13'");
		values.add("Pavillion curtain wall");
		values.add("New SystemSS order");
		values.add("Storm hangers");
		values.add("framing system");
		values.add("Structural path reinforcement");
		values.add("Water hangers");
		values.add("PM fiberglass door");
		values.add("Load centres");
		values.add("PM steel door");
		values.add("smartglass windows");
		values.add("DR01:inverters");
		values.add("Added OH racks");
		values.add("TEMP Power skids");
		values.add("DR20:string orders");
		values.add("Newark memorial HS");
		return values;

	}

	public static ArrayList<String> getmmOrderItemName() {
		ArrayList<String> values = new ArrayList<>();
		values.add("1\" EMT INS STL RAINTITE CONN");
		values.add("1/2\" EMT INS STL RAINTITE CONN");
		values.add("1/4\" EMT INS STL RAINTITE CONN");
		values.add("1\" EMT > 1\" LQT FLEX CPLG");
		values.add("2\" EMT > 2\" LQT FLEX CPLG");
		values.add("3\" EMT LB SET SCREW");
		values.add("3/2\" EMT LB SET SCREW");
		values.add("4\" EMT LB SET SCREW");
		values.add("2 1/2-3\" COVER");
		values.add("NEOPRENE GASKET");
		values.add("EMT 90 ELBOW");
		values.add("PULL ELBOW");
		values.add("INS 90 SHORT ELBOW");
		values.add("WEATHER HEAD ENTR CAP");
		values.add("ENTRANCE LB");
		values.add("2\" ROOF FLASHING");
		values.add("PRESS ON INSULATED BUSHING");
		values.add("1\" SLEEVE");
		values.add("3/4\" GRC (GALV)");
		values.add("36\"RAD 90 ELBOW");
		values.add("GRC COUPLING");

		return values;

	}

	public static ArrayList<String> getpoOrderItemNames() {
		ArrayList<String> values = new ArrayList<>();
		values.add("Cut item");
		values.add("1.conduit item1");
		values.add("Box type1");
		values.add("duct bank1");
		values.add("fire alarm1");
		values.add("overhead rough items1");
		values.add("storm items 1");
		values.add("frames1");
		values.add("struct items flow1");
		values.add("hung AC1");
		values.add("fiber test item1");
		values.add("OH rack build1");
		values.add("dock door fans1");
		values.add("Canlights1");
		values.add("LV drawing rev1");
		values.add("RIE time study1");
		values.add("cage duct1");
		values.add("cup WR box1");
		values.add("strut frame1");
		return values;

	}

	public static ArrayList<String> getfirstName() {
		ArrayList<String> values = new ArrayList<>();
		values.add("John");
		values.add("catherine");
		values.add("michelle");
		values.add("vincent");
		values.add("jennifer");
		return values;

	}

	public static ArrayList<String> getlastName() {
		ArrayList<String> values = new ArrayList<>();
		values.add("Newquist");
		values.add("Joe");
		values.add("Jay");
		values.add("douglas");
		values.add("louis");
		return values;
	}

	public static String getResponceErrorMessage(Response response) {
		String rbody = response.asString();
		JsonPath jsonPath = new JsonPath(rbody);
		String error = jsonPath.getString("msg");
		return error;
	}

	public static void setDatastore(String key, Object value) {
		DataStore.getInstance().setProperty(key, value);
	}

	public static Object getDatastore(String key) {
		return DataStore.getInstance().getProperty(key);
	}
	
	public static Object convertResponceToJavaObject(Response responce, String moduleName) throws Exception {
		Object javaObject = null;

		String responseAsString = responce.asPrettyString();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode responceStringNode = mapper.readTree(responseAsString);
		moduleName = moduleName.toLowerCase(); // Use lowercase switch statements 
		switch (moduleName) {
		case "baseorder":
		 javaObject = mapper.treeToValue(responceStringNode, Baseorder.class);
		 break;
		case "alllocations":
		 javaObject = mapper.treeToValue(responceStringNode, AllLocations.class);
		 break;
		case "responsedao":
		 javaObject = mapper.treeToValue(responceStringNode, ResponseWithTotal.class);
		 break;
		case "shipping":
		 javaObject = mapper.treeToValue(responceStringNode, Shipping.class);
		 break;
		case "supplychain":
		 javaObject = mapper.treeToValue(responceStringNode, SupplyChain.class);
		 break;
		case "member":
		 javaObject = mapper.treeToValue(responceStringNode, Member.class);
		 break;
		case "company":
		 javaObject = mapper.treeToValue(responceStringNode, Company.class);
		 break;
		case "project":
		 javaObject = mapper.treeToValue(responceStringNode, Project.class);
		 break;
		case "login":
			 javaObject = mapper.treeToValue(responceStringNode, Me.class);
			 break;
		// Static key will duplicate so used lowercase "company"
		default:
		 throw new Exception("Error while conver Responce to Javaobject");
		}
		return javaObject;
	}
	
	public static Object convertObjectToJavaObject(Object objectResponce, String moduleName) throws Exception {
		Object javaObject = null;

		ObjectMapper mapper = new ObjectMapper();
		String stringResponce = mapper.writeValueAsString(objectResponce);
		moduleName = moduleName.toLowerCase();// Use lowercase switch statements 
		switch (moduleName) {
		case "baseorder":
		 javaObject = mapper.readValue(stringResponce , Baseorder.class);
		 break;
		case "allLocations":
		 javaObject = mapper.readValue(stringResponce , AllLocations.class);
		 break;
		case "catalogue":
		 javaObject = mapper.readValue(stringResponce , Catalogue.class);
		 break;
		case "category":
		 javaObject = mapper.readValue(stringResponce , Category.class);
		 break;
		case "subcategory":
		 javaObject = mapper.readValue(stringResponce , SubCategory.class);
		 break;
		case "vendor":
		 javaObject = mapper.readValue(stringResponce , Vendor.class);
		 break;
		case "loactionsforuser":
		 javaObject = mapper.readValue(stringResponce , LocationForUser.class);
		 break;
		case "permissionforuser":
		 javaObject = mapper.readValue(stringResponce , PermissionForUser.class);
		 break;
		case "project":
		 javaObject = mapper.readValue(stringResponce , Project.class);
		 break;
		case "templateforms":
		 javaObject = mapper.readValue(stringResponce , TemplateForms.class);
		 break;
		case "company":
		 javaObject = mapper.readValue(stringResponce , Company.class);
		 break;
		case "user":
		 javaObject = mapper.readValue(stringResponce , User.class);
		 break;
		case "defaultrunnew":
		 javaObject = mapper.readValue(stringResponce , DefaultRunNew.class);
		 break;
		default:
		 throw new Exception("Error while conver Object to JavaObject");
		}
		return javaObject;
	}

	public static Object convertStringToJavaObject(String stringResponce, String moduleName) throws Exception {
		Object javaObject = null;

		ObjectMapper mapper = new ObjectMapper();
		moduleName = moduleName.toLowerCase();// Use lowercase switch statements 
		switch (moduleName) {
		case "project":
		 javaObject = mapper.readValue(stringResponce , Project.class);
		 break;
		default:
		 throw new Exception("Error while conver Object to JavaObject");
		}
		return javaObject;
	}

	/* FOR Dashboard only */
	static int getOnsiteDiffrence(int invocationCount) throws Exception {
		try {
			int onsiteDate = 0;

			int lessThanWeekOnsite = -8;
			int thisWeekOnsite = 0;
			int preWeekOnsite = +7;

			int partitionNumber = (int) Math.floor(DataSourceHelper.orderCount / 3);
			onsiteDate = (int) Math.floor(Math.random() * (preWeekOnsite * 2) + preWeekOnsite);
			if (invocationCount < partitionNumber) {
				onsiteDate = (int) Math.floor(Math.random() * (lessThanWeekOnsite * 2) + lessThanWeekOnsite);
			}
			if (invocationCount >= partitionNumber && invocationCount < (partitionNumber * 2)) {
				onsiteDate = (int) Math.floor(Math.random() * (preWeekOnsite - 1));
			}
			return onsiteDate;
		} catch (Exception e) {
			throw new Exception("Error While getOnsiteDiffrence wrt invocationCount" + e);
		}
	}

	public static int setDataForDashboadScript(String scriptType, int invocationCount) throws Exception {
		try {
			if (scriptType.contains("dashboard")) {
				return getOnsiteDiffrence(invocationCount);
			}
			return 0;
		} catch (Exception e) {
			throw new Exception("Error While setDataForDashboadScript wrt scriptType" + e);
		}
	}

}
