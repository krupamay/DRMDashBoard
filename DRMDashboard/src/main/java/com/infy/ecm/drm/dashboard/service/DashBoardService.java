package com.infy.ecm.drm.dashboard.service;

import com.infy.ecm.drm.dashboard.model.BurnDownInput;
import com.infy.ecm.drm.dashboard.model.BurnDownInputResponse;

public interface DashBoardService {

	public void InsertDailyData(BurnDownInput burnDownInput);
	public BurnDownInputResponse getBurnDownData(String sprint, String team);
}
