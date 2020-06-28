package cn.liboyan.trumpetpress.utils;

import com.github.pagehelper.PageInfo;

/**
 * PageUtils
 *
 * @author Li Boyan
 * @version 1.0
 * @date 2020/6/26
 */
public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageRequest 分页请求
     * @param pageInfo    分页信息
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
