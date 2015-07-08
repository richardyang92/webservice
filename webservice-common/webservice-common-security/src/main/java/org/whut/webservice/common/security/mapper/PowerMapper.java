package org.whut.webservice.common.security.mapper;

import org.whut.webservice.common.orm.AbstractMapper;
import org.whut.webservice.common.security.entity.Power;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiaozhujun
 * Date: 14-3-23
 * Time: 下午6:23
 * To change this template use File | Settings | File Templates.
 */
public interface PowerMapper extends AbstractMapper<Power> {
    public List<Power> findByCondition(Map<String, Object> map);
    public long getIdByResource(String name);
    public List<Power> findByResource(String resource);
}
