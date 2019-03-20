package service.imp;

import service.StudentService;

public class StudentServiceImp implements StudentService {
    @Override
    public void findAllStudent() {
        System.out.println("查询了学生");
    }

    @Override
    public int deleteStudent() {
        System.out.println("删除了一个学生");
        return 0;
    }

    @Override
    public void updateStudent(int i) {
        System.out.println("更新了一个学生");
    }
}
