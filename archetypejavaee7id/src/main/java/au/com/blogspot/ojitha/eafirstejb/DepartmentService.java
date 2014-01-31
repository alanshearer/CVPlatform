package au.com.blogspot.ojitha.eafirstejb;
 
import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import au.com.blogspot.ojitha.eafirstejb.domain.Department;
 
/**
 * Session Bean implementation class DepartmentService
 */
@Stateless(name="deptService")
@LocalBean
public class DepartmentService {
 
    @PersistenceContext
    private EntityManager em;
    /**
     * Default constructor. 
     */
    public DepartmentService() {
 
    }
     
    public void save(String name){
        Department dept = new Department();
        dept.setName(name);
        em.persist(dept);
    }
    
    public List<Department> showDept(){
    	CriteriaQuery<Department> criteria = em.getCriteriaBuilder().createQuery( Department.class );

    	Root<Department> root = criteria.from(Department.class);
    	criteria.select(root);
    	List<Department> list = em.createQuery(criteria).getResultList();
    	return list;
    }
 
}