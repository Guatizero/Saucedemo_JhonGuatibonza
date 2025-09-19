# language: es

Característica: Flujo de compra exitosa en SauceDemo
  Como usuario de SauceDemo
  Quiero poder realizar una compra exitosa
  Para obtener los productos que deseo

  Escenario: Compra exitosa de dos productos
    Dado Que el usuario ingresa a la página de SauceDemo
    Y Se autentica con el usuario "standard_user" y la contraseña "secret_sauce"
    Cuando Agrega dos productos al carrito "Sauce Labs Bike Light" e "Sauce Labs Backpack"
    Y Continua con la compra y los datos "Jon", "Pérez", "11000456"
    Entonces se visualiza el mensaje de confirmación "Thank you for your order!"