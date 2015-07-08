package org.whut.webservice.common.authentication.handler;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-7-7
 * Time: 上午2:23
 * To change this template use File | Settings | File Templates.
 */
public class WsAuthCallbackHandler implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
            int usage = pc.getUsage();
            if (usage == WSPasswordCallback.USERNAME_TOKEN) {
                pc.setPassword("testPassword");
            } else if (usage == WSPasswordCallback.SIGNATURE) {
                pc.setPassword("testPassword");
            }
        }
    }
}
