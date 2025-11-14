package com.example.tokaibase.security;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tokaibase.entity.User;
import com.example.tokaibase.repository.UserRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
        	System.out.println(username);
            // 送信されたユーザー名と一致するユーザー情報をテーブルから取得
            User user = userRepository.findByEmail(username);

            // ロールIDに応じたロール名を取得(今回はテーブルを直接参照しない)
            /*String userRoleName = switch(user.getRoleId()) {
                case 1  -> "ROLE_GENERAL";
                case 2  -> "ROLE_ADMIN";
                default -> "ROLE_GENERAL";
            };*/

            // ロールのリスト用オブジェクトを生成
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_FREE_MEMBER"));
            // ユーザーのロール名をリストに追加
            //authorities.add(new SimpleGrantedAuthority(userRoleName));

            // ユーザー情報とロールリストをもとにUserDetailsImplを生成
            return new UserDetailsImpl(user, authorities);
        } catch (Exception e) {
            throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
        }
    }
}