package qin.tinyshop8.service;

import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain.GoodsCategory;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.util.List;

/**
 * 商品分类管理服务层
 *
 * @author qinzhengying
 * @since 1.8 2017
 */
public interface GoodsCategoryService extends ShopBaseSupport
{
    //region 后台功能(管理界面)

    //region 显示所有分类信息

    /**
     * 显示所有分类信息<br>
     * 页面需要显示的元素<br>
     * 选择&nbsp;
     * 操作(处理+删除)&nbsp;
     * 分类名称&nbsp;
     * 上级分类&nbsp;
     * 别名&nbsp;
     * 排序&nbsp;
     *
     * @return 返回查询集合
     * @throws Exception 抛出大异常
     */
    List<GoodsCategory> showAllCategory() throws Exception;
    //endregion

    //region 编辑商品分类(todo)
    //endregion

    //region 删除商品分类

    /**
     * 删除商品分类
     *
     * @param id 根据主键删除
     * @throws DataAccessException 如果主键为空直接抛出异常
     */
    void deleteCategory(Long id) throws DataAccessException;
    //endregion

    //endregion

    //region 前台功能(页面)

    //region 显示下级分类信息

    /**
     * 显示下级分类信息
     *
     * @param parent 根据上级分类显示下级分类信息
     * @return 返回多个子级别
     * @throws DataAccessException 如果显示失败抛出数据访问层大异常
     */
    List<GoodsCategory> showAllChildren(GoodsCategory parent)
              throws DataAccessException;
    //endregion

    //endregion

}

