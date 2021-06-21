package sample.database;

import org.kohsuke.randname.RandomNameGenerator;
import sample.database.dao.IGenericDAO;
import sample.model.InsuranceAgent;
import sample.model.Person;

import javax.inject.Inject;
import java.util.List;
import java.util.Random;

public class InsuranceAgentService {

    private final IGenericDAO<InsuranceAgent, Integer> insuranceAgentDAO;

    @Inject
    public InsuranceAgentService(IGenericDAO<InsuranceAgent, Integer> insuranceAgentDAO) {
        this.insuranceAgentDAO = insuranceAgentDAO;
    }

    public List<InsuranceAgent> getAll() {
        return insuranceAgentDAO.getAll();
    }
}
