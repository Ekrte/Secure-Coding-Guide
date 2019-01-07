@echo off
setlocal ENABLEDELAYEDEXPANSION

chcp 65001
rem Change to UTF-8 encoding

SET PMD=%~dp0pmd\bin\pmd.bat
echo %PMD%
SET PLUGIN=-R %~dp0ruleset.xml
SET FLAGS=-f xml %PLUGIN%

rem Check result directory exists
if not exist result_pmd (
    echo "Make .\result directory"
    mkdir result_pmd
)

rem Check analysis xml files exist
rem If xml files already exist, move old analysis files to new directory
if exist result_pmd/*.xml (
    for /F "delims=" %%a in (' Powershell -Command "Get-Date -Format o | Foreach-Object {$_ -replace ':', '.'}" ') do (
        mkdir "result_pmd/%%a"
        Powershell -Command "move result_pmd/*.xml result_pmd/%%a"
    )
)

rem %PMD% -d "testcases\Java\01.01 SQL 삽입" -f html -R ruleset.xml 
for /f "delims=" %%a in ('cmd /r dir /a:d /b testcases\Java\') do (
    cmd /r %PMD% %FLAGS% -encoding UTF-8 -d "%~dp0testcases\Java\%%a" -r "%~dp0result_pmd\%%a.xml"
)