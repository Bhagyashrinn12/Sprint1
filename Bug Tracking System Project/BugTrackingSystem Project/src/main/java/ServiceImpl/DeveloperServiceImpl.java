package ServiceImpl;

import java.util.List;

import DaoImpl.DeveloperDaoImpl;
import DaoImpl.ProjectDaoImpl;
import Entity.Developer;
import Entity.Project;
import Service.DeveloperService;

public class DeveloperServiceImpl implements DeveloperService {
	DeveloperDaoImpl developerDao=new DeveloperDaoImpl();

	@Override
	public Developer addDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		return developerDao.addDeveloper(developer);
			
	}

	@Override
	public List<Developer> getAllDevelopers() {
		// TODO Auto-generated method stub
		return developerDao.getAllDevelopers();
	}
	@Override
	public Developer getDeveloper(int devID) {
		// TODO Auto-generated method stub
		return developerDao.getDeveloper(devID);
	}


	@Override
	public String deleteDeveloper(int devID) {
		// TODO Auto-generated method stub
		return developerDao.deleteDeveloper(devID);
	}

	@Override
	public Developer updateDeveloper(int devID, Developer updatedDeveloper) {
		// TODO Auto-generated method stub
		return developerDao.updateDeveloper(devID, updatedDeveloper);
	}

	@Override
	public Project getProject(int projectID) {
		// TODO Auto-generated method stub
		return developerDao.getProject(projectID);
	}

	
	


}
