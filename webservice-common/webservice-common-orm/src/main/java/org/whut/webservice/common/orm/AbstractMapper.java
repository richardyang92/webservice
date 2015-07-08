package org.whut.webservice.common.orm;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-7-7
 * Time: 下午2:37
 * To change this template use File | Settings | File Templates.
 */
public interface AbstractMapper<T> {
    public void add(T t);
    public int update(T t);
    public int delete(T t);
    public T get(T t);
}
