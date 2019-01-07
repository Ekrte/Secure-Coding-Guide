@echo off
setlocal

chcp 65001
rem Change to UTF-8 encoding

SET SRC_DIR=%~dp0\juliet-test-suite-master\target\classes\testcases
SET KISA_DIR=%~dp0\Java
SET DST_DIR=%~dp0\target\

IF "%1"=="copy_class" goto :copy_class
IF "%1"=="copy_dir_tree" goto :copy_dir_tree


:copy_dir_tree
if not exist target (
    echo "Make .\target directory"
    mkdir target
)

cd %DST_DIR%
xcopy /T /E %KISA_DIR%
rem "Copy directory structure from KISA_DIR"
goto :end

:copy_class
echo "=============================="
echo "SRC_DIR = " + %SRC_DIR%
echo "DST_DIR = " + %DST_DIR%
echo "Copy from SRC_DIR to DST_DIR"
echo "=============================="

cd %DST_DIR%
cmd /r dir /a:d /b %KISA_DIR%

for /f "delims=" %%a in ('cmd /r dir /a:d /b %KISA_DIR%') do (
    echo %%a
    cd %DST_DIR%\%%a
    for /f "delims=" %%b in ('cmd /r dir /a:d /b') do (
        if exist %SRC_DIR%\%%b (
            echo %SRC_DIR%\%%b
            xcopy /E "%SRC_DIR%\%%b" "%DST_DIR%\%%a\%%b"
        )
    )
)

:end
cd %~dp0