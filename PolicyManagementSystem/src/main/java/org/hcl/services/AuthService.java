
package org.hcl.services;

import java.util.List;
import org.jboss.logging.Logger;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class AuthService {
	private HibernateTemplate hibernateTemplate;
	private static Logger log = Logger.getLogger(AuthService.class);

	private AuthService() {
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean findUser(String uuserId, String upwd) {
		log.info("Checking the user in the database");
		boolean isValidUser = false;
		String sqlQuery = "from User u where u.userId=? and u.password=?";
		try {
			List userObj = (List) hibernateTemplate.find(sqlQuery, uuserId, upwd);
			if (userObj != null && userObj.size() > 0) {

				isValidUser = true;
			}
		} catch (Exception e) {
			isValidUser = false;
			log.error("An error occurred while fetching the user details from the database", e);
		}
		return isValidUser;
	}
}
