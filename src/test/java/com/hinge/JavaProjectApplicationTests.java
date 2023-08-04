package com.hinge;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hinge.dto.TreeNodeRequest;
import com.hinge.entity.TreeNodeEntity;
import com.hinge.repo.TreeNodeRepository;
import com.hinge.service.TreeService;

@ExtendWith(MockitoExtension.class)
class JavaProjectApplicationTests {

	@Mock
	private TreeNodeRepository treeNodeRepository;

	@InjectMocks
	private TreeService treeService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testAddNode() {
		TreeNodeRequest request = new TreeNodeRequest("1", "newNodeLabel");

		TreeNodeEntity parent = new TreeNodeEntity();
		parent.setId(1L);

		when(treeNodeRepository.findById(1L)).thenReturn(java.util.Optional.of(parent));

		treeService.addNode(request);

		verify(treeNodeRepository, times(1)).save(any(TreeNodeEntity.class));
	}

}
