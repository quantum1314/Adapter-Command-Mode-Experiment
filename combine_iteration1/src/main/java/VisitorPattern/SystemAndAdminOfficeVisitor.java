package VisitorPattern;

import Department.*;

import Organization.UserNode;

import java.util.List;

// �з�������ϵͳ��������ά����ʦ�⣩�������칫�ҷ�����
public class SystemAndAdminOfficeVisitor implements DepartmentVisitor {
    @Override
    public void visit(DevelopmentDepartment department, List<UserNode> users) {
        // ϵͳ���������칫�ҷ����߶��ڿ�������������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(SystemDepartment department, List<UserNode> users) {
        System.out.println("�������ƣ�" + department.getName());
        System.out.println("��Ա��");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("���ڼ��㣺ִ��8:30 - 12:00, 13:30 - 18:00��˫�ݵ�8Сʱ�����ơ�");
        System.out.println("������㣺���չ̶������㡣");
    }

    @Override
    public void visit(OperationsDepartment department, List<UserNode> users) {
        // ϵͳ���������칫�ҷ����߶�����ά������������ά����ʦ�е����ķ����ߣ���������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(MarketingDepartment department, List<UserNode> users) {
        // ϵͳ���������칫�ҷ����߶����г�����������������Ը���ʵ��������ӿ�ʵ�ֻ�����־��¼��
    }

    @Override
    public void visit(AdministrativeOffice department, List<UserNode> users) {
        System.out.println("�������ƣ�" + department.getName());
        System.out.println("��Ա��");
        for (UserNode user : users) {
            System.out.println(user.getName());
        }
        System.out.println("���ڼ��㣺ִ��8:30 - 12:00, 13:30 - 18:00��˫�ݵ�8Сʱ�����ơ�");
        System.out.println("������㣺���չ̶������㡣");
    }
}