package cn.liboyan.trumpetpress.model.dao;

import cn.liboyan.trumpetpress.model.entity.Type;

import java.util.List;

/**
 * (Type)表数据库访问层
 *
 * @author Li Boyan
 * @since 2020-05-03 13:40:34
 */
public interface TypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    Type queryById(Long typeId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Type> queryAll();

    List<Type> queryListAll();

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 影响行数
     */
    int insert(Type type);

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 影响行数
     */
    int update(Type type);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Long typeId);

    /**
     * 通过名称查询单条数据
     *
     * @param typeName 类型名称
     * @return 实例对象
     */
    Type queryByName(String typeName);

    int countAllTypes();

}