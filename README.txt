Для получения репортов allure for windows:
1) установить с папки /src/main/resources -> Windows6.1-KB2506143-x64.msu
2) отрыть windows power shell -> написать в командной строке iex (new-object net.webclient).downloadstring('https://get.scoop.sh') , если ошибка сделать
Set-ExecutionPolicy RemoteSigned -scope CurrentUser
3) пишем команду scoop install allure
4) Run tests
5) Пишем allure serve  pathToProject\target\allure-results   - откроется алюр репорт