package models;

import java.util.LinkedHashMap;
import java.util.Map;

import com.avaje.ebean.annotation.EnumValue;

public enum Role {
	@EnumValue("ADMIN")
	ADMIN,
	@EnumValue("ADMIN_MANAGER")
	ADMIN_MANAGER,
	@EnumValue("CANDIDATE")
	CANDIDATE;

	public static Map<String, String> options() {
		final LinkedHashMap<String, String> vals = new LinkedHashMap<String, String>();
		for (final Role val : Role.values()) {
			vals.put(val.toString(), val.toString());
		}
		return vals;
	}
}
