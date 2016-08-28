package com.infy.ecm.drm.dashboard.model;

import java.util.Collections;
import java.util.List;

public class BurnDownInputResponse {

	private List<BurnDownInput> response;

	/**
	 * @return the response
	 */
	public List<BurnDownInput> getResponse() {
		if(response == null) {
			return Collections.emptyList();
		}
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(List<BurnDownInput> response) {
		this.response = response;
	}
	
}
