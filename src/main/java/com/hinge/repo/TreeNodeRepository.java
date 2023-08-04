/**
 * 
 */
package com.hinge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hinge.entity.TreeNodeEntity;

/**
 * @author Sunil Anjanappa
 *
 */
@Repository
public interface TreeNodeRepository extends JpaRepository<TreeNodeEntity, Long> {
	@Query("SELECT t FROM TreeNodeEntity t WHERE t.parent IS NULL")
	TreeNodeEntity findRoot();
}
