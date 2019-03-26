Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на элемент 'Close popup' если он видим
    When навести курсор на 'Who We Serve'
    When список 'Droplist Who We Serve' содержит '13' элементов
    When список 'Droplist Who We Serve' содержит следующие значения:
    |Students|
    |Instructors|
    |Book Authors|
    |Professionals|
    |Researchers|
    |Institutions|
    |Librarians|
    |Corporations|
    |Societies|
    |Journal Editors|
    |Bookstores|
    |Journalists|
    |Government|