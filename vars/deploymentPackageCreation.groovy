def call() {
    echo "Creating deployment package: ${env.PACKAGE_NAME}"
                        
    powershell '''
    Write-Host "Compressing files from: ${env:WORKSPACE}"
    Write-Host "Saving to: ${env:PACKAGE_NAME}"

    # Excludes the "Configuration" directory and ".gitmodules" file during compression.
    $itemsToCompress = Get-ChildItem -Path $env:WORKSPACE -Recurse | Where-Object {
    $_.FullName -notlike "*\\Configuration*" -and $_.FullName -notlike "*.gitmodules"}

    # Lists the files to be compressed.
    $itemsToCompress | ForEach-Object { Write-Host "Including: $($_.FullName)" }    
    Compress-Archive -Path $itemsToCompress.FullName -DestinationPath $env:PACKAGE_NAME -Force -Verbose
    '''
}