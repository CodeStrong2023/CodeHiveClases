import sys
import pygame
from constantes import SCREEN_WIDTH, SCREEN_HEIGTH, ASSETS_PATH, IMPERIAL_MARCH_PATH, FONDO1_PATH, ESTRELLA_PATH
from personaje import Personaje
from personaje import *


def mostrar_pantalla_inicio(screen):
    # Cargar y mostrar la imagen de inicio
    imagen_inicio = pygame.image.load(START_IMAGE_PATH)
    imagen_inicio = pygame.transform.scale(imagen_inicio, (SCREEN_WIDTH, SCREEN_HEIGTH))
    screen.blit(imagen_inicio, (0, 0))
    pygame.display.flip()


    # Reproducir audio
    pygame.mixer.music.load(IMPERIAL_MARCH_PATH)
    pygame.mixer.music.play()


    # Esperar a que termine el audio
    while pygame.mixer.music.get_busy():
        for event in pygame.event.get():
            if event.Type.QUIT:
                pygame.quit()
                sys.exit()

        # Actualizar pantalla
        screen.blit(imagen_inicio, (0, 0))
        pygame.display.flip()


def main():
    pygame.init()
    screen = pygame.display.set_mode(SCREEN_WIDTH, SCREEN_HEIGTH)
    pygame.display.set_caption('Amenaza Fantasma')

    #cargar los recursos del juego
    icon = pygame.image.load(f'{ASSETS_PATH}/imagenes/fondo001.png') #.jfif
    pygame.display.set_icon(icon)

    fondo = pygame.image.load(f'{ASSETS_PATH}/imagenes/fondo3.png')
    fondo = pygame.transform.scale(fondo, (SCREEN_WIDTH, SCREEN_HEIGTH))

    estrella = pygame.image.load(ESTRELLA_PATH)
    estrella = pygame.transform.scale(fondo1, (SCREEN_WIDTH, SCREEN_HEIGTH))

    fondo1 = pygame.image.load(FONDO1_PATH)
    fondo1 = pygame.transform.scale(fondo1, (SCREEN_WIDTH, SCREEN_HEIGTH))


    sonido_laser = pygame.mixer.Sound(f'{ASSETS_PATH}/sounds/explosion.mp3')


    #Personajes
    personaje = Personaje(SCREEN_WIDTH // 2, SCREEN_HEIGTH // 2 )
    enemigos = []
    explosiones = []
    puntos = 0
    nivel = 1

    clock = pygame.time.Clock()
    running = True

    #Inicializar el fondo actual con el fondo original
    fondo_actual = fondo


    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        keys = pygame.key.get_pressed()
        dx, dy = 0, 0

        if keys[pygame.K_LEFT]:
            dx = -5
        if keys[pygame.K_RIGHT]:
            dx = 5
        if keys[pygame.K_UP]:
            dy = -5
        if keys[pygame.K_DOWN]:
            dy = 5

        personaje.mover(dx, dy)

        if keys[pygame.K_SPACE]:
            personaje.lanzar_laser()
            sonido_laser.play()


    for enemigo in enemigos:
        enemigo.mover()
        if enemigo.rect.top > SCREEN_HEIGTH:
            enemigo.remove(enemigo)

    for laser in personaje.lasers:
        if enemigo.rect.colliderect(laser.rect):
            explosiones.append(Explosion(enemigo.rect.centerx, enemigo.rect.centery))
            enemigo.remove(enemigo)
            personaje.lasers.remove(laser)
            sonido.explosion.play()
            puntos += 10
            break
    if enemigo.rect.colliderect(personaje.shape):
        if not personaje.recibir_dano():
            running = False





















