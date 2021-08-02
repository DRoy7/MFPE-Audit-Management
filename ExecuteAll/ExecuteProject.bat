echo "Running Audit-Management-System\n"
cd Exec
start RunAuthMS.bat
start RunBenchMS.bat
start RunCheckMS.bat
start RunSeverityMS.bat
start chrome --new-window "localhost:8300/db"
start RunWebApp.bat
