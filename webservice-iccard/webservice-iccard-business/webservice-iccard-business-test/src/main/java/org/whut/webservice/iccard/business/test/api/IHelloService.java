package org.whut.webservice.iccard.business.test.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-7-7
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
@WebService
public interface IHelloService {
    @WebMethod
    public String sayHello(@WebParam(name = "str") String str);
}
