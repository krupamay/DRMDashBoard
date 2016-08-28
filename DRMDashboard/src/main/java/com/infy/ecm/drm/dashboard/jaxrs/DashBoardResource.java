package com.infy.ecm.drm.dashboard.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.infy.ecm.drm.dashboard.model.BurnDownInput;
import com.infy.ecm.drm.dashboard.model.BurnDownInputResponse;
import com.infy.ecm.drm.dashboard.service.DashBoardService;
import com.infy.ecm.drm.dashboard.serviceImpl.DashBoardServiceImpl;

@Path("dash-board-service")
public class DashBoardResource {

	private DashBoardService dashBoardService = new DashBoardServiceImpl();

	@POST
	@Path("/insertdata")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertData(BurnDownInput burnDownInput) {
		System.out.println("Inside jaxrs " + burnDownInput.getTeam());
		dashBoardService.InsertDailyData(burnDownInput);
		return Response.ok().entity("success").build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@Path("get")
	@GET
	public BurnDownInputResponse getBurnDownData(@Context UriInfo uriInfo) {
		String sprint = uriInfo.getQueryParameters().getFirst("sprint");
		String team = uriInfo.getQueryParameters().getFirst("team");

		return dashBoardService.getBurnDownData(sprint, team);

	}
}
