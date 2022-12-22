Feature: Entrar en la cuenta de usuario

  como cliente del banco
  quiero entrar en mi cuenta bancaria
  para hacer transacciones

  Scenario: Ingreso correcto del Login
    Given que el cliente entro a pagina Home del banco
    When llene el username y password correctamente.
    Then entrara a la cuenta overview.

  Scenario: Ingreso incorrecto del Login
    Given que el cliente entro a pagina Home del banco
    When no escriba usuario y contrasena.
    Then recibira un mensaje de error