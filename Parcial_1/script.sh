#!/bin/bash

if [ "$#" -eq 0 ]; then
    echo "No se proporcionaron argumentos. Por favor, proporciona una función como argumento."
    exit 1
fi

funcion=${1}

#Servicio de nginx
instalar() {
apt-get install nginx -y
}

iniciar(){
systemctl start nginx
}

parar(){
systemctl stop nginx
}

persistir(){
systemctl enable nginx
}

nopersistir(){
systemctl disable nginx
}

verpersistencia(){
systemctl is-enabled nginx
}

verestado(){
systemctl status nginx
}

reiniciar(){
systemctl restart nginx
}

reiniciarmaquina(){
reboot
}

help(){
echo "instalar = instalar nginx"
echo "iniciar = iniciar el servicio"
echo "parar = parar el servicio"
echo "persistir = añadir autoarranque"
echo "nopersistir = deshabilitar autoarranque"
echo "verpersistencia = verificar si la persistencia está activa"
echo "verestado = verificar el estado del servicio"
echo "reiniciar = reiniciar el servicio"
echo "reiniciarmaquina = reiniciar la máquina"
}

if [ "instalar" = $funcion ]
then
instalar
elif [ "iniciar" = $funcion ]
then
iniciar
elif [ "parar" = $funcion ]
then
parar
elif [ "persistir" = $funcion ]
then
persistir
elif [ "verpersistencia" = $funcion ]
then
verpersistencia
elif [ "verestado" = $funcion ]
then
verestado
elif [ "reiniciar" = $funcion ]
then
reiniciar
elif [ "reiniciarmaquina" = $funcion ]
then
reiniciarmaquina
elif [ "nopersistir" = $funcion ]
then
nopersistir
elif [ "help" = $funcion ]
then
help
fi
