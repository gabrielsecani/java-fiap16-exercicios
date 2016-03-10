
rem ## Set http.sslcainfo to the absolute path of the curl-ca-bundle.crt file in your msysGit install’s bin folder
rem git config --system http.sslcainfo \bin/curl-ca-bundle.crt
rem ## Disable ssl verification
rem git config --global http.sslverify "false"

rem ## fonte: https://aircrack.wordpress.com/2014/02/12/problem-solving-git-error-setting-certificate-verify-locations/

git config --system http.sslcainfo c:\\git\\mingw64\\ssl\\certs\\ca-bundle.crt
