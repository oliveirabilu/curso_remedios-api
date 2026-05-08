package com.examplemateuscurso.cursoremedios.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
   private final UsuarioService usuarioService;

    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<UsuarioDtoSaida> criar(@RequestBody Usuario user){
        Usuario userSalvo= usuarioService.salvar(user);
        return ResponseEntity.ok(new UsuarioDtoSaida(userSalvo.getId(), userSalvo.getLogin()));
    }
}
