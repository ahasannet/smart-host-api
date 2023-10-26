package com.shameem.smarthost.data.payloads.response;

public class HostResponse {

    private boolean success;
    
	public HostResponse(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

    
}
