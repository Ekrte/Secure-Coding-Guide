@echo off
setlocal ENABLEDELAYEDEXPANSION

chcp 65001
rem Change to UTF-8 encoding

SET RESULT_DIR=%~dp0result\
SET SPOTBUS=%~dp0bin_spotbugs\bin\spotbugs.bat
SET PLUGIN=-pluginList %~dp0findsecbugs-plugin-old.jar
SET FLAGS=-textui %PLUGIN% -xml -low

rem Check result directory exists
if not exist result_spotbugs (
    echo "Make .\result_spotbugs directory"
    mkdir result_spotbugs
)

rem Check analysis xml files exist
rem If xml files already exist, move old analysis files to new directory
if exist result_spotbugs/*.xml (
    for /F "delims=" %%a in (' Powershell -Command "Get-Date -Format o | Foreach-Object {$_ -replace ':', '.'}" ') do (
        mkdir "result_spotbugs/%%a"
        Powershell -Command "move result_spotbugs/*.xml result_spotbugs/%%a"
    )
)


rem %SPOTBUS% %FLAGS% "%~dp0testcases\target\06.02 제거되지 않고 남은 디버그 코드\"
for /f "delims=" %%a in ('cmd /r dir /a:d /b testcases\target\') do (
    cmd /r %SPOTBUS% %FLAGS% -output "%~dp0result_spotbugs\%%a.xml" "%~dp0testcases\target\%%a"  
)