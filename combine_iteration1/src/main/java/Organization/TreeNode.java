package Organization;

import java.util.List;

public interface TreeNode {
    String getName();
    String getId();
    List<TreeNode> getChildren();
    void display(int level);
}