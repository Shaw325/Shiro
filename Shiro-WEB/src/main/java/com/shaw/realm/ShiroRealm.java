package com.shaw.realm;

import com.shaw.pojo.User;
import com.shaw.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: ShiroRealm
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/8/29 17:56
 **/
public class ShiroRealm extends AuthorizingRealm {

    private final static Logger logger = LoggerFactory.getLogger(AuthorizingRealm.class);


    @Autowired
    private UserService userService;

    /**
     * 权限角色、权限的验证
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登录的验证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = token.getPrincipal().toString();
        User user = userService.findUserByName(name);
        try{
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getName(),user.getPassword(),"customRealm");
            info.setCredentialsSalt(ByteSource.Util.bytes(name));//md5加密，salt
            return info;
        }catch (Exception e){
            logger.error("------------shiro验证出错---------------");
        }
        return null;
    }
}
