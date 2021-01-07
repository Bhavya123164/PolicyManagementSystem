package org.hcl.dao;

import java.util.List;

import org.hcl.model.Admin;
import org.hcl.model.Policy;
import org.hcl.model.User;
import org.hcl.model.Vendor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PolicyDaoImpl implements PolicyDao {
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void show(User user) {
		sessionfactory.getCurrentSession().save(user);

	}

	@Override
	public void showadmin(Admin admin) {
		sessionfactory.getCurrentSession().save(admin);

	}

	@Override
	public List<User> fetchUser() {
		Query query = sessionfactory.getCurrentSession().createQuery("from User u");
		List<User> userlist = query.list();
		return userlist;
	}

	@Override
	public List<Admin> fetchAdmin() {
		Query query = sessionfactory.getCurrentSession().createQuery("from Admin a");
		List<Admin> adminlist = query.list();
		return adminlist;
	}

	@Override
	public void savepolicy(Policy policyregister) {

		sessionfactory.getCurrentSession().save(policyregister);
	}

	@Override
	public List<Policy> fetchPolicy() {
		Query querypolicy = sessionfactory.getCurrentSession().createQuery("from Policy p");

		List<Policy> policylist = querypolicy.list();
		return policylist;
	}

	@Override
	public Policy fetchPolicyById(Integer polId) {
		Policy policy = sessionfactory.getCurrentSession().get(Policy.class, polId);
		return policy;

	}

	@Override
	public void saveVendor(Vendor vendor) {

		sessionfactory.getCurrentSession().save(vendor);

	}

	@Override
	public List<Vendor> fetchVendor() {

		Query query = sessionfactory.getCurrentSession().createQuery("from Vendor v");
		@SuppressWarnings("unchecked")
		List<Vendor> vendor = query.list();
		return vendor;
	}

	@Override
	public void updatePolicy(Policy policy) {
		sessionfactory.getCurrentSession().update(policy);

	}

	@Override
	public void deletePolicy(Integer polId) {
		Query query = sessionfactory.getCurrentSession().createQuery("delete from Policy p where p.id=:pid");
		query.setParameter("pid", polId);
		query.executeUpdate();
	}

	@Override
	public List<Policy> fetchpolicyId(Integer pid) {

		Query query = sessionfactory.getCurrentSession().createQuery("from Policy p where p.policyid=:polid");
		query.setParameter("polid", pid);
		List<Policy> policy1 = query.list();
		return policy1;

	}

	public Policy getPolicy(String policyName) {
		return (Policy) sessionfactory.getCurrentSession().get(Policy.class, policyName);
	}
}
