package org.hcl.services;

import java.util.List;

import org.hcl.model.Admin;
import org.hcl.model.Policy;
import org.hcl.model.User;
import org.hcl.model.Vendor;

public interface PolicyService {
	void show(User user);

	List<User> fetchUser();

	void savepolicy(Policy policyregister);

	List<Policy> fetchPolicy();

	Policy fetchPolicyById(Integer polId);

	void saveVendor(Vendor vendor);

	List<Vendor> fetchVendor();

	void updatePolicy(Policy policy);

	void deletePolicy(Integer polId);

	List<Policy> fetchpolicyId(Integer pid);

	void showadmin(Admin admin);

	List<Admin> fetchAdmin();

	Policy getPolicy(String policyName);

}
