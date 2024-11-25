package VisitorPattern;

import Department.*;
import Organization.UserNode;
import VisitorPattern.DepartmentVisitor;

import java.util.List;

// 运维工程师访问者
public class OperationsDepartmentVisitor implements DepartmentVisitor {
    @Override
    public void visit(DevelopmentDepartment department, List<UserNode> users) {
        // 运维工程师访问者对于开发部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(SystemDepartment department, List<UserNode> users) {
        // 运维工程师访问者对于系统部不做处理（除运维工程师外），这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(OperationsDepartment department, List<UserNode> users) {
        System.out.println("部门名称：" + department.getName());
        System.out.println("成员：");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("考勤计算：执行24小时值班制度，上一天，休息两天。");
        System.out.println("奖金计算：按照系统稳定运行评价计算。");
    }

    @Override
    public void visit(MarketingDepartment department, List<UserNode> users) {
        // 运维工程师访问者对于市场部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(AdministrativeOffice department, List<UserNode> users) {
        // 运维工程师访问者对于行政办公室不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }
}
