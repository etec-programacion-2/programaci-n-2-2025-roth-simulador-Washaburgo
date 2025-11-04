Ivan ROTH
4° Informatica
ETec

# Clonar el repositorio
git clone https://github.com/etec-programacion-2/programaci-n-2-2025-roth-simulador-Washaburgo.git

# Entrar al directorio
cd programaci-n-2-2025-roth-simulador-Washaburgo

# Compilar el proyecto
kotlinc src/main/kotlin/org/example/App.kt -include-runtime -d Bundesliga.jar

# Ejecutar el simulador
java -jar Bundesliga.jar
