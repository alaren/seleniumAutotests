Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на элемент 'Close popup' если он видим
    When ввести в поле 'Search field' текст 'java'
    When выполнено нажатие на элемент 'Search button'
    When выполнено нажатие на элемент 'Close popup' если он видим
    When список 'Product title' содержит '10' элементов

