package tests.e2e.services;

import java.util.ArrayList;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Member;
import tests.e2e.module.PermissionForUser;
import tests.e2e.staticKeys.Statickeys;

public class MemberDao {

	public static Member memberAdd() throws Exception {

		try {
			int randomNumber1;
			int randomNumber2;
			Member member = new Member();
			member.setAction("");
			member.setApp("");
			member.setAutoAdd("");
			member.setDisableAutoAdd(false);
			member.setEditing(true);
			member.setRole("coordinator");

			String first = Helper.randomNameBuilder("");
			member.setFirstName(first);

			String last = Helper.randomNameBuilder("");
			member.setLastName(last);

			member.setEmail(first + "@" + last + ".comp");
			member.setNewRow(true);
			member.setStatus("");
			member.setSecondaryRoles(new ArrayList<Object>());

			PermissionForUser PermissionForUserValue = (PermissionForUser) Helper.getDatastore(Statickeys.permission);
			ArrayList<String> PermissionIds = new ArrayList<>();
			PermissionIds.add(PermissionForUserValue.get_id());
			member.setPermissionGroups(PermissionIds);
			return member;
		} catch (Exception e) {
			throw new Exception("Error while Memeber ADD" + e);
		}

	}
}
