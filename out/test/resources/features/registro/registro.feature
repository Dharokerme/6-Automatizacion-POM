Feature: Registrar usuario nuevo

  como nuevo cliente del banco
  quiero registrar una cuenta bancaria
  para tener productos financieros


  Scenario: Registro correcto del cliente
    Given que el cliente entro a la pagina de registro
    When llene el formulario correctamente.
    Then recibira un mensaje de cuenta creada correctamente.

  Scenario: Registro incorrecto del cliente
    Given que el cliente entro a la pagina de registro
    When llene el formulario incorrectamente.
    Then recibira un mensaje con los datos a corregir.
