Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на элемент 'Close popup' если он видим
    When выполнено нажатие на элемент 'Subjects'
    When выполнено нажатие на элемент 'Close popup' если он видим
    When выполнено нажатие на элемент 'Logo'
    When текущий url равен 'https://www.wiley.com/en-us'

