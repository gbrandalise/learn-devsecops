# Executar os seguintes comandos no PowerShell e reiniciar o Windows antes de instalar o WSL
#Enable-WindowsOptionalFeature -Online -FeatureName VirtualMachinePlatform
#Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux
$WSL_DISTRO = "Ubuntu"
$WSLENV_VAR = (Get-ItemProperty $USER_VAR_REGISTRY).WSLENV
if ("$WSLENV_VAR" -eq "") {
  setx "WSLENV" "USERPROFILE/up"
  $env:WSLENV = (Get-ItemProperty $USER_VAR_REGISTRY).WSLENV
}
wsl --update
wsl --set-default-version 2
$DISTRO_INSTALLED = $(wsl -l |Where {$_.Replace("`0","") -match "$WSL_DISTRO"})
if ("$DISTRO_INSTALLED" -eq "") {
  wsl --install -d $WSL_DISTRO
}