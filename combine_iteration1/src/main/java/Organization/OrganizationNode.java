package Organization;

import Department.Department;
import java.util.ArrayList;
import java.util.List;

public class OrganizationNode implements TreeNode {
    private String id;
    private String name;
    private String higherUpId;
    private String permission;
    private String remark;
    private String orgGUID;
    private List<TreeNode> children;

    public OrganizationNode(String id, String name, String higherUpId, String permission, String remark, String orgGUID) {
        this.id = id;
        this.name = name;
        this.higherUpId = higherUpId;
        this.permission = permission;
        this.remark = remark;
        this.orgGUID = orgGUID;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<TreeNode> getChildren() {
        return children;
    }

    @Override
    public void display(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        sb.append(name).append(" (").append(id).append(")");
        System.out.println(sb.toString());
        for (TreeNode child : children) {
            child.display(level + 1);
        }
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public String getHigherUpId() {
        return higherUpId;
    }

    public String getPermission() {
        return permission;
    }

    public String getRemark() {
        return remark;
    }

    public String getOrgGUID() {
        return orgGUID;
    }

    public void displayUsers(int level) {
        System.out.println("Users in " + name + ":");
        for (TreeNode child : children) {
            if (child instanceof UserNode) {
                child.display(level + 1);
            }
        }
    }

    public List<OrganizationNode> getAllOrganizations() {
        List<OrganizationNode> organizations = new ArrayList<>();
        organizations.add(this);
        for (TreeNode child : children) {
            if (child instanceof OrganizationNode) {
                organizations.addAll(((OrganizationNode) child).getAllOrganizations());
            }
        }
        return organizations;
    }
}