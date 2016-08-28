package com.infy.ecm.drm.dashboard.dao;

import com.infy.ecm.drm.dashboard.model.BurnDownInput;
import com.infy.ecm.drm.dashboard.model.BurnDownInputResponse;

public interface DashBoardDao {

	public void InsertDailyData(BurnDownInput burnDownInput);
	public BurnDownInputResponse getBurnDownData(String sprint, String team);
}

