import mt.mas.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.List;
public class Main {

	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
		StandardServiceRegistry registry = null;
		SessionFactory sessionFactory = null;

		try {
			registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			Address address = new Address("Zbójnicka", "Warszawa", "05-241", "26D");

			InsuranceAgent insuranceAgent = new InsuranceAgent(address);

			Risk risk = new Risk("Death", "In case of death insurance", 100.0);
			Risk risk2 = new Risk("Accident", "In case of accident insurance", 100.0);

			List<Risk> risks = new ArrayList<>();
			risks.add(risk);
			risks.add(risk2);

			InsuranceVariant insuranceVariant = new InsuranceVariant("Covid insurance", LocalDate.parse("2020-01-01"), risks);

			System.out.println(insuranceVariant);

			RepresentativeOfTheCompany representativeOfTheCompany = new RepresentativeOfTheCompany("201403423");

			Address companyAddress = new Address("Waleczna", "Warszawa", "05-241", "22");

			InsuredCompany insuredCompany = new InsuredCompany("Amazon", "42113", "421432", companyAddress);

			BusinessType businessType = new BusinessType("IT", LocalDate.parse("2020-01-01"), LocalDate.parse("2020-11-01"), 100, insuredCompany);

			RepresentativeOfTheCompanyInsuredCompany representativeOfTheCompanyInsuredCompany = new RepresentativeOfTheCompanyInsuredCompany(LocalDate.parse("2020-01-01"), LocalDate.parse("2020-11-01"), representativeOfTheCompany, insuredCompany);

			GroupInsuranceSupervisor groupInsuranceSupervisor = new GroupInsuranceSupervisor();

			Contract contract = new Contract(LocalDate.parse("2020-01-01"), LocalDate.parse("2020-12-01"), insuranceAgent, insuranceVariant, insuredCompany, groupInsuranceSupervisor);

			Address insuredAddress = new Address("Ostrożna", "Warszawa", "05-241", "3");

			Insured insured = new Insured(LocalDate.parse("2020-01-01"), LocalDate.parse("2020-12-01"), contract, insuredAddress, insuredCompany);




			/*

			Address address = new Address("Kwiatowa", "Legionowo", "05-120", "32B");
			InsuranceAgent insuranceAgent = new InsuranceAgent(address);



			InsuranceVariant insuranceVariant = new InsuranceVariant("Best Doctors",LocalDate.parse("2019-01-01"),  new ArrayList<>());

			Risk risk = new Risk("Cancer", "Help smokers with cancer", 50.0, insuranceVariant);

			Risk risk2 = new Risk("Death", "Help your family, even from the other side!", 70.0, insuranceVariant);


			InsuredCompany amazon = new InsuredCompany("Amazon", "5252546391", "0000447948",address, new ArrayList<>());

			BusinessType businessType = new BusinessType("Construction", LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-01"), 50, amazon);

			BusinessType businessType2 = new BusinessType("IT", LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-01"), 50, amazon);

			amazon.addBusinessType(businessType);


			GroupInsuranceSupervisor groupInsuranceSupervisor = new GroupInsuranceSupervisor();

			Contract contract = new Contract(LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-01"), insuranceVariant, amazon, groupInsuranceSupervisor);

			Insured insured = new Insured(LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-01"), contract, address, amazon);
			Insured insured2 = new Insured(LocalDate.parse("2019-01-01"), LocalDate.parse("2020-01-01"), contract, address, amazon);

			ArrayList<Contract> contracts = new ArrayList();
			contracts.add(contract);
			InsuranceAgent insuranceAgent1 = new InsuranceAgent(address,contracts);

			RepresentativeOfTheCompany representativeOfTheCompany = new RepresentativeOfTheCompany("780421321");

			RepresentativeOfTheCompanyInsuredCompany representativeOfTheCompanyInsuredCompany
					= new RepresentativeOfTheCompanyInsuredCompany(
							LocalDate.parse("2019-01-01"),
							LocalDate.parse("2020-01-01"),
							representativeOfTheCompany,
							amazon);
*/

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//session.save(address);
			//session.save(insuranceAgent);
			//session.save(insuranceAgent1);
			//session.save(insuranceVariant);
			session.save(contract);
			session.getTransaction().commit();
			session.close();

		}
		catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
		finally {
			if (sessionFactory != null) {
				sessionFactory.close();
				sessionFactory = null;
			}
		}
	}
}