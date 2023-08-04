/**
 * 
 */
package com.hinge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinge.dto.TreeNodeRequest;
import com.hinge.entity.TreeNodeEntity;
import com.hinge.repo.TreeNodeRepository;

/**
 * @author Sunil Anjanappa
 *
 */
@Service
public class TreeService {

	@Autowired
	private TreeNodeRepository treeNodeRepository;

	public TreeNodeEntity addNode(TreeNodeRequest request) {
		TreeNodeEntity parent = null;
		if (request.getParent() != null) {
			parent = treeNodeRepository.findById(Long.parseLong(request.getParent())).orElse(null);
			if (parent == null) {
				// Handle parent not found
			}
		}
		TreeNodeEntity newNode = new TreeNodeEntity();
		newNode.setLabel(request.getLabel());
		newNode.setParent(parent);

		return treeNodeRepository.save(newNode);
	}

	public TreeNodeEntity buildTree() {
		return treeNodeRepository.findRoot();
	}

}
