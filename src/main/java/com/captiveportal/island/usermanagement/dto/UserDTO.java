package com.captiveportal.island.usermanagement.dto;

import javax.validation.constraints.NotNull;

import com.captiveportal.island.common.dto.BaseResponseDTO;

public class UserDTO implements BaseResponseDTO {

	@NotNull(message = "First Name cannot be null")
	// @Size(max = 30, min = 6, message = "FirstName must be between 6 and 30
	// characters")
	// @Pattern(regexp = "[^0-9]*")
	private String firstName;

	@NotNull(message = "Last Name cannot be null")
	private String lastName;

	@NotNull(message = "User Name cannot be null")
	private String userName;

	@NotNull(message = "Password cannot be null")
	private String password;

	@NotNull(message = "ReTypePassword cannot be null")
	private String reTypePassword;

	@NotNull(message = "Secret Question cannot be null")
	private String secretQuestion;

	@NotNull(message = "Answer cannot be null")
	private String answer;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReTypePassword() {
		return reTypePassword;
	}

	public void setReTypePassword(String reTypePassword) {
		this.reTypePassword = reTypePassword;
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
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", reTypePassword=" + reTypePassword + ", secretQuestion=" + secretQuestion + ", answer="
				+ answer + "]";
	}

}
