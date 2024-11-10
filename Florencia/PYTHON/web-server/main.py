import store
from fastapi import FastAPI
from fastapi.responses import HTMLResponse

app = FastAPI() #Creamos nuestro primera instancia y con esto vamos a crear nuestro primer recuerso

#Ruta principal
@app.get('/') #Agregamos el decorador para decirle cual es la ruta
def get_list():
    return [1, 2, 3,]

#Segunda ruta
@app.get('/contact', response_class=HTMLResponse)
async def get_list():
    return """

    <h1> SOY UN SITIO WEB DESDE FASTAPI </h1>
    <p>Soy un parrafo para que me leas rey </p>

"""




"""
    Prueba para entender como funciona requests la libreria de python
"""

def run():
    store.get_razas()


if __name__ == '__main__':
    run()