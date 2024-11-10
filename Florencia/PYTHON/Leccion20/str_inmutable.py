# help(str.capitalize)
#---------------------------#
# Las cadenas son inmutables#
#---------------------------#
mensaje1 = 'hola mundo'
mensaje2 = mensaje1.capitalize()

#capitalize no modifica la cadena actual, crea una nueva cadena
print(f'Mensaje1: {mensaje1}, id: {id(mensaje1)}')
print(f'mensaje2: {mensaje2}, id: {id(mensaje2)}')


mensaje1 += ' Adios'
print(f'Mensaje1: {mensaje1}, id: {id(mensaje1)}')

