Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на элемент 'Close popup' если он видим
    When ввести в поле 'Search field' текст 'java'
    When элемент 'Suggestion block' отображается на странице
    When список 'Suggestion list' содержит '4' элементов
    When список 'Product list' содержит '4' элементов
    When названия всех элементов в списке 'Suggestion list' должны начинаться с 'java'
    When названия всех элементов в списке 'Product list' должны содержать 'java'

