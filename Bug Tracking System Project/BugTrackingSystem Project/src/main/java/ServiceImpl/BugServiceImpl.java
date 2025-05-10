package ServiceImpl;

import java.util.List;

import DaoImpl.BugDaoImpl;
import Entity.Bug;
import Entity.Developer;
import Entity.Project;
import Entity.Tester;
import Service.BugService;

public class BugServiceImpl implements BugService {
	//object creation of BugDaoImpl
	BugDaoImpl bugDao=new BugDaoImpl();

	@Override
	public Bug addBug(Bug bug) {
		// TODO Auto-generated method stub
		return bugDao.addBug(bug) ;
	}

	@Override
	public List<Bug> getAllBugs() {
		// TODO Auto-generated method stub
		return bugDao.getAllBugs();
	}

	@Override
	public Bug getBug(int bugID) {
		// TODO Auto-generated method stub
		return bugDao.getBug(bugID);
	}

	@Override
	public Bug updateBug(int bugID, Bug updatedBug) {
		// TODO Auto-generated method stub
		return bugDao.updateBug(bugID, updatedBug);
	}

	@Override
	public String deleteBug(int bugID) {
		// TODO Auto-generated method stub
		return bugDao.deleteBug(bugID);
	}

	@Override
	public Project getProject(int projectID) {
		// TODO Auto-generated method stub
		return bugDao.getProject(projectID);
	}

	@Override
	public Developer getDeveloper(int devID) {
		// TODO Auto-generated method stub
		return bugDao.getDevepoer(devID);
	}

	@Override
	public Tester getTester(int testID) {
		// TODO Auto-generated method stub
		return bugDao.getTester(testID);
	}


}
