package VisitorPattern;

import Department.*;

import Organization.UserNode;

import java.util.List;

// 研发部下属系统部（除运维工程师外）和行政办公室访问者
public class SystemAndAdminOfficeVisitor implements DepartmentVisitor {
    @Override
    public void visit(DevelopmentDepartment department, List<UserNode> users) {
        // 系统部和行政办公室访问者对于开发部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(SystemDepartment department, List<UserNode> users) {
        System.out.println("部门名称：" + department.getName());
        System.out.println("成员：");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("考勤计算：执行8:30 - 12:00, 13:30 - 18:00，双休的8小时工作制。");
        System.out.println("奖金计算：按照固定金额计算。");
    }

    @Override
    public void visit(OperationsDepartment department, List<UserNode> users) {
        // 系统部和行政办公室访问者对于运维部不做处理（运维工程师有单独的访问者），这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(MarketingDepartment department, List<UserNode> users) {
        // 系统部和行政办公室访问者对于市场部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(AdministrativeOffice department, List<UserNode> users) {
        System.out.println("部门名称：" + department.getName());
        System.out.println("成员：");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("考勤计算：执行8:30 - 12:00, 13:30 - 18:00，双休的8小时工作制。");
        System.out.println("奖金计算：按照固定金额计算。");
    }
}