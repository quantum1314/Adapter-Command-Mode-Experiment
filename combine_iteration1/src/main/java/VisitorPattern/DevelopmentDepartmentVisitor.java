package VisitorPattern;

import Department.*;
import Organization.UserNode;

import java.util.List;

// 研发部下属开发部访问者
public class DevelopmentDepartmentVisitor implements DepartmentVisitor {
    @Override
    public void visit(DevelopmentDepartment department, List<UserNode> users) {
        System.out.println("部门名称：" + department.getName());
        System.out.println("成员：");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("考勤计算：执行弹性上班时间，不限上班时间和下班时间，每天上下班打卡，每天工作满8小时即可。");
        System.out.println("奖金计算：按照提交的代码数量、质量计算。");
    }

    @Override
    public void visit(SystemDepartment department, List<UserNode> users) {
        // 开发部访问者对于系统部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(OperationsDepartment department, List<UserNode> users) {
        // 开发部访问者对于运维部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(MarketingDepartment department, List<UserNode> users) {
        // 开发部访问者对于市场部不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }

    @Override
    public void visit(AdministrativeOffice department, List<UserNode> users) {
        // 开发部访问者对于行政办公室不做处理，这里可以根据实际需求添加空实现或者日志记录等
    }
}


