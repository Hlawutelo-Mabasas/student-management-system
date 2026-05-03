@echo off
setlocal

where mvn >nul 2>nul
if %errorlevel% neq 0 (
    echo Maven is not installed or not available on PATH.
    echo Install Maven, then run: mvn spring-boot:run
    exit /b 1
)

mvn %*
