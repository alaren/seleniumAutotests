Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When отправить GET запрос 'https://httpbin.org/delay/10'
    When отправить GET запрос 'https://httpbin.org/image/png'


