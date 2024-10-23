import math
from decimal import Decimal
# manejo de valores infinitos

infinito_positivo = float('inf') #NO OLVIDAR LA CADENA
print(infinito_positivo)
print(f'Es infinito: {math.isinf(infinito_positivo)}')


infinito_negativo = float('-inf')
print(infinito_negativo)
print(f'Es infinito: {math.isinf(infinito_negativo)}')

print(infinito_positivo - infinito_negativo)
print(infinito_negativo - infinito_positivo)

#modulo math
infinito_positivo = math.inf
print(infinito_positivo)
print(f'Es infinito: {math.isinf(infinito_positivo)}')

#modulo math
infinito_negativo = -math.inf
print(infinito_negativo)
print(f'Es infinito: {math.isinf(infinito_negativo)}')


#Modulo decimal
infinito_positivo = Decimal('Infinity')
print(infinito_positivo)
print(f'Es infinito: {math.isinf(infinito_positivo)}')

#Modulo decimal
infinito_negativo = Decimal('-Infinity')
print(infinito_negativo)
print(f'Es infinito: {math.isinf(infinito_negativo)}')





