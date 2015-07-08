package org.whut.webservice.common.security.mapper;

import org.whut.webservice.common.orm.AbstractMapper;
import org.whut.webservice.common.security.entity.AuthorityPower;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaozhujun
 * Date: 14-3-16
 * Time: 下午11:01
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorityPowerMapper extends AbstractMapper<AuthorityPower> {
    public List<AuthorityPower> getAuthorityPowerList();
    public int deleteByAuthorityName(String name);
    public List<String> getResourcesByAuthorityName(String name);
    public int deleteByPowerResource(String powerResource);
}
