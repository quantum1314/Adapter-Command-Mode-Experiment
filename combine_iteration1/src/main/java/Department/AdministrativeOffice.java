package Department;

import VisitorPattern.*;
import Organization.*;


import java.util.ArrayList;
import java.util.List;

public class AdministrativeOffice extends Department {
    public AdministrativeOffice(String name) {
        super(name);
    }

    @Override
    public void accept(DepartmentVisitor visitor, List<UserNode> users) {
        visitor.visit(this,users);
    }

    @Override
    public List<UserNode> getUsers(OrganizationNode root) {
        List<UserNode> users = new ArrayList<>();
        // ������֯�����ҵ������칫�ҵ��û��ڵ㲢���ӵ��б���
        findUsersInDepartment(root, "�����칫��", "", users);
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