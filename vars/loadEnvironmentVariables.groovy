def call {
    echo "Loading environment variables from the '.env' file..."

    // Reads the ".env" file.
    def envVariables = powershell(returnStdout: true, script: "Get-Content .env -Raw")
                    
    // Parses the contents of the ".env" file, and sets the environment variables in the pipeline.
    envVariables.split("\r?\n").each { line ->
    def keyValue = line.split("=", 2)
    if (keyValue.size() == 2) {
        def key = keyValue[0].trim()
        def value = keyValue[1].trim()
        env."${key}" = value
        echo "Setting ${key} to ${value}"
        }
    }
}