Feature: Navegar por BBVA NEXT TECHNOLOGIES

  Scenario: Navegar por la web y capturar pantalla del blog
    Given abrir navegador
    And aceptar cookies
    And navegar a la web BBVA NEXT TECHNOLOGIES
    And navegar al Blog
    When abrir el penultimo post
    Then capturar pantalla
