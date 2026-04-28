# Struts 2 + Spring 3

Uma versão tipo **Open BSAD3**

Projeto feito para rodar aplicações BSAD sem precisar da BSAD3, utilizando **Tomcat 9**.

---

## ⚙️ Configuração do Tomcat 9

Configure o Tomcat com usuário e senha:

admin / admin

Edite o arquivo:

TOMCAT_HOME/conf/tomcat-users.xml

Adicione:

```xml
<user username="admin" password="admin" roles="manager-script"/>
```

---

## ▶️ Execução

Após subir o Tomcat, execute os comandos abaixo no projeto:

### 📦 Primeiro deploy
mvn tomcat7:deploy

### 🔄 Atualizar aplicação
mvn tomcat7:redeploy

### ❌ Remover aplicação
mvn tomcat7:undeploy

---

## 🔌 Configuração do Plugin

<url>http://localhost:8080/manager/text</url>
<server>TomcatServer</server>
<username>admin</username>
<password>admin</password>
