package tests.e2e.module;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResolvedPermissionGroups {
	private Map<String, String> permissionGroup = new HashMap<String, String>();

	@JsonAnySetter
	public void setPermissionGroup(String key, String value) {
		permissionGroup.put(key, value);
	}

	public Map<String, String> getPermissionGroup() {
		return permissionGroup;
	}
}