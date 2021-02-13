package spring.orm.crud;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class CustomerDaoSupport extends HibernateDaoSupport{

	@Transactional(readOnly = false)
	public void saveCustomer(Customer customer) {
		getHibernateTemplate().save(customer);
	}
	
	
	@Transactional(readOnly = true)
	public List<Customer> allCustomer() {
		List<Customer> list=(List<Customer>) getHibernateTemplate().find("from Customer");
		return list;
	}
	
}
