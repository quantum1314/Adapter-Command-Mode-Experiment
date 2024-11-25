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
        // ������֯�����ҵ��з�������ϵͳ��������ά����ʦ�⣩���û��ڵ㲢��ӵ��б���
        findUsersInDepartment(root, "�з���", "ϵͳ��", users);
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