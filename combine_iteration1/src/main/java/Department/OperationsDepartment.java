package Department;

import VisitorPattern.*;
import Organization.*;


import java.util.ArrayList;
import java.util.List;

public class OperationsDepartment extends Department {
    public OperationsDepartment(String name) {
        super(name);
    }

    @Override
    public void accept(DepartmentVisitor visitor, List<UserNode> users) {
        visitor.visit(this,users);
    }

    @Override
    public List<UserNode> getUsers(OrganizationNode root) {
        List<UserNode> users = new ArrayList<>();
        // 遍历组织树，找到运维工程师的用户节点并添加到列表中
        findUsersInDepartment(root, "运维工程师", "", users);
        return users;
    }

    private void findUsersInDepartment(OrganizationNode node, String department, String subDepartment, List<UserNode> users) {
        if (node instanceof OrganizationNode && node.getName().equals(department)) {
            if ("".equals(subDepartment) || node.getName().equals(subDepartment)) {
                for (TreeNode userNode : node.getChildren()) {
                    if (userNode instanceof UserNode) {
                        users.add((UserNode) userNode);
                    }
                }
            }
        }
        for (TreeNode child : node.getChildren()) {
            if (child instanceof OrganizationNode) {
                findUsersInDepartment((OrganizationNode) child, department, subDepartment, users);
            }
        }
    }
}