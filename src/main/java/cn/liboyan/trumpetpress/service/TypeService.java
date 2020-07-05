package cn.liboyan.trumpetpress.service;

import cn.liboyan.trumpetpress.model.entity.Type;
import cn.liboyan.trumpetpress.model.vo.ListType;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Type)表服务接口
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:09
 */
public interface TypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    Type queryById(Long typeId);

    /**
     * 查询数据列表
     *
     * @return 实例对象
     */
    List<ListType> queryListAll();

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    Type insert(Type type);

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    int update(Type type);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Long typeId);

    /**
     * 查询全部分类
     *
     * @return 对象列表
     */
    List<Type> queryAll();

    /**
     * 通过名称查询单条数据
     *
     * @param typeName 名称
     * @return 实例对象
     */
    Type queryByName(String typeName);

    /**
     * 计算分类总条目
     *
     * @return 条目个数
     */
    int countAllTypes();

}