package com.captiveportal.island.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Error code and code description constant class.
 * 
 * @author E00926
 *
 */
@Component
@PropertySource("file:${ISLAND_CAPTIVE_PROP_PATH}/errormapping.properties")
public class ErrorCode {

	// Error code description
	public static final Integer INTERNAL_SERVER_ERROR = 3001;
	public static final Integer PASSWORD_LENGTH_CHECK = 3002;
	public static final Integer INVALID_REQUEST = 3003;
	public static final Integer INVALID_SECRETQUESTION = 3004;
	public static final Integer INVALID_ANSWER = 3005;
	public static final Integer RETYPE_PWD_CHECK = 3006;
	public static final Integer RESETPWD_ERROR_MSG = 3007;

	public static final Integer INVALID_REGISTRATION_REQUEST = 3008;
	public static final Integer FIRSTNAME_LENGTH_CHECK = 3009;
	public static final Integer LASTNAME_LENGTH_CHECK = 3010;
	public static final Integer USERNAME_LENGTH_CHECK = 3011;
	public static final Integer FIRSTNAME_DIGIT_CHECK = 3012;
	public static final Integer LASTNAME_DIGIT_CHECK = 3013;

	public static String INTERNAL_SERVER_ERROR_DESC;
	public static String PASSWORD_LENGTH_CHECK_DESC;
	public static String INVALID_REQUEST_DESC;
	public static String INVALID_SECRETQUESTION_DESC;
	public static String INVALID_ANSWER_DESC;
	public static String RETYPE_PWD_CHECK_DESC;
	public static String RESETPWD_ERROR_MSG_DESC;

	public static String INVALID_REGISTRATION_REQUEST_DESC;
	public static String FIRSTNAME_LENGTH_CHECK_DESC;
	public static String LASTNAME_LENGTH_CHECK_DESC;
	public static String USERNAME_LENGTH_CHECK_DESC;
	public static String FIRSTNAME_DIGIT_CHECK_DESC;
	public static String LASTNAME_DIGIT_CHECK_DESC;

	@Value("${error.desc.3001}")
	public void setInternalServerError(String errorDesc) {
		INTERNAL_SERVER_ERROR_DESC = errorDesc;
	}

	@Value("${error.desc.3002}")
	public void setPwdLengthCheck(String errorDesc) {
		PASSWORD_LENGTH_CHECK_DESC = errorDesc;
	}

	@Value("${error.desc.3003}")
	public void setInvalidRequest(String errorDesc) {
		INVALID_REQUEST_DESC = errorDesc;
	}

	@Value("${error.desc.3004}")
	public void setInvalidSecretQues(String errorDesc) {
		INVALID_SECRETQUESTION_DESC = errorDesc;
	}

	@Value("${error.desc.3005}")
	public void setInvalidAns(String errorDesc) {
		INVALID_ANSWER_DESC = errorDesc;
	}

	@Value("${error.desc.3006}")
	public void setRetypePwdCheck(String errorDesc) {
		RETYPE_PWD_CHECK_DESC = errorDesc;
	}

	@Value("${error.desc.3007}")
	public void setResetPwdErrorMsg(String errorDesc) {
		RESETPWD_ERROR_MSG_DESC = errorDesc;
	}

	@Value("${error.desc.3008}")
	public void setInvalidRegistrationRequest(String errorDesc) {
		INVALID_REGISTRATION_REQUEST_DESC = errorDesc;
	}

	@Value("${error.desc.3009}")
	public void setFirstNameLengthCheck(String errorDesc) {
		FIRSTNAME_LENGTH_CHECK_DESC = errorDesc;
	}

	@Value("${error.desc.3010}")
	public void setLastNameLengthCheck(String errorDesc) {
		LASTNAME_LENGTH_CHECK_DESC = errorDesc;
	}

	@Value("${error.desc.3011}")
	public void setUserNameLengthCheck(String errorDesc) {
		USERNAME_LENGTH_CHECK_DESC = errorDesc;
	}
	
	@Value("${error.desc.3012}")
	public void setFirstNameDigitCheck(String errorDesc) {
		FIRSTNAME_DIGIT_CHECK_DESC = errorDesc;
	}
	
	@Value("${error.desc.3013}")
	public void setLastNameDigitCheck(String errorDesc) {
		LASTNAME_DIGIT_CHECK_DESC = errorDesc;
	}
}
