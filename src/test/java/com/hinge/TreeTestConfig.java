package com.hinge;

import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hinge.repo.TreeNodeRepository;
import com.hinge.service.TreeService;

/**
 * 
 * @author Sunil Anjanappa
 *
 */
@SpringBootApplication(scanBasePackages = "com.hinge")
public class TreeTestConfig {
	@Bean
	public TreeService treeService() {
		return Mockito.mock(TreeService.class);
	}

	@Bean
	public TreeNodeRepository treeNodeRepository() {
		return Mockito.mock(TreeNodeRepository.class);
	}
}
