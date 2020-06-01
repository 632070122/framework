package aop.BasedOnTransfer.factory;

import aop.BasedOnTransfer.service.AccountService;
import aop.BasedOnTransfer.utils.TransactionManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private AccountService accountService;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }


    /**
     * 获取Service的代理对象
     * @return
     */
    public AccountService getAccountService(){
        return (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            txManager.beginTransaction();
                            rtValue = method.invoke(accountService,args);
                            txManager.commit();
                            return rtValue;
                        }catch (Exception e){
                            txManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            txManager.release();
                        }
                    }
                }
        );
    }
}
