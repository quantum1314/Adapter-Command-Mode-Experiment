package Organization;

import Department.*;
import VisitorPattern.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        // ��ȡ���ݿ��е���֯���û����ݣ����������νṹ
        OrganizationNode root = dataBase.buildOrganizationTree();

        // �����з��������������Ŀ��ںͽ��𣬲����������Ϣ
        iterateAndProcessDepartments(root, new DevelopmentDepartmentVisitor());

        // �����з�������ϵͳ��������ά����ʦ�⣩�������칫�ҵĿ��ںͽ��𣬲����������Ϣ
        iterateAndProcessDepartments(root, new SystemAndAdminOfficeVisitor());

        // ������ά����ʦ�Ŀ��ںͽ��𣬲����������Ϣ
        iterateAndProcessDepartments(root, new OperationsDepartmentVisitor());

        // �����г����ĵĿ��ںͽ��𣬲����������Ϣ
        iterateAndProcessDepartments(root, new MarketingDepartmentVisitor());
    }

    private static void iterateAndProcessDepartments(OrganizationNode root, DepartmentVisitor visitor) {
        List<Department> departments = new ArrayList<>();
        // ������֯�����������Žڵ�ת��Ϊ��Ӧ�Ĳ��Ŷ�����ӵ��б���
        iterateOrganizationTree(root, departments);
        // ���������б�����ÿ�����ŵĽ��ܷ����߷������������û��б�
        for (Department department : departments) {
            List<UserNode> users = department.getUsers(root);
            department.accept(visitor, users);
        }
    }

    private static void iterateOrganizationTree(OrganizationNode node, List<Department> departments) {
        if (node instanceof OrganizationNode) {
            if ("�з���".equals(node.getName())) {
                for (TreeNode child : node.getChildren()) {
                    if (child instanceof OrganizationNode) {
                        OrganizationNode childNode = (OrganizationNode) child;
                        if ("������".equals(childNode.getName())) {
                            departments.add(new DevelopmentDepartment(childNode.getName()));
                        } else if ("ϵͳ��".equals(childNode.getName())) {
                            departments.add(new SystemDepartment(childNode.getName()));
                        }
                    }
                }
            } else if ("��ά����ʦ".equals(node.getName())) {
                departments.add(new OperationsDepartment(node.getName()));
            } else if ("�г�����".equals(node.getName())) {
                departments.add(new MarketingDepartment(node.getName()));
            } else if ("�����칫��".equals(node.getName())) {
                departments.add(new AdministrativeOffice(node.getName()));
            }
            for (TreeNode child : node.getChildren()) {
                if (child instanceof OrganizationNode) {
                    iterateOrganizationTree((OrganizationNode) child, departments);
                }
            }
        }
    }
}