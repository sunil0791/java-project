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