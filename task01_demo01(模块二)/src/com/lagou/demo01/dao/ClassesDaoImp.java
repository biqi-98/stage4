package com.lagou.demo01.dao;

import com.lagou.demo01.bean.Classes;
import com.lagou.demo01.bean.PageBean;
import com.lagou.demo01.bean.Student;
import com.lagou.demo01.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassesDaoImp implements ClassesDao {

    @Override
    public void classesAdd(Classes classes) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "insert into t_classes(name,grand,headmaster,seat,slogan)  values (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, classes.getName());
            preparedStatement.setString(2, classes.getGrand());
            preparedStatement.setString(3, classes.getHeadmaster());
            preparedStatement.setString(4, classes.getSeat());
            preparedStatement.setString(5, classes.getSlogan());
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
    public void classesUpdate(Classes classes) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "update t_classes set name=?,grand=?,headmaster=?,seat=?,slogan=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, classes.getName());
            preparedStatement.setString(2, classes.getGrand());
            preparedStatement.setString(3, classes.getHeadmaster());
            preparedStatement.setString(4, classes.getSeat());
            preparedStatement.setString(5, classes.getSlogan());
            preparedStatement.setInt(6, classes.getId());
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
    public void classesDelete(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "delete from t_classes where id=?";
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
    public List<Classes> classesSelect(Classes classes) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "select * from t_classes where 1=1";
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;

            resultSet = preparedStatement.executeQuery();
            List<Classes> classesList = new ArrayList<>();
            while (resultSet.next()) {
                Classes classes1 = new Classes(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("grand"), resultSet.getString("headmaster")
                        , resultSet.getString("seat"), resultSet.getString("slogan"));
                classesList.add(classes1);
            }
            return classesList;
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
        return null; // 表示查找失败
    }

    @Override
    public List<Classes> getClassesListPage(Classes classes, PageBean pageBean) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "select * from t_classes ";

            sql += "limit ? offset ? ";
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            int i = 1;
            preparedStatement.setInt(i, pageBean.getPageSize());
            i++;
            preparedStatement.setInt(i, (pageBean.getCurrentPage() - 1) * pageBean.getPageSize());

            resultSet = preparedStatement.executeQuery();
            List<Classes> classesList = new ArrayList<>();
            while (resultSet.next()) {
                Classes classes1 = new Classes(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("grand"), resultSet.getString("headmaster")
                        , resultSet.getString("seat"), resultSet.getString("slogan"));
                classesList.add(classes1);
            }
            return classesList;
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
        return null; // 表示查找失败
    }

    @Override
    public int findCount(Classes classes) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "select count(*) as num from t_classes";
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
        return 0; // 表示查找失败
    }

    @Override
    public Classes getClassesById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取数据库连接
            connection = DbUtil.getConnection();
            // 2.准备sql语句
            String sql = "select * from t_classes where id = ?";
            // 3.执行sql语句后获取结果并返回
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Classes classes = new Classes(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("grand"), resultSet.getString("headmaster")
                        , resultSet.getString("seat"), resultSet.getString("slogan"));
                return classes; // 表示查找成功
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
}
