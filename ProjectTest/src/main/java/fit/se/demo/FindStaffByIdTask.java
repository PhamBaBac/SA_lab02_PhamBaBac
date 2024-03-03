package fit.se.demo;

import fit.se.dao.StaffDao;
import fit.se.entity.Staff;

public class FindStaffByIdTask {
	public static void main(String[] args) {
		
		StaffDao staffDao = new StaffDao();
		Staff staff = staffDao.findStaffById(2);
		System.out.println(staff);
		
	}
}
