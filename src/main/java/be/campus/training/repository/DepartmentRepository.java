package be.campus.training.repository;

import be.campus.training.domain.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "department", path = "department")
public interface DepartmentRepository extends CrudRepository<Department,Long> {

//	public List<Department> findByFeedAndCustomerId(@Param("feed") String feed, @Param("customerId") String customerId);
//
//	public List<Department> findByCustomerId(@Param("customerId") String customerId);
	
}
