package com.lagou.demo01.dao;

import com.lagou.demo01.bean.PageBean;
import com.lagou.demo01.bean.Classes;

import java.util.List;

public interface ClassesDao {
    // 自定义抽象方法描述添加班级的实现
    public abstract void classesAdd(Classes classes);

    // 自定义抽象方法描述修改班级的实现
    public abstract void classesUpdate(Classes classes);

    // 自定义抽象方法描述删除班级的实现
    public abstract void classesDelete(Integer id);

    // 自定义抽象方法描述查询班级的实现
    public abstract List<Classes> classesSelect(Classes classes);

    // 自定义抽象方法描述查找班级分页
    public abstract List<Classes> getClassesListPage(Classes Classes, PageBean pageBean);

    // 自定义抽象方法描述查找班级数量
    public abstract int findCount(Classes classes);

    // 自定义抽象方法描述根据id查找班级的实现
    public abstract Classes getClassesById(Integer id);
}
