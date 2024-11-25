package VisitorPattern;

import Department.*;
import Organization.UserNode;
import VisitorPattern.DepartmentVisitor;

import java.util.List;

// ��ά����ʦ������
public class OperationsDepartmentVisitor implements DepartmentVisitor {
    @Override
    public void visit(DevelopmentDepartment department, List<UserNode> users) {
        // ��ά����ʦ�����߶��ڿ�������������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(SystemDepartment department, List<UserNode> users) {
        // ��ά����ʦ�����߶���ϵͳ��������������ά����ʦ�⣩��������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(OperationsDepartment department, List<UserNode> users) {
        System.out.println("�������ƣ�" + department.getName());
        System.out.println("��Ա��");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("���ڼ��㣺ִ��24Сʱֵ���ƶȣ���һ�죬��Ϣ���졣");
        System.out.println("������㣺����ϵͳ�ȶ��������ۼ��㡣");
    }

    @Override
    public void visit(MarketingDepartment department, List<UserNode> users) {
        // ��ά����ʦ�����߶����г�����������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(AdministrativeOffice department, List<UserNode> users) {
        // ��ά����ʦ�����߶��������칫�Ҳ�������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }
}
