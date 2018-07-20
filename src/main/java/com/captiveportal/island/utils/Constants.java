
package com.captiveportal.island.utils;

public final class Constants {
	private Constants() {
		super();
	}

	// For Non-Ocean implementation
	public static final String REGISTRATION_FIELDS_BLANK = "DTO cannot be empty";
	public static final String REGISTRATION_FIELDS_ERROR = "No fields can be empty or null";
	public static final String REGISTRATION_SUCCESS_MSG = "You have been successfully registered. Please login now.";
	public static final String PASSWORD_POLICY = "^\\w{6,15}$";
	public static final String PASSWORD_LENGTH_CHECK = "Password should be of atleast 6 characters";
	public static final String FORGOTPASSWORD_FIELDS_BLANK = "No field in forgot password can be empty";
	public static final String INVALID_USERNAME = "Invalid Username";
	public static final String INVALID_SECRETQUESTION = "Invalid Secret Question";
	public static final String INVALID_PASSWORD_POLICY = "Password doesn't match password policy.";
	public static final String PASSWORD_CHECK = "Password can't be same as an existing password.";
	public static final String SECRET_KEY_NOT_REGISTERED = "SecretKey not registered. Please first login with your valid credentials.";
	public static final String RESETPWD_SUCCESS_MSG = "Password reset successfully. Please login now.";
	public static final String USERNAME_ALREADY_USED = "This username is already taken. Please use another.";
	public static final String PWD_SUCCESS_MSG = "Password reset done.Please login with a new credentials.";
	public static final String ERROR_MSG = "Something went wrong while processing the request";

	public static final String NAME_POLICY = "^[A-Za-z0-9]{6,30}$";
	public static final String USERNAME_POLICY = "^\\w{6,15}$";
	public static final String FIRST_NAME_POLICY = "^[0-9]$";

}
