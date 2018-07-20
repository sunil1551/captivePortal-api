package com.captiveportal.island.utils;

public final class RestURLConstants {

	private RestURLConstants() {
		super();
	}

	// For Non-Ocean implementation
	public static final String BASE_PATH_V1 = "/api/v1";
	public static final String CAPTIVE_PORTAL = "/captiveportal";
	public static final String USERMANGEMENT = BASE_PATH_V1 + CAPTIVE_PORTAL + "/usermanagement";
	public static final String USER = "/user";
	public static final String FORGOT_PASSWORD = "/password";

}
