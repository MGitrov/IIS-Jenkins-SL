def call(String webAppPool) {
    echo "Recycling ${webAppPool} web app pool..."

    powershell '''
    Restart-WebAppPool -Name "$env:WEB_APP_POOL"
    '''
}