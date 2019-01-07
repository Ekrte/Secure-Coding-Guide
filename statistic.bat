@echo off
setlocal ENABLEDELAYEDEXPANSION

chcp 65001
rem Change to UTF-8 encoding
SET DST_DIR="testcases\Java"
rem SET DST_DIR="testcases\Java\098 Sparrow"

for /f "delims=" %%a in ('cmd /r dir /a:d /b %DST_DIR%') do (
    echo '%%a\*'
    rem Below powershell command is same with 'grep -r "bad(" . | wc -l' in bash shell
    Powershell -Command "(findstr /S \"bad.*(\" '%~dp0\%DST_DIR%\%%a\*' | measure -line).Lines"
    Powershell -Command "(findstr /S \"action(\" '%~dp0\%DST_DIR%\%%a\*' | measure -line).Lines"
    Powershell -Command "(findstr /S \"good.*(\" '%~dp0\%DST_DIR%\%%a\*' | measure -line).Lines"
)