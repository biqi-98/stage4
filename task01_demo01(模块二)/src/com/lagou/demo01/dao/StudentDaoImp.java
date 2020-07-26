package com.lagou.demo01.dao;

import com.lagou.demo01.bean.PageBean;
import com.lagou.demo01.bean.Student;
import com.lagou.demo01.bean.User;
import com.lagou.demo01.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDaoImp implements StudentDao {

    @Override
    public void studentAdd(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "insert into t_student(name,sex,birthday,email,remark)  values (?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setDate(3, new java.sql.Date(student.getBirthday().getTime()));
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getRemark());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.释放相关的资源
            try {
                DbUtil.closeResource(connection, preparedStatement);
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void studentUpdate(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "update t_student set name=?,sex=?,birthday=?,email=?,remark=? where id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setDate(3, new java.sql.Date(student.getBirthday().getTime()));
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getRemark());
            preparedStatement.setInt(6, student.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.释放相关的资源
            try {
                DbUtil.closeResource(connection, preparedStatement);
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void studentDelete(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "delete from t_student where id=?";
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.释放相关的资源
            try {
                DbUtil.closeResource(connection, preparedStatement);
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Student> studentSelect(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "select * from t_student where 1=1";
            if(0 != student.getId()){
                sql+="and id = ?";
            }
            if(student.getName()!=null){
                sql+="and name = ?";
            }
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            int i=1;
            if(0 != student.getId()){
                preparedStatement.setInt(i, student.getId());
                i++;
            }
            if(student.getName()!=null){
                preparedStatement.setString(i, student.getName());
            }

            resultSet = preparedStatement.executeQuery();
            List<Student> students=new ArrayList<>();
            while (resultSet.next()) {
                Student student1 = new Student(resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getString("sex"),resultSet.getDate("birthday")
                ,resultSet.getString("email"), resultSet.getString("remark"));
                students.add(student1);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.释放相关的资源
            try {
                DbUtil.closeResource(connection, preparedStatement);
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  null; // 表示查找失败
    }

    @Override
    public Student getStudentById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "select * from t_student where id = ?";
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getString("sex"),resultSet.getDate("birthday")
                        ,resultSet.getString("email"), resultSet.getString("remark"));
                return student; // 表示查找成功
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.释放相关的资源
            try {
                DbUtil.closeResource(connection, preparedStatement);
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  null; // 表示查找失败
    }

    @Override
    public List<Student> getStudentListPage(Student student,PageBean pageBean) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "select * from t_student where 1=1 ";
            if(0 != student.getId()){
                sql+="and id = ? ";
            }
            if(student.getName()!=null){
                sql+="and name = ? ";
            }
            sql+="limit ? offset ? ";
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            int i=1;
            if(0 != student.getId()){
                preparedStatement.setInt(i, student.getId());
                i++;
            }
            if(student.getName()!=null){
                preparedStatement.setString(i, student.getName());
                i++;
            }
            preparedStatement.setInt(i, pageBean.getPageSize());
            i++;
            preparedStatement.setInt(i, (pageBean.getCurrentPage()-1)*pageBean.getPageSize());

            resultSet = preparedStatement.executeQuery();
            List<Student> students=new ArrayList<>();
            while (resultSet.next()) {
                Student student1 = new Student(resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getString("sex"),resultSet.getDate("birthday")
                        ,resultSet.getString("email"), resultSet.getString("remark"));
                students.add(student1);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.释放相关的资源
            try {
                DbUtil.closeResource(connection, preparedStatement);
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  null; // 表示查找失败
    }

    @Override
    public int findCount(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "select count(*) as num from t_student where 1=1 ";
            if(0 != student.getId()){
                sql+="and id = ? ";
            }
            if(student.getName()!=null){
                sql+="and name = ? ";
            }
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            int i=1;
            if(0 != student.getId()){
                preparedStatement.setInt(i, student.getId());
                i++;
            }
            if(student.getName()!=null){
                preparedStatement.setString(i, student.getName());
                i++;
            }

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return resultSet.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.释放相关的资源
            try {
                DbUtil.closeResource(connection, preparedStatement);
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  0; // 表示查找失败
    }
}
