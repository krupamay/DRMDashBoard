package com.infy.ecm.drm.dashboard.serviceImpl;

import com.infy.ecm.drm.dashboard.dao.DashBoardDao;
import com.infy.ecm.drm.dashboard.dao.DashBoardDaoImpl;
import com.infy.ecm.drm.dashboard.model.BurnDownInput;
import com.infy.ecm.drm.dashboard.model.BurnDownInputResponse;
import com.infy.ecm.drm.dashboard.service.DashBoardService;

public class DashBoardServiceImpl implements DashBoardService{

	private DashBoardDao dashBoardDao = new DashBoardDaoImpl();
	
	public void InsertDailyData(BurnDownInput burnDownInput) {
		
		dashBoardDao.InsertDailyData(burnDownInput);
	}

	public BurnDownInputResponse getBurnDownData(String sprint, String team) {
		
		return dashBoardDao.getBurnDownData(sprint, team);
	}

	
}
