package ServiceImpl;

import java.util.List;

import DaoImpl.ProjectDaoImpl;
import Entity.Project;
import Service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	ProjectDaoImpl projectDao=new ProjectDaoImpl();

	@Override
	public Project addProject(Project project) {
		// TODO Auto-generated method stub
		return projectDao.addProject(project);
			
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDao.getAllProjects();
	}

	@Override
	public String deleteProject(int projectID) {
		// TODO Auto-generated method stub
		return projectDao.deleteProject(projectID);
	}

}
