package ServiceImpl;

import java.util.List;

import DaoImpl.TesterDaoImpl;
import Entity.Project;
import Entity.Tester;
import Service.TesterService;



public class TesterServiceImpl implements TesterService {
	TesterDaoImpl testerDao=new TesterDaoImpl();

	@Override
	public Tester addTester(Tester tester) {
		// TODO Auto-generated method stub
		return testerDao.addTester(tester);
			
	}

	@Override
	public List<Tester> getAllTesters() {
		// TODO Auto-generated method stub
		return testerDao.getAllTesters();
	}
	@Override
	public Tester getTester(int testID) {
		// TODO Auto-generated method stub
		return testerDao.getTester(testID);
	}


	@Override
	public String deleteTester(int testID) {
		// TODO Auto-generated method stub
		return testerDao.deleteTester(testID);
	}

	@Override
	public Tester updateTester(int testID, Tester updatedTester) {
		// TODO Auto-generated method stub
		return testerDao.updateTester(testID, updatedTester);
	}

	@Override
	public Project getProject(int projectID) {
		// TODO Auto-generated method stub
		return testerDao.getProject(projectID);
	}


}
