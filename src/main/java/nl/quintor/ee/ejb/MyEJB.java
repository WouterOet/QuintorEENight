package nl.quintor.ee.ejb;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import java.util.concurrent.Future;

@Stateless
public class MyEJB {

    @Resource
    ManagedExecutorService mes;

    public void run() {
        mes.submit(() -> {

        });
    }
}
