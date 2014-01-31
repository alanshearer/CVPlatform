package au.com.blogspot.ojitha.eafirstweb.managedbeans;
 
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import javax.faces.model.ListDataModel;
import javax.servlet.annotation.WebListener;

import au.com.blogspot.ojitha.eafirstejb.DepartmentService;
import au.com.blogspot.ojitha.eafirstejb.domain.Department;
 
@ManagedBean(name="dept")
@SessionScoped
public class DepartmentManagedBean {
    @EJB(beanName="deptService")
    DepartmentService deptService;
     
	private List<Department> list = new ArrayList<Department>() ; 

    public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
		this.list = list;
	}

	private String name;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
     
    public String addDept(){
        this.deptService.save(this.name);
        return "/response.xhtml";
    }
    
    public String getShowDept(){
    	list = this.deptService.showDept();
    	return null;
    }

	public void setShowDept(ArrayList<Department> showDept) {
		this.list = showDept;
	}
    
 }
 