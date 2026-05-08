# 💊 Curso Remédios API

API REST para gerenciamento de usuários com autenticação segura utilizando **Spring Security** e **JWT (JSON Web Token)**.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (jjwt)
- Spring Data JPA
- H2 / MySQL
- Maven

---

## 🔐 Autenticação

A API utiliza autenticação **stateless com JWT**.

### 🔑 Fluxo de autenticação

1. Usuário se registra
2. Faz login com login e senha
3. Recebe um token JWT
4. Envia o token no header das requisições protegidas

---

## 📌 Endpoints principais

### 🧑 Criar usuário
