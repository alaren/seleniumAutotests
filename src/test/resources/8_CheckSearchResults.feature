Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When ввести в поле 'Search field' текст 'java'
    When выполнено нажатие на кнопку 'Search button'
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When выпадающий список 'Product title' содержит '10' элементов

