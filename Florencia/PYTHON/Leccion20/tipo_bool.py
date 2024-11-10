# Bool contiene los valores de True y False
# Los tipos numericos, es false para el 0(cero), true para los demas valores
valor = 0.0 # 0
resultado = bool(valor)
print(f'El valor es: {valor} y su bool es = {resultado}')

valor = 0.1 #15 - 1 - 10000 - -1 - etc
resultado = bool(valor)
print(f'El valor es: {valor} y su bool es = {resultado}')

#Tipo String -> False = '', True = demas valores

valor = ''
resultado = bool(valor)
print(f'El valor es: {valor} y su bool es = {resultado}')

valor = 'Hola'
resultado = bool(valor)
print(f'El valor es: {valor} y su bool es = {resultado}')

# Tipo Colecciones -> False = para colecciones vacias y True = para todas las demas
#lista
valor = []
resultado = bool(valor)
print(f'El valor de una lista vacia: {valor} y su bool es = {resultado}')

valor = ['Hola']
resultado = bool(valor)
print(f'El valor de una lista con elementos: {valor} y su bool es = {resultado}')

# TUPLA
valor = ()
resultado = bool(valor)
print(f'El valor de una tupla vacia: {valor} y su bool es = {resultado}')

valor = (5,)
resultado = bool(valor)
print(f'El valor valor de una tupla con elementos: {valor} y su bool es = {resultado}')

# Diccionario
valor = {}
resultado = bool(valor)
print(f'El valor de un diccionario vacio: {valor} y su bool es = {resultado}')

valor = {'Nombre': 'Juan', 'Apellido': 'Perez'}
resultado = bool(valor)
print(f'El valor valor de un diccionario con elementos: {valor} y su bool es = {resultado}')

# SET
valor = {}
resultado = bool(valor)
print(f'El valor de un Set vacio: {valor} y su bool es = {resultado}, {type(valor)}')

valor = {1, 2, 3, 4}
resultado = bool(valor)
print(f'El valor valor de un Set con elementos: {valor} y su bool es = {resultado}, {type(valor)}')

# -----------------------> Sentencias de Control con Bool

if '':
    print("Regresa Verdadero")
else:
    print("Regresa Falso")

if 0:
    print("Regresa Verdadero")
else:
    print("Regresa Falso")

#Ciclos
variable = 17
while variable:
    print("Regresa Verdadero")
    break
else:
    print("Regresa Falso")















