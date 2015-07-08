package org.whut.webservice.iccard.business.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.whut.webservice.iccard.business.test.api.IHelloService;

import javax.jws.WebParam;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-7-7
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class HelloService implements IHelloService {
    private static final Logger logger =
            LoggerFactory.getLogger(HelloService.class);

    @Override
    public String sayHello(@WebParam(name = "str") String str) {
        logger.info("received parameter: {}", str);
        return "Hello" + str;
    }
}
