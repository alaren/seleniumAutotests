Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When подождать '3' секунд
    When навести курсор на 'Subjects'
    When подождать '3' секунд
    When навести курсор на элемент выпадающего списка 'Droplist Subjects' с текстом 'Education'
    When подождать '3' секунд
    When выпадающий список 'Droplist Education' содержит следующие значения:
      |Assessment, Evaluation Methods|
      |Classroom Management          |
      |Conflict Resolution & Mediation|
      |Curriculum Tools               |
      |Education & Public Policy      |
      |Educational Research           |
      |General Education              |
      |Higher Education               |
      |Information & Library Science  |
      |Special Education              |
      |Special Topics                 |
      |Vocational Technology          |

