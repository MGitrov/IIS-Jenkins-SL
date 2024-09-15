def call() {
    echo "Recycling ${env.WEB_APP_POOL} web app pool..."

    powershell '''
    Restart-WebAppPool -Name "$env:WEB_APP_POOL"
    '''
}