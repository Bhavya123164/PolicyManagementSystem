package org.hcl.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hcl.dao.PolicyDao;
import org.hcl.model.Admin;
import org.hcl.model.Policy;
import org.hcl.model.User;
import org.hcl.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	private PolicyDao policydao;

	@Override
	public void show(User user) {
		policydao.show(user);

	}

	@Override
	public void showadmin(Admin admin) {
		policydao.showadmin(admin);

	}

	@Override
	public List<User> fetchUser() {
		List<User> userlist = policydao.fetchUser();
		return userlist;
	}

	@Override
	public List<Admin> fetchAdmin() {
		List<Admin> adminlist = policydao.fetchAdmin();
		return adminlist;
	}

	@Override
	public void savepolicy(Policy policyregister) {
		policydao.savepolicy(policyregister);

	}

	@Override
	public List<Policy> fetchPolicy() {
		List<Policy> policy = policydao.fetchPolicy();
		return policy;
	}

	@Override
	public Policy fetchPolicyById(Integer polId) {

		Policy policyRegisterId = policydao.fetchPolicyById(polId);
		return policyRegisterId;

	}

	@Override
	public void saveVendor(Vendor vendor) {
		policydao.saveVendor(vendor);

	}

	@Override
	public List<Vendor> fetchVendor() {

		List<Vendor> vendor = policydao.fetchVendor();
		return vendor;

	}

	@Override
	public void updatePolicy(Policy policy) {
		policydao.updatePolicy(policy);

	}

	@Override
	public void deletePolicy(Integer polId) {
		policydao.deletePolicy(polId);

	}

	@Override
	public List<Policy> fetchpolicyId(Integer pid) {
		List<Policy> policy1 = policydao.fetchpolicyId(pid);
		return policy1;
	}

	public Policy getPolicy(String policyName) {
		return policydao.getPolicy(policyName);
	}

}
