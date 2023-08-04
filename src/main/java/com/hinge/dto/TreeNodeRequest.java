/**
 * 
 */
package com.hinge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sunil Anjanappa
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeNodeRequest {
	private String parent;
	private String label;

}
