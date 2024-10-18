import pygame
from constantes import *


class Personaje:
    def __init__(self, x, y):
        self.image = pygame.image.load(f'{ASSETS_PATH}/imagenes/nave1.jfif')
        self.image = pygame.transform.scale(self.image, (95, 95))
        self.shape = self.image.get_rect(center=(x, y))
        self.lasers = []
        self.energia = 100 #Barra de energia

    def mover(self, dx, dy):
        self.shape.x += dx
        self.shape.y += dy

    def lanzar_laser(self):
        laser = Laser(self.shape.centerx, self.shape.top)
        self.lasers.append(laser)


    def recibir_dano(self):
        self.energia -= 10
        if self.energia <= 0:
            self.energia = 0
            return False
        return True

    def dibujar(self, screen):
        screen.blit(self.image, self.topleft)
        for laser in self.lasers:
            laser.dibujar(screen)
            laser.mover()


        # Dibujamos la barra de energia
        pygame.draw.rect(screen, (255, 0, 0), (10, 10, 100, 10)) #Barra de fondo
        pygame.draw .rect(screen, (0, 255, 0), (10, 10,self.energia, 10)) #Barra de energia



class Enemigo:
    def __init__(self, x, y):
        self.image = pygame.image.load(f'{ASSETS_PATH}/imagenes/enemigo.png') #Cargar la imagen
        self.image = pygame.transform.scale(self.image, (80, 80))
        self.rect = self.image.get_rect(topleft=(x, y))


    def mover(self):
        self.rect.y += 5 #Velocidad del enemigo


    def dibujar(self, screen):
        screen.blit(self.image, self.rect.topleft)


class Laser:
    def __init__(self, x, y):
        self.image = pygame.image.load(f'{ASSETS_PATH}/imagenes/laser.png')
        self.rect = self.image.get_rect(center=(x, y))

    def mover(self):
        self.rect.y -= 10 #velocidad del laser

    def dibujar(self, screen):
        screen.blit(self.image, self.rect.topleft)






















