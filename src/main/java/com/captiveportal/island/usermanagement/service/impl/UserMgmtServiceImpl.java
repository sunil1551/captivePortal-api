package com.captiveportal.island.usermanagement.service.impl;

import static com.captiveportal.island.utils.Constants.ERROR_MSG;
import static com.captiveportal.island.utils.Constants.FIRST_NAME_POLICY;
import static com.captiveportal.island.utils.Constants.INVALID_PASSWORD_POLICY;
import static com.captiveportal.island.utils.Constants.INVALID_USERNAME;
import static com.captiveportal.island.utils.Constants.NAME_POLICY;
import static com.captiveportal.island.utils.Constants.PASSWORD_CHECK;
import static com.captiveportal.island.utils.Constants.PASSWORD_POLICY;
import static com.captiveportal.island.utils.Constants.REGISTRATION_SUCCESS_MSG;
import static com.captiveportal.island.utils.Constants.RESETPWD_SUCCESS_MSG;
import static com.captiveportal.island.utils.Constants.USERNAME_POLICY;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.captiveportal.island.common.dto.ResponseDTO;
import com.captiveportal.island.exception.ErrorCode;
import com.captiveportal.island.exception.ProcessException;
import com.captiveportal.island.usermanagement.dto.UserDTO;
import com.captiveportal.island.usermanagement.dto.UserResetPasswordDTO;
import com.captiveportal.island.usermanagement.repository.UserMgmtRepository;
import com.captiveportal.island.usermanagement.service.UserMgmtService;
import com.carnival.utility.model.IslandUser;

/**
 * @author e00987/e01551
 *
 */
@Service
public class UserMgmtServiceImpl implements UserMgmtService {

	private static final Logger logger = LoggerFactory.getLogger(UserMgmtServiceImpl.class);

	private UserMgmtRepository islandUserMgmtRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserMgmtServiceImpl(UserMgmtRepository islandUserMgmtRepository, PasswordEncoder passwordEncoder) {
		this.islandUserMgmtRepository = islandUserMgmtRepository;
		this.passwordEncoder = passwordEncoder;
	}

