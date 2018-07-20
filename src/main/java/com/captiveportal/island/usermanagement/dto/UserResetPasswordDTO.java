package com.captiveportal.island.usermanagement.dto;

import javax.validation.constraints.NotNull;

import com.captiveportal.island.common.dto.BaseResponseDTO;

public class UserResetPasswordDTO implements BaseResponseDTO {
	@NotNull(message = "userName cannot be null")
	private String userName;

	@NotNull(message = "Password cannot be null")
	private String resetPassword;

	@NotNull(message = "Secret Question cannot be null")
	private String secretQuestion;

	@NotNull(message = "Answer cannot be null")
	private String answer;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "IslandUserResetPasswordDTO [userName=" + userName + ", password=" + resetPassword + ", secretQuestion="
				+ secretQuestion + ",answer=" + answer + "]";
	}

}
