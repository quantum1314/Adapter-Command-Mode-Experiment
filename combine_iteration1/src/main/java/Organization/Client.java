package Organization;

import Department.*;
import VisitorPattern.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        // 获取数据库中的组织和用户数据，并构建树形结构
        OrganizationNode root = dataBase.buildOrganizationTree();

        // 计算研发部下属开发部的考勤和奖金，并输出部门信息
        iterateAndProcessDepartments(root, new DevelopmentDepartmentVisitor());

        // 计算研发部下属系统部（除运维工程师外）和行政办公室的考勤和奖金，并输出部门信息
        iterateAndProcessDepartments(root, new SystemAndAdminOfficeVisitor());

        // 计算运维工程师的考勤和奖金，并输出部门信息
        iterateAndProcessDepartments(root, new OperationsDepartmentVisitor());

        // 计算市场中心的考勤和奖金，并输出部门信息
        iterateAndProcessDepartments(root, new MarketingDepartmentVisitor());
    }

    private static void iterateAndProcessDepartments(OrganizationNode root, DepartmentVisitor visitor) {
        List<Department> departments = new ArrayList<>();
        // 遍历组织树，将各部门节点转换为相应的部门对象并添加到列表中
        iterateOrganizationTree(root, departments);
        // 遍历部门列表，调用每个部门的接受访问者方法，并传递用户列表
        for (Department department : departments) {
            List<UserNode> users = department.getUsers(root);
            department.accept(visitor, users);
        }
    }

    private static void iterateOrganizationTree(OrganizationNode node, List<Department> departments) {
        if (node instanceof OrganizationNode) {
            if ("研发部".equals(node.getName())) {
                for (TreeNode child : node.getChildren()) {
                    if (child instanceof OrganizationNode) {
                        OrganizationNode childNode = (OrganizationNode) child;
                        if ("开发部".equals(childNode.getName())) {
                            departments.add(new DevelopmentDepartment(childNode.getName()));
                        } else if ("系统部".equals(childNode.getName())) {
                            departments.add(new SystemDepartment(childNode.getName()));
                        }
                    }
                }
            } else if ("运维工程师".equals(node.getName())) {
                departments.add(new OperationsDepartment(node.getName()));
            } else if ("市场中心".equals(node.getName())) {
                departments.add(new MarketingDepartment(node.getName()));
            } else if ("行政办公室".equals(node.getName())) {
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