def call(String packageName, String deployPath) {
    echo "Deploying to IIS web server..."

    powershell '''
    Start-Process "C:\\Program Files\\IIS\\Microsoft Web Deploy V3\\msdeploy.exe" -ArgumentList @(
        "-verb:sync",
        "-source:package='$env:WORKSPACE\\$env:PACKAGE_NAME'",
        "-dest:contentPath='$env:DEPLOY_PATH',computerName='localhost'",
        "-enableRule:DoNotDeleteRule"
    ) -Wait -NoNewWindow
    '''
}