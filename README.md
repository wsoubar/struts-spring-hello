# Struts 2 + Spring 3 (Open CTBE3)

Projeto base para execução de aplicações **CTBE** sem dependência da plataforma CTBE3 original.

Compatível com **Apache Tomcat 9** e utiliza:
- Struts 2
- Spring 3

---

## 📋 Pré-requisitos

Antes de iniciar, garanta que você possui:

- Java 8+ instalado
- Maven configurado (`mvn -v`)
- Apache Tomcat 9 instalado e em execução

---

## ⚙️ Configuração do Tomcat 9

Para permitir deploy via Maven, configure o usuário do **Tomcat Manager**.

### 1. Editar arquivo:

```bash
TOMCAT_HOME/conf/tomcat-users.xml
```

### 2. Adicionar usuário:

```xml
<user username="admin" password="admin" roles="manager-script"/>
```

> ⚠️ **Importante:**  
> A role `manager-script` é obrigatória para permitir deploy via Maven plugin.

---

## ▶️ Execução do Projeto

Após subir o Tomcat, execute os comandos abaixo na raiz do projeto:

### 📦 Primeiro deploy

```bash
mvn tomcat7:deploy
```

### 🔄 Atualizar aplicação

```bash
mvn tomcat7:redeploy
```

### ❌ Remover aplicação

```bash
mvn tomcat7:undeploy
```

---

## 🔌 Configuração do Plugin Maven

Certifique-se de que o plugin está configurado corretamente no `pom.xml`:

```xml
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <url>http://localhost:8080/manager/text</url>
        <server>TomcatServer</server>
        <path>/struts-spring-hello</path>
        <username>admin</username>
        <password>admin</password>
    </configuration>
</plugin>
```

---

## 🔐 Configuração do Maven (settings.xml)

Configure as credenciais no Maven:

Arquivo:

```bash
~/.m2/settings.xml
```

Adicionar:

```xml
<servers>
    <server>
        <id>TomcatServer</id>
        <username>admin</username>
        <password>admin</password>
    </server>
</servers>
```

> ⚠️ O `<id>` deve ser o mesmo definido em `<server>` no plugin.

---

## 🌐 Acesso à aplicação

Após o deploy, a aplicação estará disponível em:

```bash
http://localhost:8080/struts-spring-hello
```

---

## 🧠 Observações Técnicas

- O plugin `tomcat7-maven-plugin` é legado, mas funcional para cenários compatíveis.
- Evite expor credenciais em repositórios públicos.
- Para ambientes modernos, considere migração para **Spring Boot** com Tomcat embutido.

---

## 🚧 Troubleshooting

### ❌ Erro 401 / Unauthorized
- Verifique usuário e senha no `tomcat-users.xml`
- Confirme a role `manager-script`

### ❌ Erro de conexão
- Confirme se o Tomcat está rodando na porta 8080
- Verifique a URL `/manager/text`

### ❌ Deploy não funciona
- Confira se o `settings.xml` está configurado corretamente
- Execute: `mvn clean install`

---

## 📌 Objetivo do Projeto

Servir como alternativa leve para execução de aplicações CTBE, mantendo compatibilidade com arquitetura existente sem dependência da infraestrutura original.

---

## 📄 Licença

Uso interno / educacional.
