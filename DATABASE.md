# Database Schema Design

For this project, I've chosen to use a relational database (H2) to store the tree structure. The schema consists of a single table that represents the nodes in the tree.

## Tree Nodes Table

- `tree_nodes`
  - `id` (Primary Key, Serial): Unique identifier for each node.
  - `parent_id` (Foreign Key, Integer): Reference to the parent node's ID. NULL for root nodes.
  - `label` (Text): The label of the node.

## Sample SQL Schema

```sql
CREATE TABLE tree_nodes (
    id SERIAL PRIMARY KEY,
    parent_id INTEGER REFERENCES tree_nodes(id),
    label TEXT NOT NULL
);

Sample Queries / Code
Here are sample SQL queries and Java code snippets that demonstrate how to interact with the database to support the API endpoints.

Fetch the Entire Tree
sql
Copy code
SELECT t.id, t.parent_id, t.label
FROM tree_nodes t
WHERE t.parent_id IS NULL;
java
Copy code
@Repository
public interface TreeNodeRepository extends JpaRepository<TreeNodeEntity, Long> {

    @Query("SELECT t FROM TreeNodeEntity t WHERE t.parent IS NULL")
    TreeNodeEntity findRoot();
}
Add a Node
sql
Copy code
INSERT INTO tree_nodes (parent_id, label)
VALUES (?, ?);
java
Copy code
@Service
public class TreeService {

    @Autowired
    private TreeNodeRepository treeNodeRepository;

    public void addNode(TreeNodeRequest request) {
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
}