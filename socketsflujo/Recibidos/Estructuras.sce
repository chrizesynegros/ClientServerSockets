// Pedro Alejandro Álvarez Pérez
// PZ19119236
// Herramientas Computacionales
// Mecatrónica
clc
clear
op=1;
i=0
while (op==1)
    i=i+1
agenda(i).nombre=input("Nombre: ","s")
agenda(i).edad=input("Edad: ")
agenda(i).tel=input("Telefono: ","s")
agenda(i).correo=input("Correo: ","s")
op=input("Presiona 1 para continuar")
end
clc
for (j=1:1:i)
    printf("Datos de la persona %d",j)
    printf("Nombre: %s \n",agenda(i).nombre)
    printf("Edad: %d \n",agenda(i).edad)
    printf("Telefono: %d \n",agenda(i).tel)
    printf("Correo: %s \n",agenda(i).correo)
end
