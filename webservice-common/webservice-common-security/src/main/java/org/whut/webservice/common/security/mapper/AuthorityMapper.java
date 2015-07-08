package org.whut.webservice.common.security.mapper;

import org.whut.webservice.common.orm.AbstractMapper;
import org.whut.webservice.common.security.entity.Authority;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiaozhujun
 * Date: 14-3-16
 * Time: 下午8:14
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorityMapper extends AbstractMapper<Authority> {
    public List<Authority> findByCondition(Map<String, Object> map);
    public long getIdByName(String name);
    public String getNameById(long id);
}
