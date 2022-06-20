Feature: Cenários deafult de Test


  @tagdefault
  Scenario Outline: Produtos Pan
    Given Eu acesso o site do Google
    When  Eu faço uma "<busca>"
    Then  eu printo o resultado


    Examples:
      | busca          |
      | Pan            |
      | banco pan      |