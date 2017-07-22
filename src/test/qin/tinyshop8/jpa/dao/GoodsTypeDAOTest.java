package qin.tinyshop8.jpa.dao;

import org.hibernate.Filter;
import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateCallback;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/7/22 0022-22.<br/>
 *
 * @author qinzhengying
 */
public class GoodsTypeDAOTest
{
    @Test public void test() throws Exception {
        //DAOImpl d = new DAOImpl();
        //System.out.println(d.getLog4jLocation());
    }

}

abstract class DAOImpl implements GoodsTypeDAO {

    /**
     * 根据批量主键查询记录, 这个需要子类去实现
     *
     * @param ids 批量主键
     * @return 返回查询结果
     * @author qinzhengying
     * @since 1.8 2017/6/30
     */
    @Override
    public FrameWorkDSCResult findByIds(Serializable[] ids)
    {
        return null;
    }

    @Override
    public <T> T execute(HibernateCallback<T> hibernateCallback) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> T get(Class<T> aClass, Serializable serializable) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> T get(Class<T> aClass, Serializable serializable, LockMode lockMode) throws DataAccessException
    {
        return null;
    }

    @Override
    public Object get(String s, Serializable serializable) throws DataAccessException
    {
        return null;
    }

    @Override
    public Object get(String s, Serializable serializable, LockMode lockMode) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> T load(Class<T> aClass, Serializable serializable) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> T load(Class<T> aClass, Serializable serializable, LockMode lockMode) throws DataAccessException
    {
        return null;
    }

    @Override
    public Object load(String s, Serializable serializable) throws DataAccessException
    {
        return null;
    }

    @Override
    public Object load(String s, Serializable serializable, LockMode lockMode) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> List<T> loadAll(Class<T> aClass) throws DataAccessException
    {
        return null;
    }

    @Override
    public void load(Object o, Serializable serializable) throws DataAccessException
    {

    }

    @Override
    public void refresh(Object o) throws DataAccessException
    {

    }

    @Override
    public void refresh(Object o, LockMode lockMode) throws DataAccessException
    {

    }

    @Override
    public boolean contains(Object o) throws DataAccessException
    {
        return false;
    }

    @Override
    public void evict(Object o) throws DataAccessException
    {

    }

    @Override
    public void initialize(Object o) throws DataAccessException
    {

    }

    @Override
    public Filter enableFilter(String s) throws IllegalStateException
    {
        return null;
    }

    @Override
    public void lock(Object o, LockMode lockMode) throws DataAccessException
    {

    }

    @Override
    public void lock(String s, Object o, LockMode lockMode) throws DataAccessException
    {

    }

    @Override
    public Serializable save(Object o) throws DataAccessException
    {
        return null;
    }

    @Override
    public Serializable save(String s, Object o) throws DataAccessException
    {
        return null;
    }

    @Override
    public void update(Object o) throws DataAccessException
    {

    }

    @Override
    public void update(Object o, LockMode lockMode) throws DataAccessException
    {

    }

    @Override
    public void update(String s, Object o) throws DataAccessException
    {

    }

    @Override
    public void update(String s, Object o, LockMode lockMode) throws DataAccessException
    {

    }

    @Override
    public void saveOrUpdate(Object o) throws DataAccessException
    {

    }

    @Override
    public void saveOrUpdate(String s, Object o) throws DataAccessException
    {

    }

    @Override
    public void replicate(Object o, ReplicationMode replicationMode) throws DataAccessException
    {

    }

    @Override
    public void replicate(String s, Object o, ReplicationMode replicationMode) throws DataAccessException
    {

    }

    @Override
    public void persist(Object o) throws DataAccessException
    {

    }

    @Override
    public void persist(String s, Object o) throws DataAccessException
    {

    }

    @Override
    public <T> T merge(T t) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> T merge(String s, T t) throws DataAccessException
    {
        return null;
    }

    @Override
    public void delete(Object o, LockMode lockMode) throws DataAccessException
    {

    }

    @Override
    public void delete(String s, Object o) throws DataAccessException
    {

    }

    @Override
    public void delete(String s, Object o, LockMode lockMode) throws DataAccessException
    {

    }

    @Override
    public void deleteAll(Collection<?> collection) throws DataAccessException
    {

    }

    @Override
    public void flush() throws DataAccessException
    {

    }

    @Override
    public void clear() throws DataAccessException
    {

    }

    @Override
    public List<?> find(String s, Object... objects) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByNamedParam(String s, String s1, Object o) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByNamedParam(String s, String[] strings, Object[] objects) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByValueBean(String s, Object o) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByNamedQuery(String s, Object... objects) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByNamedQueryAndNamedParam(String s, String s1, Object o) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByNamedQueryAndNamedParam(String s, String[] strings, Object[] objects) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByNamedQueryAndValueBean(String s, Object o) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByCriteria(DetachedCriteria detachedCriteria) throws DataAccessException
    {
        return null;
    }

    @Override
    public List<?> findByCriteria(DetachedCriteria detachedCriteria, int i, int i1) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> List<T> findByExample(T t) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> List<T> findByExample(String s, T t) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> List<T> findByExample(T t, int i, int i1) throws DataAccessException
    {
        return null;
    }

    @Override
    public <T> List<T> findByExample(String s, T t, int i, int i1) throws DataAccessException
    {
        return null;
    }

    @Override
    public Iterator<?> iterate(String s, Object... objects) throws DataAccessException
    {
        return null;
    }

    @Override
    public void closeIterator(Iterator<?> iterator) throws DataAccessException
    {

    }

    @Override
    public int bulkUpdate(String s, Object... objects) throws DataAccessException
    {
        return 0;
    }

    /**
     * 获取实体类 类 类型
     *
     * @return 返回获取到的实体类型
     */
    @Override
    public Class<GoodsType8JPA> getEntityClass()
    {
        return null;
    }

    /**
     * 获取我的Session工厂
     *
     * @return 注入到spring配置文件<code>applicationContext.xml</code>中的sessionFactory
     */
    @Override
    public SessionFactory getSessionFactory()
    {
        return null;
    }

    /**
     * 获取我的session<br>
     * 判断是否为空然后得判断是否打开了session, 如果没有打开就打开
     *
     * @return 返回获取到的session
     */
    @Override
    public Session getSession()
    {
        return null;
    }

    /**
     * 获取我的事务
     * <br>
     * 判断是否激活, 如果没有激活就激活
     *
     * @return 返回事务
     */
    @Override
    public Transaction getTransaction()
    {
        return null;
    }
}