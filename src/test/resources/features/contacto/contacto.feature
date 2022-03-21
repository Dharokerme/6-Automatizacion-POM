Feature: Comunicacion con Costumer Care

  como cliente del banco
  quiero comunicarme con el costumer service
  para resolver mis dudas

  Scenario: Envio de formulario valido a costumer care
    Given que el cliente entro a pagina del Costumer Care
    When llene el formulario correctamente
    Then recibira un mensaje de pronto contacto

  Scenario: Envio de formulario no valido a costumer care
    Given que el cliente entro a pagina del Costumer Care
    When llene el formulario incorrectamente
    Then recibira mensajes con los campos a corregir