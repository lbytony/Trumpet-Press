package cn.liboyan.trumpetpress.service.impl;

import cn.liboyan.trumpetpress.model.entity.Type;
import cn.liboyan.trumpetpress.model.dao.TypeDao;
import cn.liboyan.trumpetpress.service.TypeService;
import cn.liboyan.trumpetpress.utils.PageRequest;
import cn.liboyan.trumpetpress.utils.PageResult;
import cn.liboyan.trumpetpress.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Type)表服务实现类
 *
 * @author Li Boyan
 * @since 2020-05-03 13:44:10
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeDao typeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public Type queryById(Long typeId) {
        return this.typeDao.queryById(typeId);
    }

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type insert(Type type) {
        this.typeDao.insert(type);
        return type;
    }

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Type type) {
        System.out.println(type.toString());
        return this.typeDao.update(type);
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long typeId) {
        return this.typeDao.deleteById(typeId) > 0;
    }

    @Override
    public List<Type> queryAll() {
        return this.typeDao.queryAll();
    }

    @Override
    public Type queryByName(String typeName) {
        return this.typeDao.queryByName(typeName);
    }

    @Override
    public int countAllType() {
        return this.typeDao.countAllType();
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest 分页请求
     * @return pageInfo
     */
    @Override
    public PageInfo<Type> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Type> query = typeDao.queryPage();
        return new PageInfo<>(query);
    }
}