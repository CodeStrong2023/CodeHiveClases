#Profundizando en el tipo float
a = 3.0
print(f"a float: {a:.2f}") # :.2f o 3f o la cantidad de decimales que quieras

#constructor de tipo float -> puede recibir int y str
a = float(10) #Le pasamos tipo entero(int)
a = float('10') #Le pasamos tipo string(str)
print(f"a: {a:.2f}")

#Notacion exponencial(valores positivos o negativos)
a = 3e5 #3 exponencial 5
print(f"a: {a:.2f}")

a = 3e-5
print(f"a: {a:.5f}")

# Cualquier calculo que incluya un float, todo cambia a float
a = 4.0 + 5
print(a)
print(type(a))