	/*
	 * This method is for user registration
	 */
	@Override
	public ResponseDTO userRegistration(UserDTO islandUserDTO) throws ProcessException {
		logger.debug("Register user for an island user : {}", islandUserDTO.getUserName());
		String pattern = PASSWORD_POLICY;
		String namePolicy = NAME_POLICY;
		String userNamePolicy = USERNAME_POLICY;
		String firstNamePolicy = FIRST_NAME_POLICY;
		IslandUser islandUser = checkUserNameExists(islandUserDTO);
		if (islandUser != null) {
			logger.error("Username already exists : {}", islandUserDTO.getUserName());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.INVALID_REGISTRATION_REQUEST, null,
					ErrorCode.INVALID_REGISTRATION_REQUEST_DESC, null);
		}
		if (!islandUserDTO.getPassword().matches(pattern)) {
			logger.error("Password should be between 6 to 15 characters: {}", islandUserDTO.getPassword());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.PASSWORD_LENGTH_CHECK, null,
					ErrorCode.PASSWORD_LENGTH_CHECK_DESC, null);
		}
		
		if (!islandUserDTO.getReTypePassword().matches(pattern)) {
			logger.error("Password should be between 6 to 15 characters: {}", islandUserDTO.getReTypePassword());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.PASSWORD_LENGTH_CHECK, null,
					ErrorCode.PASSWORD_LENGTH_CHECK_DESC, null);
		}

		// added validations

		if (!(islandUserDTO.getFirstName().matches(namePolicy))) {
			logger.error("FirstName should be between 6 to 30 characters: {}", islandUserDTO.getFirstName());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.FIRSTNAME_LENGTH_CHECK, null,
					ErrorCode.FIRSTNAME_LENGTH_CHECK_DESC, null);
		}

		if (!(islandUserDTO.getFirstName().matches(firstNamePolicy))) {
			logger.error("FirstName should not contains digits: {}", islandUserDTO.getFirstName());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.FIRSTNAME_DIGIT_CHECK, null,
					ErrorCode.FIRSTNAME_DIGIT_CHECK_DESC, null);
		}

		if (!(islandUserDTO.getLastName().matches(namePolicy))) {
			logger.error("LastName should be between 6 to 30 characters: {}", islandUserDTO.getLastName());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.LASTNAME_LENGTH_CHECK, null,
					ErrorCode.LASTNAME_LENGTH_CHECK_DESC, null);
		}

		if (!(islandUserDTO.getLastName().matches(firstNamePolicy))) {
			logger.error("LastName should not contains digits: {}", islandUserDTO.getLastName());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.LASTNAME_DIGIT_CHECK, null,
					ErrorCode.LASTNAME_DIGIT_CHECK_DESC, null);
		}

		if (!(islandUserDTO.getUserName().matches(pattern))) {
			logger.error("UserName should be between 6 to 15 characters: {}", islandUserDTO.getUserName());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.USERNAME_LENGTH_CHECK, null,
					ErrorCode.USERNAME_LENGTH_CHECK_DESC, null);
		}

		if (!islandUserDTO.getReTypePassword().equals(islandUserDTO.getPassword())) {
			logger.error("Password does not match.Please enter again : {}", islandUserDTO.getReTypePassword());
			return new ResponseDTO(Boolean.FALSE, ErrorCode.RESETPWD_ERROR_MSG, null, ErrorCode.RESETPWD_ERROR_MSG_DESC,
					null);
			// throw new ProcessException(ErrorCode.RESETPWD_ERROR_MSG,
			// HttpStatus.BAD_REQUEST.value());
		}

		IslandUser newIslandUser = new IslandUser();
		newIslandUser.setFirstName(islandUserDTO.getFirstName());
		newIslandUser.setLastName(islandUserDTO.getLastName());
		newIslandUser.setUserName(islandUserDTO.getUserName());
		newIslandUser.setPassword(passwordEncoder.encode(islandUserDTO.getPassword()));
		newIslandUser.setSecretQuestion(islandUserDTO.getSecretQuestion());
		newIslandUser.setAnswer(islandUserDTO.getAnswer());
		newIslandUser.setActiveStatus(Boolean.TRUE);
		try {
			islandUserMgmtRepository.save(newIslandUser);
			// return new ResponseDTO<>(Boolean.TRUE, null,
			// REGISTRATION_SUCCESS_MSG, null, null);
		} catch (DataAccessException dataAccessException) {
			logger.error("Data access exception occurred while resetting password {}", dataAccessException);
			throw new ProcessException(ERROR_MSG, HttpStatus.INTERNAL_SERVER_ERROR.value(), dataAccessException,
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error("Exception occurred while resetting password {}", e);
			throw new ProcessException(ERROR_MSG, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		// return new ResponseDTO<>(Boolean.TRUE, null,
		// REGISTRATION_SUCCESS_MSG, null, null);
		return new ResponseDTO(Boolean.TRUE, HttpStatus.CREATED.value(), REGISTRATION_SUCCESS_MSG, null, null);
	}

	/*
	 * This method is for reset password in case user forgot password
	 */
	@Override
	public ResponseDTO forgotPassword(UserResetPasswordDTO userResetPasswordDTO) throws ProcessException {
		logger.debug("Reset password for island user : {}", userResetPasswordDTO.getUserName());
		String pattern = PASSWORD_POLICY;
		IslandUser islandUser = null;
		try {
			islandUser = islandUserMgmtRepository.findByUserName(userResetPasswordDTO.getUserName());
			if (islandUser == null) {
				throw new ProcessException(INVALID_USERNAME, HttpStatus.BAD_REQUEST.value(), null,
						HttpStatus.BAD_REQUEST);
			}
			/*
			 * if
			 * (!passwordEncoder.matches(userResetPasswordDTO.getSecretQuestion(
			 * ), islandUser.getSecretKey())) { throw new
			 * ProcessException(INVALID_SECRETQUESTION,
			 * HttpStatus.BAD_REQUEST.value(), null, HttpStatus.BAD_REQUEST); }
			 */
			if (!userResetPasswordDTO.getResetPassword().matches(pattern)) {
				throw new ProcessException(INVALID_PASSWORD_POLICY, HttpStatus.PRECONDITION_FAILED.value(), null,
						HttpStatus.PRECONDITION_FAILED);
			}
			if (passwordEncoder.matches(userResetPasswordDTO.getResetPassword(), islandUser.getPassword())) {
				throw new ProcessException(PASSWORD_CHECK, HttpStatus.PRECONDITION_FAILED.value(),
						HttpStatus.PRECONDITION_FAILED);
			}
			islandUser.setPassword(passwordEncoder.encode(userResetPasswordDTO.getResetPassword()));
			islandUser = islandUserMgmtRepository.save(islandUser);
			if (islandUser == null)
				throw new ProcessException("Couldn't reset island user password",
						HttpStatus.INTERNAL_SERVER_ERROR.value());
		} catch (DataAccessException dataAccessException) {
			logger.error("Data access exception occurred while resetting password {}",
					dataAccessException.getMessage());
			throw new ProcessException("Data access exception occurred while resetting islands user password",
					HttpStatus.INTERNAL_SERVER_ERROR.value(), dataAccessException, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseDTO(Boolean.TRUE, null, RESETPWD_SUCCESS_MSG, null, null);
	}

	private IslandUser checkUserNameExists(UserDTO islandUserDTO) throws ProcessException {
		IslandUser islandUser = null;
		try {
			islandUser = islandUserMgmtRepository.findByUserName(islandUserDTO.getUserName());
		} catch (Exception e) {
			throw new ProcessException("User exists with user name : " + islandUserDTO.getUserName());
		}
		return islandUser;
	}
}
