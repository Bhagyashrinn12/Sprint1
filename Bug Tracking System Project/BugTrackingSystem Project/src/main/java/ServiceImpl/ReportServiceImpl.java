package ServiceImpl;


import java.util.List;

import DaoImpl.ReportDaoImpl;
import Entity.Bug;
import Entity.Report;
import Service.ReportService;

public class ReportServiceImpl implements ReportService {
	ReportDaoImpl reportDao=new ReportDaoImpl();
	@Override
	public List<Bug> getBug(String status) {
		// TODO Auto-generated method stub
		return reportDao.getBug(status);
	}
}
