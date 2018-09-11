package com.shaw;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @ClassName: ShiroTest
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/8/29 17:18
 **/
public class ShiroTest {

    private static final Logger logger = LoggerFactory.getLogger(ShiroTest.class);

    public static void main(String[] args) {
        DefaultSecurityManager manager = new DefaultSecurityManager();

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);


        IniRealm realm = new IniRealm("classpath:shiro.ini");
        realm.setCredentialsMatcher(hashedCredentialsMatcher);
        

        manager.setRealm(realm);
        UsernamePasswordToken token = new UsernamePasswordToken("shaw", "111");
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            logger.info("===============登录成功===================");
        }catch (Exception e){
            logger.error("==============登录失败===================");
        }
        subject.logout();


    }
}
