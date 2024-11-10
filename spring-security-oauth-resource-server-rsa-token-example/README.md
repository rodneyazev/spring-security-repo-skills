<p align="center">
  <img src="https://i.imgur.com/Lxfk9IE.png" width="400" alt="Spring Boot Logo" />
</p>

## Description

Spring Security Oauth Resource Server RSA Token Example

## Swagger

Swagger: http://localhost:8080/swagger

## RSA Key Generation

```bash
openssl.exe genrsa -out keypair.pem 2048
```

```bash
openssl.exe rsa -in keypair.pem -pubout -out public.pem
```

```bash
openssl.exe pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
```

## RSA project path

Copy RSA .pem files to:

- <em>/src/main/resources/certs</em>

## POST endpoint (token's request)

http://localhost:8080/token

- Username: user

- Password: password

<p align="center">
  <img src="https://i.imgur.com/lya2aG6.png" width="400" alt="Token request image" />
</p>

## GET endpoint (using token)

<p align="center">
  <img src="https://i.imgur.com/acA3Or9.png" width="400" alt="Access using token image" />
</p>

## Test

```bash
# unit test

$ mvn test -e
```
## Source file / directory structure

<p align="center">
  <img src="https://i.imgur.com/ABy1hC6.png" width="400" alt="Project Spring Structure Image" />
</p>

## Java Version Troubleshooting (if necessary)

<em>Change to the most current version</em>

<p align="center">
  <img src="https://i.imgur.com/mpgdDa2.png" width="400" alt="Spring Security Database Authentication Image" />
</p>

<em>Uncheck <b>Enable project specific settings</b> option</em>

<p align="center">
  <img src="https://i.imgur.com/M5DAUtM.png" width="400" alt="Spring Security Database Authentication Image" />
</p>
