def call() {
    echo "Deploying to IIS web server..."

    powershell '''
    Start-Process "$env:MSDEPLOY_PATH" -ArgumentList @(
        "-verb:sync",
        "-source:package='$env:WORKSPACE\\$env:PACKAGE_NAME'",
        "-dest:contentPath='$env:DEPLOY_PATH',computerName='localhost'",
        "-enableRule:DoNotDeleteRule"
    ) -Wait -NoNewWindow
    '''
}