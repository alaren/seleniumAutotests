Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на элемент 'Close popup' если он видим
    When навести курсор на 'Subjects'
    When навести курсор на элемент списка 'Droplist Subjects' с текстом 'Education'
    When список 'Droplist Education' содержит следующие значения:
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

