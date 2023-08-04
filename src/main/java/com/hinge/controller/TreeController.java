/**
 * 
 */
package com.hinge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hinge.dto.TreeNodeRequest;
import com.hinge.entity.TreeNodeEntity;
import com.hinge.service.TreeService;

/**
 * @author Sunil Anjanappa
 *
 */
@RestController
@RequestMapping("/api/tree")
public class TreeController {

	@Autowired
	private TreeService treeService;

	@GetMapping
	public ResponseEntity<TreeNodeEntity> getTree() {
		TreeNodeEntity root = treeService.buildTree();
		return ResponseEntity.ok(root);
	}

	@PostMapping("/add")
	public ResponseEntity<TreeNodeEntity> addNode(@RequestBody TreeNodeRequest request) {
		TreeNodeEntity treeNodeEntity = treeService.addNode(request);
		return ResponseEntity.ok(treeNodeEntity);
	}
}