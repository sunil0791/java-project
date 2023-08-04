/**
 * 
 */
package com.hinge.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sunil Anjanappa
 *
 */
@Entity
@Getter
@Setter
public class TreeNodeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String label;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private TreeNodeEntity parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<TreeNodeEntity> children;

}
