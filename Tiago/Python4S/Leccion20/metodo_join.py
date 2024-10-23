
# help(str.join)
#Este metodo solo funciona con Strings <--

tupla_str = ('Hola', 'Alumnos', 'Tecnicatura', 'Univeritaria')
mensaje = ' '.join(tupla_str)
print(f'Mensaje: {mensaje}')

lista_cursos = ['Java', 'Javascript', 'Python', 'Angular', 'Spring']
mensaje = ', '.join(lista_cursos)
print(f'Mensaje: {mensaje}')

cadena = 'HolaMundo'
mensaje = '.'.join(cadena)
print(f'Mensaje: {mensaje}')

diccionario = {'Nombre': 'Juan',
               'Apellido': 'Perez',
               'edad': '18'}
llaves = '-'.join(diccionario.keys())
valores = '-'.join(diccionario.values())
print(f'Llaves: {llaves}, type: {type(llaves)}')
print(f'Valores: {valores}, type: {type(valores)}')

