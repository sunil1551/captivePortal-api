package com.captiveportal.island.common.dto;

public class ResponseDTO {
	private Boolean isSuccessStatus;
	private Integer statusCode;
	private String successMessage;
	private String errormessage;
	private BaseResponseDTO BaseResponseDTO;

	public ResponseDTO(Boolean isSuccessStatus, Integer statusCode, String successMessage, String errormessage,
			BaseResponseDTO baseResponseDTO) {
		super();
		this.isSuccessStatus = isSuccessStatus;
		this.statusCode = statusCode;
		this.successMessage = successMessage;
		this.errormessage = errormessage;
		BaseResponseDTO = baseResponseDTO;
	}

	public Boolean getIsSuccessStatus() {
		return isSuccessStatus;
	}

	public void setIsSuccessStatus(Boolean isSuccessStatus) {
		this.isSuccessStatus = isSuccessStatus;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public BaseResponseDTO getBaseResponseDTO() {
		return BaseResponseDTO;
	}

	public void setBaseResponseDTO(BaseResponseDTO baseResponseDTO) {
		BaseResponseDTO = baseResponseDTO;
	}

}
