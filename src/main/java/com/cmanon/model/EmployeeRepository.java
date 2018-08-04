package com.cmanon.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.id = :id AND e.status = 'ACTIVE'")
	@Override
	Optional<Employee> findById(@Param("id") Long id);

	@Query("SELECT e FROM Employee e WHERE e.status = 'ACTIVE'")
	@Override
	List<Employee> findAll();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	@Query("UPDATE Employee e set e.status='INACTIVE' WHERE e.id=?1")
	@Modifying
	void deleteById(Long id);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteAll(Iterable<? extends Employee> employees);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteAll();
}