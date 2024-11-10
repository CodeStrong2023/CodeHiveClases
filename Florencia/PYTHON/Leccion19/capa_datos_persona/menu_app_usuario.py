from capa_datos_persona.usuario_dao import UsuarioDAO
from capa_datos_persona.logger_base import log
from Usuario import Usuario
opcion = None

while opcion != 5:
    print('Opciones: ')
    print('1. Listar Usuarios')
    print('2. Agregar Usuarios')
    print('3. Modificar Usuario')
    print('4. Eliminar Usuario')
    print('5. Salir')
    try:
        opcion = int(input('Digite la opcion (1-5): '))
        if opcion == 1:
            usuarios = UsuarioDAO.seleccionar()
            for usuario in usuarios:
                log.info(usuario)
        elif opcion == 2:
            username_var = input('Digite el nombre de usuario: ')
            password_var = input('Digite el password: ')
            usuario = Usuario(username=username_var, password=password_var)
            usuario_insertado = UsuarioDAO.insertar(usuario)
            log.info(f'Usuario Insertado: {usuario_insertado}')
            # print(usuario_insertado)

        elif opcion  == 3:
            id_usuario_var = int(input('Digite el id del usuario a modificar: '))
            username_var = input('Digite el nombre de usuario a modificar: ')
            password_var = input('Digite el password a modificar: ')
            usuario = Usuario(id_usuario=id_usuario_var, username=username_var, password=password_var)
            usuario_modificado = UsuarioDAO.actualizar(usuario)
            log.info(f'Usuario Actualizado : {usuario_modificado}')

        elif opcion == 4:
            id_usuario_var = int(input('Digite el id del usuario a eliminar: '))
            usuario = Usuario(id_usuario=id_usuario_var)
            usuario_eliminado = UsuarioDAO.eliminar(usuario)
            log.info(f'Usuario Eliminado: {usuario_eliminado}')

    except ValueError as e:
        print('Error: Digite un valor numérico correcto de 1-5.')

else:
    log.info('Salimos de la aplicacion, Chau rey!')
