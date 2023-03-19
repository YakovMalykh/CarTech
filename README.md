# CarTech

решение состоит из 2 приложений: это - сервер (на нем же есть апи для аналитиков) и клиентский REST https://github.com/YakovMalykh/CarClient, связанных по протоколу RSocket

запустить приложения можно при помощи фалй docker-compose up

http://localhost:8081/webjars/swagger-ui/index.html#/client-contoller/getInfoByUuid - клиентский сервис

http://localhost:8080/webjars/swagger-ui/index.html#/analysts-controller/getNewUsersForPeriodByEachCountry - сервис аналитиков

