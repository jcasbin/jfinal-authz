# jcasbin-jfinal-plugin 
[![Build Status](https://github.com/jcasbin/jfinal-authz/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/jcasbin/jfinal-authz/actions/workflows/maven-ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/org.casbin/jcasbin-jfinal-plugin.svg)](https://central.sonatype.com/artifact/org.casbin/jcasbin-jfinal-plugin)


jcasbin-jfinal-plugin is an authorization middleware for [JFinal](http://www.jfinal.com/), it's based on [https://github.com/casbin/jcasbin](https://github.com/casbin/jcasbin). It is developed under the latest JFinal ``3.4`` and Java ``8``.

## Installation

```xml
<dependency>
    <groupId>org.casbin</groupId>
    <artifactId>jcasbin-jfinal-plugin</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Simple Example

This project itself is a working JFinal project that integrates with jCasbin. The steps to use jCasbin in your own JFinal project are:

1. Copy the [JCasbinAuthzInterceptor](https://github.com/jcasbin/jcasbin-jfinal-plugin/blob/master/src/main/java/org/jcasbin/plugins/JCasbinAuthzInterceptor.java) class to your own project.
2. Copy [authz_model.conf](https://github.com/jcasbin/jcasbin-jfinal-plugin/blob/master/examples/authz_model.conf) and [authz_policy.csv](https://github.com/jcasbin/jcasbin-jfinal-plugin/blob/master/examples/authz_policy.csv) to your project. You can modify them to your own jCasbin model and policy (or loading policy from DB), see [Model persistence](https://github.com/casbin/casbin/wiki/Model-persistence) and [Policy persistence](https://github.com/casbin/casbin/wiki/Policy-persistence).
3. Replace the [HttpBasicAuthnInterceptor](https://github.com/jcasbin/jcasbin-jfinal-plugin/blob/master/src/main/java/org/jcasbin/plugins/HttpBasicAuthnInterceptor.java) class (which provides [HTTP basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)) with your own authentication like OAuth, Apache Shiro, Spring Security, etc. Rewrite ``JCasbinAuthzInterceptor``'s [String getUser(HttpServletRequest request)](https://github.com/jcasbin/jcasbin-jfinal-plugin/blob/master/src/main/java/org/jcasbin/plugins/JCasbinAuthzInterceptor.java#L40-L54) method to make sure jCasbin can get the authenticated user name.
4. Make sure the ``JCasbinAuthzInterceptor`` interceptor is loaded, so it can filter all your requests. To do this, you can use the following code in your ``XXXConfig`` class:

```java
public class DemoConfig extends JFinalConfig {
    public void configInterceptor(Interceptors me) {
        me.add(new JCasbinAuthzInterceptor());
    }
}
```

## Tutorials

- [加强JFinal的权限管理：与jCasbin权限管理框架进行整合](http://www.jfinal.com/share/842)

## Getting Help

- [jCasbin](https://github.com/casbin/jcasbin)

## License

This project is under Apache 2.0 License. See the [LICENSE](LICENSE) file for the full license text.
