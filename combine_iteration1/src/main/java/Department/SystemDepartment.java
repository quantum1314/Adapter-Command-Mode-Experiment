package Department;

import VisitorPattern.*;
import Organization.*;


import java.util.ArrayList;
import java.util.List;

public class SystemDepartment extends Department {
    public SystemDepartment(String name) {
        super(name);
    }

    @Override
    public void accept(DepartmentVisitor visitor, List<UserNode> users) {
        visitor.visit(this,users);
    }

    @Override
    public List<UserNode> getUsers(OrganizationNode root) {
        List<UserNode> users = new ArrayList<>();
        // 遍历组织树，找到研发部下属系统部（除运维工程师外）的用户节点并添加到列表中
        findUsersInDepartment(root, "研发部", "系统部", users);
        return users;
    }

    private void findUsersInDepartment(OrganizationNode node, String parentDepartment, String department, List<UserNode> users) {
        if (node instanceof OrganizationNode && node.getName().equals(parentDepartment)) {
            for (TreeNode child : node.getChildren()) {
                if (child instanceof OrganizationNode && ((OrganizationNode) child).getName().equals(department)) {
                    for (TreeNode userNode : ((OrganizationNode) child).getChildren()) {
                        if (userNode instanceof UserNode) {
                            users.add((UserNode) userNode);
                        }
                    }
                }
            }
        }
        for (TreeNode child : node.getChildren()) {
            if (child instanceof OrganizationNode) {
                findUsersInDepartment((OrganizationNode) child, parentDepartment, department, users);
            }
        }
    }
}