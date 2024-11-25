package VisitorPattern;

import Department.*;
import Organization.UserNode;

import java.util.List;

// 市场中心访问者
public class MarketingDepartmentVisitor implements DepartmentVisitor {
    @Override
    public void visit(DevelopmentDepartment department, List<UserNode> users) {
        // 市场中心访问者对于开发部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(SystemDepartment department, List<UserNode> users) {
        // 市场中心访问者对于系统部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(OperationsDepartment department, List<UserNode> users) {
        // 市场中心访问者对于运维部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(MarketingDepartment department, List<UserNode> users) {
        System.out.println("部门名称：" + department.getName());
        System.out.println("成员：");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("考勤计算：执行8:30打卡（在公司打卡，必要时可以远程打卡）后，在外跑业务，不再需要下班打卡。");
        System.out.println("奖金计算：按照业务量计算。");
    }

    @Override
    public void visit(AdministrativeOffice department, List<UserNode> users) {
        // 市场中心访问者对于行政办公室不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }
}