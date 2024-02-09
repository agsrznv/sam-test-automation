# Implementación

Las pruebas están hechas con Java, la IDE es IntelliJ y el framework de testing JUnit. La gestión de dependencias la hace Maven.

Tomé como referencia la [documentación](https://www.selenium.dev/documentation/webdriver/) y [recomendaciones](https://www.selenium.dev/documentation/test_practices/) de Selenium; el diseño está basado en el patrón de automatización Page Object Models, tratando de abstraer la lógica de las páginas de la de testeo.

Las clases que modelan las páginas y componentes están en
```
src/main/java/sam/challenge
```

y las pruebas en 
```
src/test/java/sam/challenge
```

# Despliegue

Las pruebas se pueden ejecutar desde IntelliJ dentro de la clase _ChallengeTest_, que se encuentra en el directorio mencionado en el anterior apartado.