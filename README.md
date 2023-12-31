## Тестовое задание.

Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту
встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в
заданную строку.

Пример входной строки: “aaaaabcccc”
Пример выходного результата: `"a": 5, "c": 4, "b": 1`

Требования к решению:

1) Java 8+
2) Spring boot 2+
3) Решение должно быть покрыто тестами
4) У решения должна быть документация по запуску и формату входящих/исходящих параметров
5) Код решения необходимо разместить в публичном Github репозитории.

## Описание

Проект собирается и запускается с использованием команды `docker-compose up`.

Для оптимизации производительности проекта было внедрено кеширование, использующее базу данных `NoSQL Redis`.

После успешного выполнения команды docker-compose up, сервер будет доступен по адресу `localhost:8080`, и вы сможете
взаимодействовать с ним через REST API для выполнения задачи по подсчету частоты встречи символов в заданной строке.

## Описание работы программы

После успешного запуска проект у вас будет доступ к endpoint `/api/count`, полный url выглядит
так `http://localhost:8080/api/count`.

### Пример использования

Отправьте HTTP POST-запрос на `http://localhost:8080/api/count` с телом запроса в формате
JSON: `{"symbols": "aaaaabcccc"}`

Программа подсчитает частоту вхождений символов в строку "aaaaabcccc" и вернет результат в формате JSON: `{
"a": 5,
"c": 4,
"b": 1
}
`