from capa_datos_persona.Usuario import Usuario
from capa_datos_persona.logger_base import log
from capa_datos_persona.cursor_del_pool import CursorDelPool

class UsuarioDAO:
    '''
    DAO -> Data Acces Object para la tabla usuario
    CRUD -> Create - Read - Update - Delete
    '''

    _SELECT = 'SELECT * FROM usuario ORDER BY id_usuario'
    _INSERTAR = 'INSERT INTO usuario(username, password) VALUES (%s, %s)'
    _ACTUALIZAR = 'UPDATE usuario SET username=%s, password=%s WHERE id_usuario=%s'
    _ELIMINAR = 'DELETE FROM usuario WHERE id_usuario=%s'

    @classmethod
    def seleccionar(cls):
        with CursorDelPool() as cursor:
            log.debug('Seleccionando usuarios')
            cursor.execute(cls._SELECT)
            registros = cursor.fetchall()
            usuarios = []
            for registro in registros:
                usuario = Usuario(registro[0], registro[1], registro[2])
                usuarios.append(usuario)
            return usuarios

    @classmethod
    def insertar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'Usuario a insertar: {usuario}')
            valores = (usuario.username, usuario.password)
            cursor.execute(cls._INSERTAR, valores)
            return cursor.rowcount

    @classmethod
    def actualizar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'Usuario a Actualizar: {usuario}')
            valores = (usuario.username, usuario.password, usuario.id_usuario)
            cursor.execute(cls._ACTUALIZAR, valores)
            return cursor.rowcount

    @classmethod
    def eliminar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'Usuario a eliminar: {usuario}')
            valores = (usuario.id_usuario,) #No olvidar porner la coma que convierte eso en una tupla
            cursor.execute(cls._ELIMINAR, valores)
            return cursor.rowcount


# if __name__ == '__main__':
    # ## Eliminar un registro
    # usuario = Usuario(id_usuario=3)
    # usuario_eliminado = UsuarioDAO.eliminar(usuario)
    # log.debug(f'Usuario Eliminado: {usuario_eliminado}')

    # ## Actualizar un registro
    # usuario = Usuario(id_usuario=1, username='', password='369')
    # usuario_actualizado = UsuarioDAO.actualizar(usuario)
    # log.debug(f'Usuario Actualizado: {usuario_actualizado}')

    ## Insertar un registro
    # usuario = Usuario(username='kely', password='321')
    # usuario_insertado = UsuarioDAO.insertar(usuario)
    # log.debug(f'Usuario Insertado: {usuario_insertado}')

    ## Seleccionar objectos
    # usuarios = UsuarioDAO.seleccionar()
    # for usuario in usuarios:
    #     log.debug(usuario)