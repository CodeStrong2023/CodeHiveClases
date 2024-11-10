import pygame


pygame.init()

#COnfiguracion de la pantalla
screen = pygame.display.set_mode((800, 600))
clock = pygame.time.Clock()#controlamos que la pantalla no se abra ni ce cierra automaticamente
running = True
dt = 0

# Posicion del jugador
player_pos = pygame.Vector2(screen.get_width() / 2, screen.get_height() / 2)

# Velocidad del jugador
player_speed = 5

# Bucle principal
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    #Detectar las flechas a presionar para mover el personaje
    keys = pygame.key.get_pressed() #Nos detecta las teclas que vamos tocando

    #Movimiento del jugador
    if keys[pygame.K_LEFT]: #Se preciona la tecla izquierda
        player_pos.x -= player_speed
    if keys[pygame.K_RIGHT]: # tecla derecha
        player_pos.x += player_speed
    if keys[pygame.K_DOWN]: #Tecla abajo
        player_pos.y += player_speed
    if keys[pygame.K_UP]: #Tecla arriba
        player_pos.y -= player_speed

    # Limpiamos la pantalla
    screen.fill('green')

    #Dibujamos al jugador (En este caso sera un circulo rojo)
    pygame.draw.circle(screen, color=(255, 0, 0), center=(float(player_pos.x), float(player_pos.y)), radius=10)

    #Actualizar pantalla
    pygame.display.flip()

    # Control de velocidad del jugador. Los Frames por segundos
    clock.tick(60)


pygame.quit() #Cierre del programa