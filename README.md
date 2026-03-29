<div align="center">

# 🛡️ Spring Security Learning Hub

[![GitHub stars](https://img.shields.io/github/stars/Shubh2-0/Spring_Security?style=for-the-badge&logo=github&color=yellow)](https://github.com/Shubh2-0/Spring_Security/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/Shubh2-0/Spring_Security?style=for-the-badge&logo=github&color=blue)](https://github.com/Shubh2-0/Spring_Security/network/members)
[![GitHub issues](https://img.shields.io/github/issues/Shubh2-0/Spring_Security?style=for-the-badge&logo=github&color=red)](https://github.com/Shubh2-0/Spring_Security/issues)

<img src="https://www.javainuse.com/boot-36-3-min.JPG" alt="Spring Security" width="500"/>

### Master Application Security with Spring Security

*Complete collection of authentication and authorization implementations - from basic to JWT*

[Explore Projects](#-projects) · [Get Started](#-getting-started) · [Learn Security](#-security-concepts)

</div>

---

## 📖 Table of Contents

- [About](#-about)
- [Projects](#-projects)
- [Security Concepts](#-security-concepts)
- [Technologies](#-technologies)
- [Getting Started](#-getting-started)
- [Contributing](#-contributing)
- [Contact](#-contact)

---

## 🎯 About

This repository is your **one-stop destination** for mastering **Spring Security**. It contains multiple projects demonstrating various authentication and authorization techniques, from basic form login to JWT-based stateless authentication with role-based access control.

### What You'll Master

- 🔐 **Authentication** - Form login, HTTP Basic, JWT tokens
- 🎫 **Authorization** - Role-based access control (RBAC)
- 🔑 **JWT Integration** - Stateless authentication
- 🌐 **CORS Handling** - Cross-Origin Resource Sharing
- ⚙️ **Custom Providers** - Build your own authentication logic

---

## 📁 Projects

| Project | Description | Key Concepts |
|---------|-------------|--------------|
| **Spring_Security_1** | Foundation project | Basic security configuration |
| **SpringSecurityAuthProviderWithoutJwt** | Authentication without JWT | Custom auth providers |
| **SpringSecurityJwtWithRole** | JWT + Role Authorization | Token-based RBAC |
| **Spring_Security_With_CustomAuthProvider** | Custom authentication | Provider customization |
| **SpringSecurityWithJwt** | JWT implementation | Token generation & validation |
| **SpringSecurityWithJwt2** | Alternative JWT approach | Different JWT strategies |
| **Spring_Security_With_JWT2_And_Role** | JWT + Extended roles | Fine-grained access |
| **SpringSecurityWithJwtCors** | JWT + CORS handling | Cross-domain security |
| **SpringSecurityWithSimpleRoleJwt2** | Simplified role-JWT | Streamlined implementation |
| **SpringSecurityWithoutJwt** | Traditional security | Session-based auth |
| **SpringSecurityWithoutJwt2** | Alternative non-JWT | Different session approaches |

---

## 🔒 Security Concepts

### Authentication Flow

```
┌─────────────────┐    Credentials    ┌──────────────────┐
│     Client      │ ───────────────► │  AuthController  │
└─────────────────┘                   └────────┬─────────┘
                                               │
                                               ▼
                                    ┌──────────────────────┐
                                    │  AuthenticationMgr   │
                                    └────────┬─────────────┘
                                             │
                          ┌──────────────────┼──────────────────┐
                          ▼                  ▼                  ▼
                   ┌──────────────┐  ┌──────────────┐  ┌──────────────┐
                   │UserDetailsSvc│  │PasswordEncoder│  │  JwtService  │
                   └──────────────┘  └──────────────┘  └──────────────┘
```

### JWT Token Structure

```
┌─────────────────────────────────────────────────────────┐
│                      JWT TOKEN                          │
├─────────────────┬─────────────────┬────────────────────┤
│     HEADER      │     PAYLOAD     │     SIGNATURE      │
│  {"alg":"HS256" │  {"sub":"user"  │   HMACSHA256(      │
│   "typ":"JWT"}  │   "role":"ADMIN"│   base64(header)+  │
│                 │   "exp":1234567}│   base64(payload)) │
└─────────────────┴─────────────────┴────────────────────┘
```

---

## 🛠️ Technologies

<div align="center">

| Technology | Version | Purpose |
|:----------:|:-------:|:-------:|
| <img src="https://skillicons.dev/icons?i=java" width="40"/> | 17+ | Programming Language |
| <img src="https://skillicons.dev/icons?i=spring" width="40"/> | 3.x | Spring Boot Framework |
| <img src="https://skillicons.dev/icons?i=mysql" width="40"/> | 8.0+ | Database |
| <img src="https://skillicons.dev/icons?i=maven" width="40"/> | 3.6+ | Build Tool |
| <img src="https://skillicons.dev/icons?i=postman" width="40"/> | Latest | API Testing |

</div>

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 17+
- Maven 3.6+
- MySQL Server
- Postman (for API testing)

### Quick Start

```bash
# Clone the repository
git clone https://github.com/Shubh2-0/Spring_Security.git
cd Spring_Security

# Choose a project
cd SpringSecurityJwtWithRole

# Configure database in application.properties
# Update username, password, and database name

# Run the application
mvn spring-boot:run
```

### API Testing

```bash
# Register endpoint
POST /api/auth/register
{
  "username": "user",
  "password": "password",
  "role": "USER"
}

# Login endpoint
POST /api/auth/login
{
  "username": "user",
  "password": "password"
}

# Protected endpoint (with JWT token)
GET /api/protected
Authorization: Bearer <your-jwt-token>
```

---

## 📚 Learning Path

```
🔰 Beginner
├── Spring_Security_1 (Basic Config)
├── SpringSecurityWithoutJwt (Session-based)
│
🔵 Intermediate
├── SpringSecurityAuthProviderWithoutJwt
├── Custom Authentication Provider
│
🔴 Advanced
├── SpringSecurityWithJwt (Token-based)
├── SpringSecurityJwtWithRole (RBAC)
├── SpringSecurityWithJwtCors (CORS)
│
🏆 Expert
└── Build your own Security Architecture!
```

---

## 🤝 Contributing

Security is everyone's responsibility! Contributions welcome:

- 🔐 Add new authentication patterns
- 📖 Improve documentation
- 🐛 Fix security vulnerabilities
- 💡 Suggest best practices

---

## 📬 Contact

<div align="center">

**Shubham Bhati** - Java Developer

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shubham-bhati-787319213/)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:shubhambhati226@gmail.com)
[![WhatsApp](https://img.shields.io/badge/WhatsApp-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.me/+916232133187)

</div>

---

<div align="center">

### ⭐ Star this repository if it helped you secure your applications!

**Keywords:** Spring-Security JWT Authentication Authorization RBAC OAuth2 Java Spring-Boot Security API-Security Token-Based-Auth

<img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=60&section=footer"/>

</div>


















