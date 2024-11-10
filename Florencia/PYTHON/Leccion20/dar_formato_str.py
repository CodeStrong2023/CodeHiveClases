#dar formato a un str
#Parametro posicional -> %s
# %s -> String, %d -> Decimal

nombre = 'Ariel'
edad = 28
sueldo = 3000
# mensaje_con_formato = 'Mi nombre es %s y mi edad es %d años'%(nombre, edad)
#
# #Creamos una tupla
# persona = ('Carla', 'Gomez', 5000.00)
# mensaje_con_formato = 'Hola %s %s . Tu sueldo es: $%.2f'  #%persona #-->Comentado aqui le pasamos el objeto que es una tupla
# # print(mensaje_con_formato % persona) # -> Lo podemos poner en el print
#
#
# nombre = 'Juan'
# edad = 19
# sueldo = 3000
#
# # mensaje_con_formato = 'Nombre {} Edad {} Sueldo {:.2f}'.format(nombre, edad, sueldo)
# # print(mensaje_con_formato)
#
# mensaje = 'Nombre {0} Edad {1} Sueldo {2:.2f}'.format(nombre, edad, sueldo)
# print(mensaje)

mensaje = 'Nombre {n} Edad {e} Sueldo {s:.2f}'.format(n=nombre, e=edad, s=sueldo)
# print(mensaje)


diccionario = {'Nombre': 'Ivan',
               'Edad': 35,
               'Sueldo': 8000.00}

mensaje = 'Nombre {dict[Nombre]} edad {dict[Edad]} Sueldo: {dict[Sueldo]:.2f}'.format(dict=diccionario)
print(mensaje)











