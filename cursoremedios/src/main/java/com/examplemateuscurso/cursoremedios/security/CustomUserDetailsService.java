package com.examplemateuscurso.cursoremedios.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
    @Service
    public class CustomUserDetailsService implements UserDetailsService {
        private final PasswordEncoder passwordEncoder;
        private final UsuarioRepository repository;

        public CustomUserDetailsService(PasswordEncoder passwordEncoder, UsuarioRepository repository) {
            this.passwordEncoder = passwordEncoder;
            this.repository = repository;
        }

        @Override
        public UserDetails loadUserByUsername(String username) {
            Usuario user = repository.findByLogin(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getLogin())
                    .password(user.getSenha())
                    .roles("USER")
                    .build();
        }

    }

