package com.example.recard.config.auth;

import com.example.recard.domain.User;
import com.example.recard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // 스프링이 로그인 요청을 가로챌때 email과 password를 가로채도록
    // 패스워드 부분을 알아서 가로챔

    // email이 DB에 존재하는지만 확인
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User principal = userRepository.findByEmail(email)

                .orElseThrow(() -> {
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다." + email);
                });
        System.out.println(principal.toString());
        System.out.println("꺼낸 이메일: " + principal.getEmail());
        System.out.println("꺼낸 비밀번호: " + principal.getPassword());
        PrincipalDetail prin = new PrincipalDetail(principal);
        System.out.println("꺼낸 이메일2: " + prin.getUsername());
        System.out.println("꺼낸 이메일2: " + prin.getPassword());

        return new PrincipalDetail(principal); //시큐리티 세션에 user정보가 저장됨
    }




}
