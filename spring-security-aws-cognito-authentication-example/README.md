<p align="center">
  <img src="https://i.imgur.com/Lxfk9IE.png" width="400" alt="Spring Boot Logo" />
</p>

## Description

Spring Security AWS Cognito Authentcation Example

## Application properties

<p align="center">
  <img src="https://i.imgur.com/Yj8VuQD.png" width="400" alt="Application properties Image" />
</p>

```bash
server.port=8080

server.servlet.session.cookie.same-site=lax

spring.security.oauth2.client.registration.cognito.client-id={your-app-client-id}

spring.security.oauth2.client.registration.cognito.client-secret={your-app-client-secret}

spring.security.oauth2.client.registration.cognito.scope=openid

spring.security.oauth2.client.registration.cognito.redirect-uri=http://localhost:8080/login/oauth2/code/cognito

spring.security.oauth2.client.registration.cognito.clientName={your-app-client-name}

spring.security.oauth2.client.registration.cognito.authorization-grant-type=authorization_code

spring.security.oauth2.client.provider.cognito.issuerUri=https://cognito-idp.{your-user-pool-region}.amazonaws.com/{user-pool-id}
```

## Create user pool

<p align="center">
  <img src="https://i.imgur.com/irQkVtf.png" width="400" alt="Crete user pool Image" />
</p>

## Configure sign-in experience

<p align="center">
  <img src="https://i.imgur.com/WeRq6ro.png" width="400" alt="Configure sign-in experience Image" />
</p>

<p align="center">
  <img src="https://i.imgur.com/rok7GWi.png" width="400" alt="Configure sign-in experience Image" />
</p>

<p align="center">
  <img src="https://i.imgur.com/NDeAv51.png" width="400" alt="Configure sign-in experience Image" />
</p>

<p align="center">
  <img src="https://i.imgur.com/Ox04RBP.png" width="400" alt="Configure sign-in experience Image" />
</p>

### User pool name

<p align="center">
  <img src="https://i.imgur.com/wfvb2hR.png" width="400" alt="User pool name Image" />
</p>

### Cognito domain prefix

<p align="center">
  <img src="https://i.imgur.com/6oBVWT5.png" width="400" alt="Cognito domain prefix Image" />
</p>

<p><center>URL: http://localhost:8080/login/oauth2/code/cognito</center></p>

<p align="center">
  <img src="https://i.imgur.com/UP17y4Z.png" width="400" alt="Cognito domain prefix Image" />
</p>

<p align="center">
  <img src="https://i.imgur.com/5JLhBuy.png" width="400" alt="Cognito domain prefix Image" />
</p>

## Create USER and ADMIN group

<p align="center">
  <img src="https://i.imgur.com/mYHC5O3.png" width="400" alt="Create USER and ADMIN group Image" />
</p>

## User Pool Test

Click on <b>View Hosted UI</b> button

<p align="center">
  <img src="https://i.imgur.com/KQLdjDb.png" width="400" alt="User Pool Test Image" />
</p>

<p align="center">
  <img src="https://i.imgur.com/a2kxmIb.png" width="400" alt="User Pool Test Image" />
</p>


<p align="center">
  <img src="https://i.imgur.com/eBjbSOP.png" width="400" alt="User Pool Test Image" />
</p>

## User sign up

<p align="center">
  <img src="https://i.imgur.com/a5N8rc9.png" width="400" alt="User sign up Image" />
</p>

<p align="center">
  <img src="https://i.imgur.com/os4V3bb.png" width="400" alt="User sign up Image" />
</p>

<p align="center">
  <img src="https://i.imgur.com/AmQ8mFg.png" width="400" alt="User sign up Image" />
</p>

## Assign user to a group

<p align="center">
  <img src="https://i.imgur.com/XjRZRiB.png" width="400" alt="Assign user to a group Image" />
</p>

<p align="center">
  <img src="https://i.imgur.com/JbTFvTP.png" width="400" alt="Assign user to a group Image" />
</p>

<em>If necessary, clean you web browser cache.</em>

<em>P.S.: You can assign the user to a group appropriately using AWS Lambda.</em>


## Source file / directory structure

<p align="center">
  <img src="https://i.imgur.com/IZsYxSM.png" width="400" alt="Spring Security AWS Cognito Authentcation Image" />
</p>
