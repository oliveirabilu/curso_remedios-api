package com.examplemateuscurso.cursoremedios.security;

public record LoginRequest(
        String login,
        String senha
) {
}
