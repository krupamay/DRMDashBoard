package com.infy.ecm.drm.dashboard.dao;

import java.util.ArrayList;
import java.util.List;

import com.infy.ecm.drm.dashboard.config.Client;
import com.infy.ecm.drm.dashboard.model.BurnDownInput;
import com.infy.ecm.drm.dashboard.model.BurnDownInputResponse;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.pojo.PojoPage;
import com.marklogic.client.pojo.PojoQueryBuilder;
import com.marklogic.client.pojo.PojoRepository;
import com.marklogic.client.query.StructuredQueryDefinition;

public class DashBoardDaoImpl implements DashBoardDao {

	private DatabaseClient client = Client.getClient();

	private PojoRepository<BurnDownInput, Integer> repo = client.newPojoRepository(BurnDownInput.class, Integer.class);

	public void InsertDailyData(BurnDownInput burnDownInput) {

		repo.write(burnDownInput);

	}

	public BurnDownInputResponse getBurnDownData(String sprint, String team) {
		List<BurnDownInput> list = new ArrayList<BurnDownInput>();
		BurnDownInputResponse result = new BurnDownInputResponse();
		PojoQueryBuilder<BurnDownInput> qb = repo.getQueryBuilder();
		StructuredQueryDefinition structuredQueryDefinition = qb.and(qb.value("sprint", sprint),
				qb.value("team", team));
		PojoPage<BurnDownInput> matches = repo.search(structuredQueryDefinition, 1);
		if (matches.hasContent()) {
			while (matches.hasNext()) {
				BurnDownInput obj = matches.next();
				list.add(obj);
				System.out.println(obj.getId());
			}
		} else {

			System.out.println("No matches");
			return result;
		}
		result.getResponse().addAll(list);
		return result;
	}

}
