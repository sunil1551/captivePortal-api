package com.captiveportal.island.usermanagement.service;

import com.captiveportal.island.common.dto.ResponseDTO;
import com.captiveportal.island.exception.ProcessException;
import com.captiveportal.island.usermanagement.dto.UserDTO;
import com.captiveportal.island.usermanagement.dto.UserResetPasswordDTO;

public interface UserMgmtService {

	ResponseDTO userRegistration(UserDTO islandUserDTO) throws ProcessException;

	ResponseDTO forgotPassword(UserResetPasswordDTO userResetPasswordDTO) throws ProcessException;

}
