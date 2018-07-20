package com.captiveportal.island.usermanagement.controller;

import static com.captiveportal.island.utils.RestURLConstants.FORGOT_PASSWORD;
import static com.captiveportal.island.utils.RestURLConstants.USER;
import static com.captiveportal.island.utils.RestURLConstants.USERMANGEMENT;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.captiveportal.island.common.dto.ResponseDTO;
import com.captiveportal.island.exception.ErrorCode;
import com.captiveportal.island.exception.ProcessException;
import com.captiveportal.island.usermanagement.dto.UserDTO;
import com.captiveportal.island.usermanagement.dto.UserResetPasswordDTO;
import com.captiveportal.island.usermanagement.service.UserMgmtService;

@RestController
@RequestMapping(USERMANGEMENT)
public class UserManagementController {
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

	private UserMgmtService userMgmtService;

	@Autowired
	public UserManagementController(UserMgmtService userMgmtService) {
		this.userMgmtService = userMgmtService;
	}

	@PostMapping(value = USER)
	public ResponseEntity<ResponseDTO> userRegistration(@RequestBody @Valid UserDTO userDTO,
			BindingResult bindingResult) throws ProcessException {
		logger.debug("Request received to register a new user with user Name : {}", userDTO.getUserName());
		ResponseDTO responseDTO = null;

		if (bindingResult.hasErrors()) {
			logger.error("Unable to process the request.Invalid request: {}", userDTO);
			responseDTO = new ResponseDTO(Boolean.FALSE, ErrorCode.INTERNAL_SERVER_ERROR, null,
					ErrorCode.INTERNAL_SERVER_ERROR_DESC, null);
			return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
		}
		responseDTO = userMgmtService.userRegistration(userDTO);
		if (responseDTO.getStatusCode() == HttpStatus.CREATED.value()) {
			logger.debug("Registration done for a user : {}", userDTO.getUserName());
			return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
		} else
			return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value = FORGOT_PASSWORD)
	public ResponseEntity<ResponseDTO> forgotPassword(@RequestBody UserResetPasswordDTO userResetPasswordDTO,
			BindingResult bindingResult) throws ProcessException {
		logger.debug("Request received to reset password in case user forgot a password for user Name : {}",
				userResetPasswordDTO.getUserName());
		ResponseDTO responseDTO = null;
		if (bindingResult.hasErrors()) {
			throw new ProcessException(bindingResult.getFieldError().getDefaultMessage());
		}
		responseDTO = userMgmtService.forgotPassword(userResetPasswordDTO);
		logger.debug("Password reset done for user : {}", userResetPasswordDTO.getUserName());
		return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
	}

}
