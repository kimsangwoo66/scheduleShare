package com.example.recard.config.auth;

import com.example.recard.domain.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


// 스프링 시큐리티가 로그인 요청을 가로채서 로그인 진행을 완료하면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션 저장소에 저장

//@Getter //다른 레이어 세션에서 user 객체 내용을 꺼내 쓰기 위해
@Data
public class PrincipalDetail implements UserDetails {

    public PrincipalDetail(User user){
        this.user = user;
    }

    //User 객체를 컴포지션
    private User user;



    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    // 계정이 갖고있는 권한 목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList();

        collectors.add(() -> {return "ROLE_" + user.getRole();});
        return collectors;
    }
}
