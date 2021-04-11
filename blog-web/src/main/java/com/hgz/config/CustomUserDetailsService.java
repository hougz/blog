package com.hgz.config;

import com.hgz.entity.TbUser;
import com.hgz.exception.MyException;
import com.hgz.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 要从数据库读取用户信息进行身份认证，需要新建类实现UserDetailService接口重写loadUserByUsername方法
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.findByName(userName,"hgz@2021");
        if (tbUser == null) throw new UsernameNotFoundException("用户不存在");
        //获取用户角色
        String role = tbUser.getNickname();
        // 角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 角色必须以`ROLE_`开头，数据库中没有，则在这里加
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        // 因为数据库是明文，所以这里需加密密码
        return new User(tbUser.getUsername(), passwordEncoder.encode(tbUser.getPassword()), authorities);
    }
}
