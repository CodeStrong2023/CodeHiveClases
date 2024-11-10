import math
from decimal import Decimal

# NaN(Not a Number)
a = float('NaN') #No tiene sensibilidad ante mayusculas y minusculas -> NaN or Nan -> nan
print(f'a: {a}')

# Modulo math
a = float('nan')
print(f'Es de tipo NaN?: {math.isnan(a)}')

#Modulo Decimal
a = Decimal('nan')
print(f'Es de tipo NaN?: {math.isnan(a)}')