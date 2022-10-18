call runcrud.bat
if "%ERRORLEVEL%" == "0" goto open
echo There were errors

:open
start firefox.exe http://localhost:8080/crud/v1/tasks