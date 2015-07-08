package org.whut.webservice.iccard.business.test.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-7-8
 * Time: 上午1:39
 * To change this template use File | Settings | File Templates.
 */
@WebService
public interface ILoginService {
    @WebMethod
    public String currentUser();
}
